package ir.sy.mocha.mocker.types

fun getIntType(variableName: String): IntType {
    val lowerCaseVariableName = variableName.lowercase()
    return when {
        lowerCaseVariableName.contains("id") -> IntType.Id

        lowerCaseVariableName.contains("price") -> IntType.Price
        lowerCaseVariableName.contains("cost") -> IntType.Price

        lowerCaseVariableName.contains("amount") -> IntType.Count
        lowerCaseVariableName.contains("total") -> IntType.Price
        lowerCaseVariableName.contains("quantity") -> IntType.Count
        lowerCaseVariableName.contains("count") -> IntType.Count
        lowerCaseVariableName.contains("stock") -> IntType.Count
        lowerCaseVariableName.contains("inventory") -> IntType.Count
        lowerCaseVariableName.contains("number") -> IntType.Count

        lowerCaseVariableName.contains("length") -> IntType.Measurement
        lowerCaseVariableName.contains("width") -> IntType.Measurement
        lowerCaseVariableName.contains("height") -> IntType.Measurement
        lowerCaseVariableName.contains("depth") -> IntType.Measurement
        lowerCaseVariableName.contains("weight") -> IntType.Measurement
        lowerCaseVariableName.contains("size") -> IntType.Measurement

        lowerCaseVariableName.contains("timestamp") -> IntType.TimeStamp
        lowerCaseVariableName.contains("createdAt") -> IntType.TimeStamp
        lowerCaseVariableName.contains("updatedAt") -> IntType.TimeStamp

        lowerCaseVariableName.contains("duration") -> IntType.TimeStamp
        lowerCaseVariableName.contains("spent") -> IntType.TimeStamp

        lowerCaseVariableName.contains("index") -> IntType.Count
        lowerCaseVariableName.contains("position") -> IntType.Count

        lowerCaseVariableName.contains("age") -> IntType.Age
        lowerCaseVariableName.contains("year") -> IntType.Year
        lowerCaseVariableName.contains("month") -> IntType.Month
        lowerCaseVariableName.contains("day") -> IntType.Day

        lowerCaseVariableName.contains("score") -> IntType.Rank
        lowerCaseVariableName.contains("rating") -> IntType.Rank
        lowerCaseVariableName.contains("level") -> IntType.Rank
        lowerCaseVariableName.contains("rank") -> IntType.Rank
        lowerCaseVariableName.contains("step") -> IntType.Rank
        lowerCaseVariableName.contains("version") -> IntType.Rank
        lowerCaseVariableName.contains("code") -> IntType.Rank
        lowerCaseVariableName.contains("errorCode") -> IntType.Rank
        lowerCaseVariableName.contains("status") -> IntType.Rank

        else -> IntType.Undefined
    }
}

fun getLongType(variableName: String): LongType {
    val lowerCaseVariableName = variableName.lowercase()
    return when {
        lowerCaseVariableName.contains("id") -> LongType.Id

        lowerCaseVariableName.contains("amount") -> LongType.Count
        lowerCaseVariableName.contains("total") -> LongType.Count
        lowerCaseVariableName.contains("quantity") -> LongType.Count
        lowerCaseVariableName.contains("count") -> LongType.Count
        lowerCaseVariableName.contains("stock") -> LongType.Count
        lowerCaseVariableName.contains("inventory") -> LongType.Count
        lowerCaseVariableName.contains("number") -> LongType.Count

        lowerCaseVariableName.contains("length") -> LongType.Size
        lowerCaseVariableName.contains("width") -> LongType.Size
        lowerCaseVariableName.contains("height") -> LongType.Size
        lowerCaseVariableName.contains("depth") -> LongType.Size
        lowerCaseVariableName.contains("weight") -> LongType.Size
        lowerCaseVariableName.contains("size") -> LongType.Size

        lowerCaseVariableName.contains("timestamp") -> LongType.Timestamp
        lowerCaseVariableName.contains("createdAt") -> LongType.Timestamp
        lowerCaseVariableName.contains("updatedAt") -> LongType.Timestamp

        lowerCaseVariableName.contains("duration") -> LongType.Timestamp
        lowerCaseVariableName.contains("spent") -> LongType.Timestamp

        lowerCaseVariableName.contains("index") -> LongType.Count
        lowerCaseVariableName.contains("position") -> LongType.Count


        else -> LongType.Undefined
    }
}

