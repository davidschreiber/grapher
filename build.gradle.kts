import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Using Kotlin 1.3.50 since version 1.3.60 is not full compatible with coroutines and generates build errors in our tests.
    // Waiting for some version after 1.3.60 to see if it resolves the issue. Here's a related error with what happened during
    // the builds (not exact though): https://youtrack.jetbrains.com/issue/KT-34527
    kotlin("jvm") version "1.3.50"
}

group = "at.droiddave.grapher"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions { jvmTarget = "1.8" }
compileTestKotlin.kotlinOptions { jvmTarget = "1.8" }

dependencies {
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.0")
    testImplementation("org.slf4j:slf4j-log4j12:1.7.28")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}