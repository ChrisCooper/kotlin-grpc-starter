import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    java
    kotlin("jvm") version "1.4-M1"
    idea
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

// Custom task to copy proto-generated java files from build/ to src/
//tasks.register("syncGeneratedSources", Sync::class){
//    from("$buildDir/generated/source/proto/main")
//    into("$rootProject.projectDir/java/src")
//}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.0.0"
        // or
        // path = 'tools/protoc'
    }

    //generatedFilesBaseDir = "$projectDir/gen"

//    generateProtoTasks.ofSourceSet("main").forEach { task ->
//    }
}


tasks.clean {
    //delete(protobuf.generatedFilesBaseDir)
    //delete(protobuf.)
}