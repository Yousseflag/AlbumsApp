import configs.KotlinConfig

// Versions for project parameters and forEachDependency

object Libraries {

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KotlinConfig.version}"
    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinSerialization}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitKotlinSerialization =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinSerialization}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val coreAndroidx = "androidx.core:core-ktx:${Versions.coreAndroidx}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val archCoreRuntime = "androidx.arch.core:core-runtime:${Versions.archCore}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomAnnotation = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val preference = "androidx.preference:preference:${Versions.preference}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val coroutinesDebug = "org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.coroutines}"

    // Koin : Dependency injection library
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // Timber : Wrapper on Android Logger
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val slf4jTimber = "com.arcao:slf4j-timber:${Versions.slf4jTimber}"
    const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"

    const val androidTestCore = "androidx.test:core:${Versions.androidxTest}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val androidTestCoreKtx = "androidx.test:core-ktx:${Versions.androidxCoreKtx}"
    const val androidTestExtJunit = "androidx.test.ext:junit:${Versions.jUnitKtx}"
    const val androidTestExtJunitKtx = "androidx.test.ext:junit-ktx:${Versions.jUnitKtx}"
    const val androidTestRules = "androidx.test:rules:${Versions.androidxTest}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidxTest}"
    // Barista : Helper library to build espresso test faster
    const val barista = "com.schibsted.spain:barista:${Versions.barista}"
    // Burster : Kotlin helper for nicer Junit4 "parametrized" tests
    const val burster = "com.github.ubiratansoares:burster:${Versions.burster}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragmentTesting}"
    const val jUnit = "junit:junit:${Versions.junit}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val roboletric = "org.robolectric:robolectric:${Versions.roboletric}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"
    const val sharedPreferencesMock = "com.github.IvanShafran:shared-preferences-mock:${Versions.sharedPreferencesMock}"
    const val tinderStateMachine = "com.tinder.statemachine:statemachine:${Versions.tinderStateMachine}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    // Stetho : Debug Bridge
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    // Real LeakCanary for debug builds only: notifications, analysis, etc
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    private object Versions {
        const val activity = "1.1.0"
        const val androidxTest = "1.2.0"
        const val androidxCoreKtx = "1.2.0-rc01"
        const val appCompat = "1.1.0"
        const val archCore = "2.1.0"
        const val barista = "3.2.0"
        const val burster = "0.1.1"
        const val constraintLayout = "2.0.0-beta4"
        const val coordinatorLayout = "1.0.0"
        const val coreAndroidx = "1.2.0-rc01"
        const val coroutines = "1.3.3"
        const val espresso = "3.2.0"
        const val fragment = "1.2.0"
        const val fragmentKtx = "1.2.0"
        const val fragmentTesting = "1.2.0"
        const val jUnitKtx = "1.1.1"
        const val junit = "4.12"
        const val koin = "2.0.1"
        const val kotlinSerialization = "0.13.0"
        const val leakCanary = "2.1"
        const val lifecycle = "2.2.0"
        const val materialDesign = "1.1.0-rc02"
        const val mockk = "1.9.2"
        const val okHttp = "3.12.7"
        const val preference = "1.0.0"
        const val recyclerView = "1.1.0"
        const val retrofit = "2.6.4"
        const val retrofitKotlinSerialization = "0.4.0"
        const val roboletric = "4.3.1"
        const val room = "2.2.3"
        const val sharedPreferencesMock = "1.0"
        const val slf4j = "1.7.29"
        const val slf4jTimber = "3.1"
        const val stetho = "1.5.1"
        const val swipeRefreshLayout = "1.0.0"
        const val timber = "4.7.1"
        const val glide = "4.11.0"
        const val tinderStateMachine = "0.2.0"
    }
}
