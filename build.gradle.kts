buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.Dependencies.androidSupport)
        classpath(BuildPlugins.Dependencies.kotlinSupport)
        classpath(BuildPlugins.Dependencies.kotlinxSerialization)
        classpath(BuildPlugins.Dependencies.sonarCloud)
        classpath(BuildPlugins.Dependencies.dexCount)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    repositories {
        google()
        jcenter()
        flatDir {
            this.dir("../lib")
        }
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

plugins {
    `maven-publish`
    id(BuildPlugins.Ids.gitVersion) version "0.4.9"
}

// Used to ensure upgrading wrapper uses gradle-X.X-all distribution
tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}
