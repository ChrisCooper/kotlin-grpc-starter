import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    java
    kotlin("jvm") version "1.4-M1"
    idea
}

group = "primtech"
version = "1.0.0"

val grpcVersion = "1.29.0"
val protobufVersion = "3.11.0"
val protocVersion = protobufVersion

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // gRPC
    implementation("io.grpc", "grpc-netty-shaded", grpcVersion)
    implementation("io.grpc", "grpc-protobuf", grpcVersion)
    implementation("io.grpc", "grpc-stub", grpcVersion)

    testImplementation("junit", "junit", "4.12")

    compileOnly("org.apache.tomcat", "annotations-api", "6.0.53")

    runtimeOnly("io.grpc", "grpc-netty-shaded", grpcVersion)
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

val generate_grpc by tasks.registering(Exec::class) {
    commandLine("bin\\protoc.exe", "--plugin=protoc-gen-grpc-java=bin\\protoc-gen-grpc-java.exe", "--java_out=src/main/java", "--grpc-java_out=src/main/java", ".\\src\\main\\proto\\*")
}

val compileKotlin by tasks.getting
val compileJava by tasks.getting

compileJava.dependsOn(generate_grpc)
compileKotlin.dependsOn(generate_grpc)
