plugins {
    id("java")
    kotlin("jvm") version "2.0.0"
}

group = "org.cneko.sparkle.core"
version = "0.0.1"

repositories {
    mavenCentral()
    maven{
        url = uri("https://repo.alessiodp.com/releases/")
    }
}

dependencies {
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.11.0")
    // https://mvnrepository.com/artifact/org.yaml/snakeyaml
    implementation("org.yaml:snakeyaml:2.2")
    // https://mvnrepository.com/artifact/net.byteflux/libby-core
    implementation("net.byteflux:libby-core:1.3.0")
    // https://mvnrepository.com/artifact/org.realityforge.org.jetbrains.annotations/org.jetbrains.annotations
    implementation("org.realityforge.org.jetbrains.annotations:org.jetbrains.annotations:1.7.0")
    implementation(kotlin("stdlib-jdk8"))


}
kotlin {
    jvmToolchain(11)
}