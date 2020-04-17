import modules.LibraryModule
import modules.LibraryType

plugins {
    id(BuildPlugins.Ids.androidLibrary)
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

val module = LibraryModule(rootDir, LibraryType.Android)

apply(from = module.script())

dependencies {
    implementation(project(":domain"))
    implementation(project(":api"))
    implementation(project(":networking"))
    implementation(project(":db"))
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.koinCore)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.slf4j)
}
