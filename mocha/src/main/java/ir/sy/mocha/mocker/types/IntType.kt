package ir.sy.mocha.mocker.types

enum class IntType  {
    Price,
    Id,
    TimeStamp,
    Count,
    Measurement,
    Year,
    Month,
    Day,
    Age,
    Boolean,
    Rank,
    Undefined,
    Custom;

    companion object {
        fun fromString(name: String): IntType? {
            return entries.find { it.name.equals(name, ignoreCase = true) }
        }
    }
}