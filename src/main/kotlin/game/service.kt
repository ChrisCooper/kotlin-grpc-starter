package game

import io.grpc.stub.StreamObserver
import primtech.General
import primtech.game.Game
import primtech.game.GameServiceGrpc
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque


class GameService(private val frameQueue: BlockingQueue<Game.FrameInfo>): GameServiceGrpc.GameServiceImplBase() {

    override fun streamFrames(request: General.Void, responseObserver: StreamObserver<Game.FrameInfo>) {

        while (true) {
            val recentFrame = frameQueue.take()
            responseObserver.onNext(recentFrame)
        }

        // responseObserver.onCompleted()
    }
}
