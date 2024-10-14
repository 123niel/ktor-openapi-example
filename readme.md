# Ktor OpenAPI Generator example

This project is a minimal working example for a Ktor API generated from an OpenAPI spec.

## Generate code

To regenerate the code, run

```shell
./gradlew openApiGenerate
```

All generated code relies in package `com.example.generated.openapi`

Look at [Routing.kt](src/main/kotlin/com/example/plugins/Routing.kt) to see how to use the generated code.

## Customize generation

If you need to change the generation templates, they can be obtained with the [CLI](https://openapi-generator.tech/docs/templating).
Put the changed templates in the directory `.openapi-generator/templates`

The following templates are changed in this project:

- `data_class.mustache`: annotate data classes with `@Serializable`
- `Paths.kt.mustache`: make all path-strings accessible via `Paths.OperationMap`


In [build.gradle.kts](build.gradle.kts) you can configure the generated code further, for example type mappings:

```kotlin
openApiGenerate {
    //...
    
    typeMappings.put("java.time.OffsetDateTime", "kotlinx.datetime.Instant")
}
```