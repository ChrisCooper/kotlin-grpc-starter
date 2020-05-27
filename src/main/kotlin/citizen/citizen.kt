package citizen

import supply.Supply

class Citizen {

    companion object {
        private val citizens = mutableListOf<Citizen>()

        fun updateCitizens() {
            citizens.forEach{ c-> c.update()}

            val starvedCitizens = citizens.filter { c -> c.nutrition < 0 }
            //println("${starvedCitizens.size} citizens have starved")
            citizens.removeAll(starvedCitizens)
        }

        // Make a new citizen with random aptitudes and no skills
        fun random(): Citizen {
            val c = Citizen()
            Aptitude.values().forEach { ap -> c.aptitudes[ap] = ap.randomAptitude(ap) }
            Skill.values().forEach { sk -> c.skills[sk] =
                SkillLevel(0.0)
            }
            return c
        }
    }
    var id: Int = 0
    var birthdate: Int = 0

    var nutrition: Double = 0.0
    var money: Double = 0.0

    var current_activity : Skill = Skill.RESTING

    val aptitudes: MutableMap<Aptitude, AptitudeLevel> = mutableMapOf()
    val skills: MutableMap<Skill, SkillLevel> = mutableMapOf()
    val supplies: MutableMap<Supply, Int> = mutableMapOf()

    fun update() {
        nutrition -= current_activity.hourly_energy_expenditure
    }
}


//fun main() {
//    val citizens = mutableListOf(
//        citizen.Citizen.random(),
//        citizen.Citizen.random(),
//        citizen.Citizen.random(),
//    )
//
//    println(citizens.size)
//}





