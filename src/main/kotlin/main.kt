import citizen.CitizenService
import game.GameLoop
import game.GameService
import primtech.game.Game
import java.util.concurrent.LinkedBlockingDeque
import java.util.logging.Logger
import kotlin.concurrent.thread

fun main() {
    val primtech = PrimTech()
    primtech.run()
}

class PrimTech {
    private val logger = Logger.getLogger(PrimTech::class.java.name)

    fun run() {
        logger.info("Starting gRPC server")

        val port = 8980

        val citizenService = CitizenService()

        val frameQueue = LinkedBlockingDeque<Game.FrameInfo>()
        val gameService = GameService(frameQueue)

        val server = PrimTechServer(port, citizenService, gameService)

        server.start();

        thread(start = true) {
            // Give some time for the server to start and connections to be made
            println("Running thread")
            Thread.sleep(2000)
            runGameLoop(frameQueue)
        }

        logger.info("gRPC server blocking until shutdown")
        server.blockUntilShutdown();
    }


    fun runGameLoop(frameQueue: LinkedBlockingDeque<Game.FrameInfo>) {
        val gameLoop = GameLoop(frameQueue)
        gameLoop.enterMainLoop()
    }
}