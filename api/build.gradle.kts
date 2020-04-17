import modules.LibraryModule
import modules.LibraryType

val module = LibraryModule(rootDir, LibraryType.Android)

apply(from = module.script())

plugins {
    id(BuildPlugins.Ids.androidLibrary)
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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
