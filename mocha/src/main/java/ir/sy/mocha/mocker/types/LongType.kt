package ir.sy.mocha.mocker.types

enum class LongType {
    Id,
    Timestamp,
    Count,
    Size,
    Undefined,
    Custom;

    companion object {
        fun fromString(name: String): LongType? {
            return entries.find { it.name.equals(name, ignoreCase = true) }
        }
    }
}