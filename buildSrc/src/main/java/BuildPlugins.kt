import configs.KotlinConfig

object BuildPlugins {

    object Dependencies {
        const val androidSupport = "com.android.tools.build:gradle:${Versions.agp}"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}"
        const val detektFormatting =
            "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}"
        const val dexCount = "com.getkeepsafe.dexcount:dexcount-gradle-plugin:${Versions.dexCount}"
        const val kotlinSupport =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinConfig.version}"
        const val kotlinxSerialization =
            "org.jetbrains.kotlin:kotlin-serialization:${KotlinConfig.version}"
        const val screenshotsTests =
            "com.facebook.testing.screenshot:plugin:${Versions.screenshotsTests}"
        const val shot = "com.karumi:shot:${Versions.shot}"
        const val sonarCloud =
            "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${Versions.sonarCloud}"
    }

    object Ids {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val buildSrcVersions = "de.fayard.buildSrcVersions"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val gitVersion = "com.gladed.androidgitversion"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val kotlinJVM = "kotlin"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlinxSerialization = "kotlinx-serialization"
        const val sonarCloud = "org.sonarqube"
    }

    private object Versions {
        const val agp = "3.5.3"
        const val detekt = "1.5.0"
        const val dexCount = "0.8.6"
        const val screenshotsTests = "0.10.0"
        const val shot = "3.0.2"
        const val sonarCloud = "2.7.1"
    }
}
