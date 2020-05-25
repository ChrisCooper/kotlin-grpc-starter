package citizen

import util.global_random
import util.zeroOneNormalRandom

inline class AptitudeLevel(val value: Double)
enum class Aptitude(private val mean: AptitudeLevel) {

    DETAIL_WORK(AptitudeLevel(0.33)),
    BRUTE_STRENGTH(AptitudeLevel(0.33)),
    PLANNING(AptitudeLevel(0.33)),
    FOCUS(AptitudeLevel(0.33));

    fun randomAptitude(ap: Aptitude): AptitudeLevel {
        // TODO: Aptitudes should follow a skew normal distribution
        return AptitudeLevel(
            zeroOneNormalRandom(
                global_random
            ) * ap.mean.value
        )
    }
}