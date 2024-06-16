# Mocha

![image](https://github.com/saeid-injast/Mocha/assets/66521658/2788f7fd-f6f5-4746-a451-0c582dc6769f)

Read Full Documentation [Here](https://saeid-yousefi.github.io/Mocha/)

Mocha is an Android library designed to create custom fake data and mock data classes easily using annotations or variable names. It is particularly useful for testing and development purposes.

## Features

- Generate custom fake data using annotations.
- Support for various data types including String, Int, Long, Float, and more.
- Easily mock complex data classes and lists.
- Customizable data generation based on provided parameters.
- Reliable and realistic data generation.

## Installation

Add the following to your `build.gradle` (Project level):

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

```
## Add the dependency to your build.gradle (Module level):

```dependencies {
    implementation 'com.github.yourusername:mocha:1.0.0'
}
```

## Usage
To use Mocha, simply annotate your data class fields with the provided annotations and call the mock function. Here's an example:

## Example Data Classes
```
data class Foo(
    val name: String,
    val id: Int,
    val timestamp: Long,
    @MockInt(type = IntType.Price, min = 1, max = 1000, factor = 2) val idk2: Int,
    @MockString(defaultValue = "Hello world") val sth: String,
    @MockString(type = StringType.Custom, wordCount = 3) val loremIpsum: String,
    @MockLong(type = LongType.Custom, min = 1, max = 2_000_000_000L, factor = 2) val idk: Long,
    @MockFloat(type = FloatType.Custom, min = 1.0, max = 100.0, factor = 1.5f) val randomFloat: Float,
    val bar: List<Bar>
)

data class Bar(
    val isOk: Boolean,
    val city: String,
    val phone: String,
    val username: String,
    val password: String
)

```

## Generating Mock Data
```
val model = Mocha(context).mock<Foo>().toString()
println(model)
```

## Output
``` 
Foo(name=John Doe, id=65189, timestamp=936702652365, idk2=1005000, sth=Hello world, loremIpsum=Actions speak louder, idk=889789120, randomFloat=75.32, bar=[Bar(isOk=false, city=Sydney, phone=+998877665544, username=markjohnson2020, password=test1234), Bar(isOk=true, city=Los Angeles, phone=+198765432109, username=johndoe123, password=password2020)])
```

## Annotations

Mocha provides several annotations to customize the generated data:

- `@MockInt`: Generates a fake integer. Options:
    - `type`: Define the type of integer (e.g., `IntType.Price`).
    - `min`: Minimum value for the generated integer.
    - `max`: Maximum value for the generated integer.
    - `factor`: Multiplies the generated integer by this factor.
- `@MockString`: Generates a fake string. Options:
    - `defaultValue`: Sets a default value.
    - `type`: Define the type of string (e.g., `StringType.Name`).
    - `wordCount`: Number of words if type is Custom.
- `@MockLong`: Generates a fake long. Options:
    - `type`: Define the type of long (e.g., `LongType.Timestamp`).
    - `min`: Minimum value for the generated long.
    - `max`: Maximum value for the generated long.
    - `factor`: Multiplies the generated long by this factor.
- `@MockFloat`: Generates a fake float. Options:
    - `type`: Define the type of float (e.g., `FloatType.Density`).
    - `min`: Minimum value for the generated float.
    - `max`: Maximum value for the generated float.
    - `factor`: Multiplies the generated float by this factor.

## Custom Types

Mocha allows for custom types in annotations, providing flexibility in generating data that closely matches your needs. By setting the `type` parameter to `Custom`, you can specify additional attributes like `min`, `max`, and `factor` to control the data generation process.

## Customization

You can customize the data generation process by providing additional parameters to the annotations. This helps in generating more realistic and domain-specific fake data.

## License

Mocha is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any bugs, enhancements, or suggestions.

## Contact

For any questions or support, please open an issue or contact saeid.yousfei.1373@gmail.com.

