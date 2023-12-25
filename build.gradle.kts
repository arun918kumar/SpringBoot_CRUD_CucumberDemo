plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.1")

	testImplementation("io.cucumber:cucumber-java:7.12.0")
	testImplementation("io.cucumber:cucumber-junit:7.12.0")
	testImplementation("io.cucumber:cucumber-spring:7.12.0")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
