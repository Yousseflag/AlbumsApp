import modules.LibraryModule
import modules.LibraryType

val module = LibraryModule(rootDir, LibraryType.Kotlin)

apply(from = module.script())

plugins {
    id(BuildPlugins.Ids.kotlinJVM)
}

dependencies {
    implementation(project(":domain"))
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.kotlinSerialization)
    testImplementation(Libraries.coroutinesTest)
    testImplementation(Libraries.jUnit)
    api(Libraries.retrofit)
}
