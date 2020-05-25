package util

import java.util.*

val global_random = Random()

fun zeroOneNormalRandom(rand: Random): Double {
    return rand.nextGaussian() * 0.5 + 1.0
}
