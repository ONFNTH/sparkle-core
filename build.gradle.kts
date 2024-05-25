import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    kotlin("jvm") version "2.0.0"
    id ("com.github.johnrengelman.shadow") version "8.1.1"
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
    implementation(fileTree("libs"))
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.11.0")
    // https://mvnrepository.com/artifact/org.yaml/snakeyaml
    implementation("org.yaml:snakeyaml:2.2")
    // https://mvnrepository.com/artifact/net.byteflux/libby-core
    implementation("net.byteflux:libby-core:1.3.0")
    // https://mvnrepository.com/artifact/org.realityforge.org.jetbrains.annotations/org.jetbrains.annotations
    implementation("org.realityforge.org.jetbrains.annotations:org.jetbrains.annotations:1.7.0")
    // https://mvnrepository.com/artifact/com.google.guava/guava
    implementation("com.google.guava:guava:33.2.0-jre")


    implementation(kotlin("stdlib-jdk8"))


}
kotlin {
    jvmToolchain(11)
}

tasks.withType<ShadowJar> {
    archiveFileName.set("sparkle-core.jar")
    manifest {
        attributes(mapOf("Main-Class" to "org.sparklely.sparkle.core.Main"))
    }
    dependencies{
        include(dependency("net.byteflux:libby-core:1.3.0"))
    }
}
