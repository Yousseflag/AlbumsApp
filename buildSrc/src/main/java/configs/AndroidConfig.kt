package configs

object AndroidConfig {

    const val groupId = "lbc.testech"
    const val artifactId = "albumsapp"
    const val applicationId = "$groupId.$artifactId"

    const val compileSdk = 28
    const val minSdk = 19
    const val targetSdk = compileSdk

    const val buildToolsVersion = "29.0.2"

    const val instrumentationTestRunner = "androidx.test.runner.AndroidJUnitRunner"
}