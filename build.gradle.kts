plugins {
    id("java-library")
    kotlin("jvm") version "1.9.0"
    id("maven-publish")
}

group = "com.sixtyninefourtwenty"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

java {
    withSourcesJar()
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.sixtyninefourtwenty"
                artifactId = "conflict-resolver"
                version = "1.0"

                from(components["java"])

                pom {
                    name.set("conflict-resolver")
                    description.set("Helper class to help resolve dataset conflicts in apps")

                    licenses {
                        license {
                            name.set("The MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set("unbiaseduser")
                            name.set("Dang Quang Trung")
                            email.set("quangtrung02hn16@gmail.com")
                            url.set("https://github.com/unbiaseduser")
                        }
                    }
                }
            }
        }
    }
}