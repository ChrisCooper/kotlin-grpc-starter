package game

import citizen.Citizen
import primtech.game.Game
import java.time.Duration
import java.time.Instant
import java.util.concurrent.BlockingQueue
import java.util.logging.Logger

class GameLoop(private val frameQueue: BlockingQueue<Game.FrameInfo>) {
    private val logger = Logger.getLogger(GameLoop::class.java.name)

    @Volatile var isPaused = true;
    var currentFrameNumber: Long = 0;

    // 1 game-day per second
    val tick_target_runtime = Duration.ofNanos(1_000_000_000 / 24)

    fun enterMainLoop() {
        logger.info("Entering game loop")
        while (true) {
            synchronized(this) {
                runSingleGameCycle()
            }

            // Actions may only be taken between game frames
            if (isPaused) {
                Thread.sleep(100);
            }
        }
    }

    fun runSingleGameCycle() {
        val frame_start_time = Instant.now()

        Citizen.updateCitizens()
        Thread.sleep(1)

        val frame_end_time = Instant.now()
        val frame_time = Duration.between(frame_start_time, frame_end_time)

        val frame_percentage = (frame_time.nano * 1.0 / tick_target_runtime.nano)
        //logger.info("Frame took ${frame_percentage}% of target runtime")

        val gameInfo = Game.FrameInfo.newBuilder()
            .setFrameNumber(currentFrameNumber)
            .setActualFrameTimeNanos(frame_time.toNanos())
            .setTargetFrameTimeNanos(tick_target_runtime.toNanos())
            .build()

        frameQueue.put(gameInfo)

        currentFrameNumber++;
    }
}
