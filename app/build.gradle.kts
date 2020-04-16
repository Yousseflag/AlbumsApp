import configs.AndroidConfig
import configs.KotlinConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("com.getkeepsafe.dexcount")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.gladed.androidgitversion")
    `maven-publish`
}

androidGitVersion {
    format = "%tag%"
    hideBranches = listOf("master", "develop")
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)
    buildToolsVersion(AndroidConfig.buildToolsVersion)
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        versionCode = androidGitVersion.code()
        versionName = androidGitVersion.name()
        testInstrumentationRunner = AndroidConfig.instrumentationTestRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = KotlinConfig.targetJVM
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    // Workaround for bug (https://github.com/Kotlin/kotlinx.coroutines/issues/1064)
    // To remove once fixed (expected in Kotlin 1.3.40 & AS 3.5)
    packagingOptions {
        pickFirst("META-INF/atomicfu.kotlin_module")
    }
}

dependencies {

    // Project Modules
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":api"))

    // Kotlin
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)

    // AndroidX
    implementation(Libraries.activity)
    implementation(Libraries.coreAndroidx)
    implementation(Libraries.fragmentKtx)
    implementation(Libraries.archCoreRuntime)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.appCompat)
    implementation(Libraries.fragment)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.swipeRefreshLayout)
    implementation(Libraries.recyclerView)
    implementation(Libraries.materialDesign)

    // Koin (Dependency Injection)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinViewModel)
    implementation(Libraries.tinderStateMachine)
    implementation(Libraries.timber)
    implementation(Libraries.slf4jTimber)

    // glide (media management and image loader )
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // Real LeakCanary for debug builds only: notifications, analysis, etc
    debugImplementation(Libraries.leakCanary)

    // Unit Testing
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.mockk)
    testImplementation(Libraries.archCoreTesting)
    testImplementation(Libraries.koinTest)
    testImplementation(Libraries.roboletric)

    // Instrumentation Testing
    androidTestImplementation(Libraries.androidTestRunner)
    androidTestImplementation(Libraries.androidTestExtJunit)
    androidTestImplementation(Libraries.androidTestCore)
    androidTestImplementation(Libraries.androidTestExtJunitKtx)
    androidTestImplementation(Libraries.archCoreTesting)
    androidTestImplementation(Libraries.mockk)
    androidTestImplementation(Libraries.koinTest)
    androidTestImplementation(Libraries.androidTestRules)
    androidTestImplementation(Libraries.espressoCore)
    androidTestImplementation(Libraries.espressoContrib)
}


