package ir.sy.mocha.mocker.types

enum class StringType {
    Name,
    Id,
    Email,
    Username,
    Password,
    Gender,
    Address,
    City,
    Country,
    Phone,
    Url,
    Description,
    Status,
    Code,
    Tag,
    Label,
    Undefined,
    Custom;

    companion object {
        fun fromString(name: String): StringType? {
            return entries.find { it.name.equals(name, ignoreCase = true) }
        }
    }
}