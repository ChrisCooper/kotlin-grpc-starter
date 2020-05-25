package citizen

inline class SkillLevel(val value: Double)
enum class Skill(
    private val mean: SkillLevel,
    val hourly_energy_expenditure: Double = 1.0
) {
    RESTING(SkillLevel(1.0), 0.5),
    FORAGING(SkillLevel(0.33)),
    HUNTING(SkillLevel(0.33)),
    STONE_KNIFE_MAKING(SkillLevel(0.33)),
    TRAPPING(SkillLevel(0.33)),
}