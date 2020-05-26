package game

import citizen.Citizen
import java.time.Duration
import java.time.Instant
import java.util.logging.Logger

class GameLoop {
    private val logger = Logger.getLogger(GameLoop::class.java.name)

    @Volatile var isPaused = true;

    // 1 game-day per second
    val tick_target_runtime = Duration.ofNanos(1_000_000_000 / 24)

    fun mainLoop() {
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

        val frame_end_time = Instant.now()
        val frame_time = Duration.between(frame_start_time, frame_end_time)

        val frame_percentage = (frame_time.nano * 1.0 / tick_target_runtime.nano)
        logger.info("Frame took ${frame_percentage}% of target runtime")
    }
}