fun getStringType(variableName: String): StringType {
    val lowerCaseVariableName = variableName.lowercase()
    return when {
        lowerCaseVariableName.contains("username") -> StringType.Username
        lowerCaseVariableName.contains("user_name") -> StringType.Username
        lowerCaseVariableName.contains("user") && lowerCaseVariableName.contains("name") -> StringType.Username

        lowerCaseVariableName.contains("mail") -> StringType.Email

        lowerCaseVariableName.contains("password") -> StringType.Password
        lowerCaseVariableName.contains("passcode") -> StringType.Password
        lowerCaseVariableName.contains("passwd") -> StringType.Password

        lowerCaseVariableName.contains("address") -> StringType.Address
        lowerCaseVariableName.contains("addr") -> StringType.Address
        lowerCaseVariableName.contains("street") -> StringType.Address
        lowerCaseVariableName.contains("road") -> StringType.Address

        lowerCaseVariableName.contains("city") -> StringType.City
        lowerCaseVariableName.contains("town") -> StringType.City

        lowerCaseVariableName.contains("country") -> StringType.Country
        lowerCaseVariableName.contains("nation") -> StringType.Country

        lowerCaseVariableName.contains("phone") -> StringType.Phone
        lowerCaseVariableName.contains("mobile") -> StringType.Phone
        lowerCaseVariableName.contains("cell") -> StringType.Phone
        lowerCaseVariableName.contains("telephone") -> StringType.Phone

        lowerCaseVariableName.contains("url") -> StringType.Url
        lowerCaseVariableName.contains("link") -> StringType.Url
        lowerCaseVariableName.contains("web") -> StringType.Url

        lowerCaseVariableName.contains("description") -> StringType.Description
        lowerCaseVariableName.contains("desc") -> StringType.Description
        lowerCaseVariableName.contains("details") -> StringType.Description
        lowerCaseVariableName.contains("info") -> StringType.Description

        lowerCaseVariableName.contains("code") -> StringType.Code
        lowerCaseVariableName.contains("identifier") -> StringType.Code

        lowerCaseVariableName.contains("status") -> StringType.Status

        lowerCaseVariableName.contains("tag") -> StringType.Tag
        lowerCaseVariableName.contains("label") -> StringType.Label
        lowerCaseVariableName.contains("title") -> StringType.Description
        lowerCaseVariableName.contains("body") -> StringType.Description

        lowerCaseVariableName.contains("name") -> StringType.Name
        lowerCaseVariableName.contains("author") -> StringType.Description
        lowerCaseVariableName.contains("producer") -> StringType.Description

        lowerCaseVariableName.contains("gender") -> StringType.Gender
        lowerCaseVariableName.contains("sex") -> StringType.Gender

        else -> StringType.Undefined
    }
}

fun getFloatType(variableName: String): FloatType {
    val lowerCaseVariableName = variableName.lowercase()
    return when {
        lowerCaseVariableName.contains("height") -> FloatType.Height
        lowerCaseVariableName.contains("weight") -> FloatType.Weight
        lowerCaseVariableName.contains("temperature") -> FloatType.Temperature
        lowerCaseVariableName.contains("speed") -> FloatType.Speed
        lowerCaseVariableName.contains("distance") -> FloatType.Distance
        lowerCaseVariableName.contains("latitude") -> FloatType.Latitude
        lowerCaseVariableName.contains("longitude") -> FloatType.Longitude
        lowerCaseVariableName.contains("altitude") -> FloatType.Altitude
        lowerCaseVariableName.contains("depth") -> FloatType.Depth
        lowerCaseVariableName.contains("volume") -> FloatType.Volume
        lowerCaseVariableName.contains("area") -> FloatType.Area
        lowerCaseVariableName.contains("density") -> FloatType.Density
        lowerCaseVariableName.contains("pressure") -> FloatType.Pressure
        lowerCaseVariableName.contains("humidity") -> FloatType.Humidity
        lowerCaseVariableName.contains("angle") -> FloatType.Angle
        lowerCaseVariableName.contains("duration") -> FloatType.Duration
        lowerCaseVariableName.contains("rating") -> FloatType.Rating
        lowerCaseVariableName.contains("custom") -> FloatType.Custom
        lowerCaseVariableName.contains("percentage") -> FloatType.Percentage
        lowerCaseVariableName.contains("exchange_rate") -> FloatType.ExchangeRate
        else -> FloatType.Undefined
    }
}