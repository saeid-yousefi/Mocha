package ir.sy.mocha.mocker.types

enum class FloatType {
    Height,          // Example: height of a person or object
    Weight,          // Example: weight of a person or object
    Temperature,     // Example: temperature readings
    Speed,           // Example: speed measurements (e.g., car speed)
    Distance,        // Example: distance measurements (e.g., travel distance)
    Latitude,        // Example: geographical coordinates
    Longitude,       // Example: geographical coordinates
    Altitude,        // Example: altitude measurements
    Depth,           // Example: depth measurements (e.g., water depth)
    Volume,          // Example: volume measurements (e.g., liquid volume)
    Area,            // Example: area measurements (e.g., land area)
    Density,         // Example: density measurements
    Pressure,        // Example: atmospheric or other pressure measurements
    Humidity,        // Example: humidity levels
    Angle,           // Example: angular measurements (e.g., angles in degrees)
    Duration,        // Example: time durations (e.g., duration in seconds)
    Rating,          // Example: rating scores (e.g., product ratings)
    Percentage,      // Example: percentage values
    ExchangeRate,    // Example: currency exchange rates
    Custom,    // Example: currency exchange rates
    Undefined;       // Fallback for unspecified types

    companion object {
        fun fromString(name: String): FloatType? {
            return entries.find { it.name.equals(name, ignoreCase = true) }
        }
    }
}