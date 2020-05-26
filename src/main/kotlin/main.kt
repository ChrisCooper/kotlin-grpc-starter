import citizen.CitizenService
import game.GameService

fun main() {
    println("Starting gRPC server")

    val port = 8980

    val citizenService = CitizenService()
    val gameService = GameService()

    val server = PrimTechServer(port, citizenService, gameService)
    server.start();
    server.blockUntilShutdown();
}