import com.google.protobuf.gradle.*

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

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:${protocVersion}" }

    generateProtoTasks.ofSourceSet("main").forEach{ task ->
        plugins {
        }
        println("TASKKK: ${task}")
    }

    plugins {

    }

//    plugins {
//        generateProtoTasks.ofSourceSet("main").forEach { task ->
//            println(task)
//            // grpc { artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}" }
//        }
//    }
}

// Inform IDEs like IntelliJ IDEA, Eclipse or NetBeans about the generated code.
//sourceSets {
//    main {
//        java {
//            srcDirs("build/generated/source/proto/main/grpc")
//            srcDirs("build/generated/source/proto/main/java")
//        }
//    }
//}

//tasks.clean {
    //delete(protobuf.generatedFilesBaseDir)
    //delete(protobuf.)
//}


// Custom task to copy proto-generated java files from build/ to src/
//tasks.register("syncGeneratedSources", Sync::class){
//    from("$buildDir/generated/source/proto/main")
//    into("$rootProject.projectDir/java/src")
//}
