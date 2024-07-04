# Mocha

![mocha](https://github.com/saeid-yousefi/Mocha/assets/66521658/2a92f925-9a27-46ac-aa31-5cdccd22ff72)

[![Build](https://github.com/saeid-yousefi/Mocha/actions/workflows/build.yml/badge.svg)](https://github.com/saeid-yousefi/Mocha/actions/workflows/build.yml)
[![Measure Test coverage](https://github.com/saeid-yousefi/Mocha/actions/workflows/test-code-coverage.yml/badge.svg)](https://github.com/saeid-yousefi/Mocha/actions/workflows/test-code-coverage.yml)
[![Publish Documentation](https://github.com/saeid-yousefi/Mocha/actions/workflows/deploy-docs.yml/badge.svg)](https://github.com/saeid-yousefi/Mocha/actions/workflows/deploy-docs.yml)

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
    implementation 'com.github.saeid-yousefi:Mocha:[latest_release_version]'
}
```

## Usage
To use Mocha, simply annotate your data class fields with the provided annotations and call the mock function. Here's an example:

## Example Data Classes
```
data class User(
    val id: Int,
    val income: Int,
    val name: String,
    val username: String,
    val email: String,
    @MockLong(type = LongType.Timestamp) val ts: Long,
    @MockString(defaultValue = "hello world") val string: String,
    val address: Address
)

```

## Generating Mock Data
```
 mockedModel = mock(language = Languages.English, clazz = User::class)
```

## Output
``` 
User(id=143,income=1200,name="John Wick", username="jw2024",email="jw2024@hotmail.com",ts=1720087364437,string="hello world",address=(city="Otava"))
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

