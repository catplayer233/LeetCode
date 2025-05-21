plugins {
    id("java")
}

group = "org.catplayer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.5.18")
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
    testImplementation("org.junit.platform:junit-platform-launcher:1.12.2")
}


tasks.withType<JavaCompile> {

    options.compilerArgs.apply {
        add("--enable-preview")
//            add("-Xlint:preview")
    }

}

tasks.test {
    useJUnitPlatform()

    jvmArgs("--enable-preview")
}