plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
//    id("org.jetbrains.kotlin.plugin.noarg") version "2.0.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.2")
    implementation("com.querydsl:querydsl-jpa:5.1.0")
    implementation("com.querydsl:querydsl-apt:5.1.0")
//    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.7")
//    implementation("org.mybatis:mybatis-spring:3.0.3")
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.7")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.1")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation ("com.github.yulichang:mybatis-plus-join-boot-starter:1.4.13")
//    implementation("com.mybatis-flex:mybatis-flex-spring-boot-starter:1.9.6")
//    annotationProcessor("com.mybatis-flex:mybatis-flex-processor:1.9.6")
//    implementation("org.springframework.data:spring-data-jpa:3.3.3")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
