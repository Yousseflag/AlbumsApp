plugins {
    id("kotlin")
}
dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.koinCore)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.slf4j)
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.coroutinesTest)
    testImplementation(Libraries.koinTest)
    testImplementation(Libraries.mockk)
}