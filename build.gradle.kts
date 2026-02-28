plugins {
    id("java")
    alias(libs.plugins.spotless)
    alias(libs.plugins.lombok) apply false
    alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    apply(plugin = "com.diffplug.spotless")

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        java {
            googleJavaFormat()
            importOrder()
            removeUnusedImports()
        }

        kotlin {
            target("src/**/*.kt")
            ktlint(libs.versions.ktlint.get()).editorConfigOverride(
                mapOf("indent_size" to 4, "ij_kotlin_packages_import_layout" to "*")
            )
        }
    }

    tasks.named("assemble").configure {
        dependsOn("spotlessApply")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java-library")

    dependencies {
        constraints {
            add("implementation", rootProject.libs.commons.text)
        }

        add("testImplementation", rootProject.libs.junit.jupiter)
        add("testRuntimeOnly", rootProject.libs.junit.platform.launcher)
    }

    configure<JavaPluginExtension> {
        toolchain {
            languageVersion = JavaLanguageVersion.of(rootProject.libs.versions.java.get().toInt())
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configure(listOf(project(":app"))) {
    apply(plugin = "application")
}