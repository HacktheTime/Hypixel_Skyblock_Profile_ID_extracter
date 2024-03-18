plugins {
    idea
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.hype.bbsentials.profileidfromlogs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.hypixel.net/repository/Hypixel/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(files("lib/intellij_forms_rt.jar"))
    implementation("net.hypixel:hypixel-api-transport-reactor:4.4")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] =
            "de.hype.bbsentials.profileidfromlogs.Main" // Replace 'com.example.MainKt' with the fully qualified name of your main Kotlin file
    }
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] =
            "de.hype.bbsentials.profileidfromlogs.Main" // Replace 'com.example.MainKt' with the fully qualified name of your main Kotlin file
    }
}
tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf("-source", "17", "-target", "17"))
}
tasks.test {
    useJUnitPlatform()
}

