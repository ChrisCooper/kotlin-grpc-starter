package game

import io.grpc.stub.StreamObserver
import primtech.General
import primtech.game.Game
import primtech.game.GameServiceGrpc
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque


class GameService: GameServiceGrpc.GameServiceImplBase() {

    val frameQueue: BlockingQueue<Game.FrameInfo> = LinkedBlockingDeque()

    override fun streamFrames(request: General.Void, responseObserver: StreamObserver<Game.FrameInfo>) {

        while (true) {
            val frameInfo = Game.FrameInfo.newBuilder()
                .setFrameNumber(0)
                .setActualFrameTimeNanos(0)
                .setTargetFrameTimeNanos(0)
                .build()

            responseObserver.onNext(frameInfo)
            Thread.sleep(1000);
        }

        // responseObserver.onCompleted()
    }
}
