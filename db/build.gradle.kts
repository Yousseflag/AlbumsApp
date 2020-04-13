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

android {
    kapt {
        arguments {
            arg("room.schemaLocation", """$projectDir/schemas""")
        }
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutinesCore)
    api(Libraries.room)
    implementation(Libraries.roomKtx)
    implementation(Libraries.slf4j)
    kapt(Libraries.roomAnnotation)

    testImplementation(Libraries.coroutinesTest)
    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.coroutinesTest)
    androidTestImplementation(Libraries.androidTestCore)
    androidTestImplementation(Libraries.androidTestExtJunit)
    androidTestImplementation(Libraries.roboletric)
}
