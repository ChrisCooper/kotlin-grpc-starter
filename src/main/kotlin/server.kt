import citizen.CitizenService
import game.GameService
import io.grpc.Server
import io.grpc.ServerBuilder
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class PrimTechServer(
    private val port: Int,
    private val citizenService: CitizenService,
    private val gameService: GameService,
) {
    private val logger = Logger.getLogger(PrimTechServer::class.java.name)

    private val server: Server = ServerBuilder.forPort(port)
        .addService(citizenService)
        .addService(gameService)
        .build();

    fun start() {
        server.start()
        logger.info("Server started listening on port $port")

        Runtime.getRuntime().addShutdownHook(Thread {
            logger.severe("*** shutting down gRPC server since JVM is shutting down")

            try {
                this@PrimTechServer.stop();
            } catch (e: InterruptedException) {
                e.printStackTrace(System.err);
            }
            logger.severe("*** server shut down");
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
