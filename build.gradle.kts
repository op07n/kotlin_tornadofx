import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	kotlin("jvm") version "1.3.0"
	id("application")
	id("org.openjfx.javafxplugin") version "0.0.7"
//	id("com.github.johnrengelman.shadow") version "5.1.0"
}

// val applicationVersion: String by project

group = "de.klg71.tornado"
version = "1.0"

java {
	sourceCompatibility = VERSION_11
	targetCompatibility = VERSION_11
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

//application {

    // Declare the main class for the application plugin
//    mainClassName = "de.klg71.tornado.MainKt"
//}

 
//tasks.withType(Jar::class) {
//    manifest {
//        attributes["Manifest-Version"] = "1.0"
//        attributes["Main-Class"] = "de.klg71.tornado.MainKt"
//        attributes["Author"] = "sdfaffdasf"
//    }
//}




//tasks.jar {
tasks.withType(Jar::class) {	
	manifest {
		attributes["Main-Class"] = "${project.group}.MainKt"
	}
}

application {
    mainClassName = "${project.group}.MainKt"
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}



// Set the jvmTarget to 1.8 to support inlining
// tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }

