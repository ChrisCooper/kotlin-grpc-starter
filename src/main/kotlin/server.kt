import io.grpc.Server
import io.grpc.ServerBuilder
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

fun main() {
    println("Starting CitizenServer")

    val server: CitizenServer = CitizenServer(8980)
    server.start();
    server.blockUntilShutdown();
}

class CitizenServer(private val port: Int) {
    private val logger = Logger.getLogger(CitizenServer::class.java.name)

    private val citizenService = CitizenService()

    private val server: Server = ServerBuilder.forPort(port).addService(citizenService).build();

    fun start() {
        server.start()
        logger.info("Server started listening on port $port")

        Runtime.getRuntime().addShutdownHook(Thread {
            System.err.println("*** shutting down gRPC server since JVM is shutting down")

            try {
                this@CitizenServer.stop();
            } catch (e: InterruptedException) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        })
    }

    /** Stop serving requests and shutdown resources. */
    @Throws(InterruptedException::class)
    fun stop() {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS)
    }

    /** Await termination on the main thread since the grpc library uses daemon threads. */
    @Throws(InterruptedException::class)
    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}
