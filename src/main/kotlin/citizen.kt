import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import primtech.CitizenOuterClass
import primtech.CitizenServiceGrpc
import java.net.URL
import java.util.*

val global_random = Random()

fun zeroOneNormalRandom(rand: Random): Double {
    return global_random.nextGaussian() * 0.5 + 1.0
}


inline class AptitudeLevel(val value: Double)
enum class Aptitude(private val mean: AptitudeLevel) {

    DETAIL_WORK(AptitudeLevel(0.33)),
    BRUTE_STRENGTH(AptitudeLevel(0.33)),
    PLANNING(AptitudeLevel(0.33)),
    FOCUS(AptitudeLevel(0.33));

    fun randomAptitude(ap: Aptitude): AptitudeLevel {
        // TODO: Aptitudes should follow a skew normal distribution
        return AptitudeLevel(zeroOneNormalRandom(global_random) * ap.mean.value)
    }
}

inline class SkillLevel(val value: Double)
enum class Skill(private val mean: SkillLevel) {
    STONE_KNIFE_MAKING(SkillLevel(0.33)),
}

class Citizen {
    companion object {
        // Make a new citizen with random aptitudes and no skills
        fun random(): Citizen {
            val c = Citizen()
            Aptitude.values().forEach { ap -> c.aptitudes[ap] = ap.randomAptitude(ap) }
            Skill.values().forEach { sk -> c.skills[sk] = SkillLevel(0.0) }
            return c
        }
    }
    val aptitudes: MutableMap<Aptitude, AptitudeLevel> = mutableMapOf()
    val skills: MutableMap<Skill, SkillLevel> = mutableMapOf()

    var age = 0
}

//fun main() {
//    val citizens = mutableListOf(
//        Citizen.random(),
//        Citizen.random(),
//        Citizen.random(),
//    )
//
//    println(citizens.size)
//}


class CitizenService: CitizenServiceGrpc.CitizenServiceImplBase() {
    override fun getCitizen(
        request: CitizenOuterClass.Void,
        responseObserver: StreamObserver<CitizenOuterClass.Citizen>
    ) {
        val citizen: CitizenOuterClass.Citizen = CitizenOuterClass.Citizen.newBuilder().setId(12).setName("Bob").build()
        responseObserver.onNext(citizen)
        responseObserver.onCompleted()
    }
}


