plugins {
    java
    kotlin("jvm") version "1.4-M1"
    id("com.google.protobuf") version "0.8.8"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // gRPC
    implementation("io.grpc", "grpc-netty-shaded", "1.29.0")
    implementation("io.grpc", "grpc-protobuf", "1.29.0")
    implementation("io.grpc", "grpc-stub", "1.29.0")

    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.languageVersion = "1.4"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
