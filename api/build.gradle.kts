import modules.LibraryModule
import modules.LibraryType

val module = LibraryModule(rootDir, LibraryType.Kotlin)

apply(from = module.script())

plugins {
    id(BuildPlugins.Ids.kotlinJVM)
    id(BuildPlugins.Ids.kotlinxSerialization)
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":networking"))
    // Kotlin
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.kotlinSerialization)
    implementation(Libraries.retrofitKotlinSerialization)
    implementation(Libraries.koinCore)

    testImplementation(Libraries.androidTestCore)
    testImplementation(Libraries.coroutinesTest)
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.mockWebServer)
}
