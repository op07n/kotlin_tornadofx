plugins {
    application
    kotlin("jvm") version "1.3.0"

    // We need the javafx plugin since java 11
    id("org.openjfx.javafxplugin") version "0.0.7"
}
dependencies {
    compile(kotlin("stdlib-jdk8"))

    // Add the tornadofx dependency
    compile("no.tornado:tornadofx:1.7.17")
}
repositories {
    mavenCentral()
}

javafx {

    // Declare the javafx modules we need to use
    modules("javafx.controls")
}

application {

    // Declare the main class for the application plugin
    mainClassName = "de.klg71.tornado.MainKt"
}

 
//tasks.withType(Jar::class) {
//    manifest {
//        attributes["Manifest-Version"] = "1.0"
//        attributes["Main-Class"] = "de.klg71.tornado.MainKt"
//        attributes["Author"] = "sdfaffdasf"
//    }
//}






//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}

val fatJar = task("fatJar", type = Jar::class) {
    baseName = project.name
    manifest {
        attributes["Implementation-Title"] = "Guessing Game"
        attributes["Implementation-Version"] = "1.0"
        attributes["Main-Class"] = "de.klg71.tornado.MainKt"
    }
    from(configurations.runtime.map({ if (it.isDirectory) it else zipTree(it) }))
    with(tasks["jar"] as CopySpec)
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}























// Set the jvmTarget to 1.8 to support inlining
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }

