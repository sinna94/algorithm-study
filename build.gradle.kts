plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("jacoco")
}

group "programmers"
version "1.0-SNAPSHOT"

jacoco{
    toolVersion = "0.8.5"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test{
        useJUnitPlatform()
    }
    jacocoTestReport {
        reports{
            xml.isEnabled = true
            html.isEnabled = true
        }
    }
}

