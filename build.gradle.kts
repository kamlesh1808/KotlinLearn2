plugins {
    id("java")
    id("com.diffplug.spotless") version "8.2.1"
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
            ktlint("1.2.1").editorConfigOverride(
                mapOf("indent_size" to 4, "ij_kotlin_packages_import_layout" to "*")
            )
        }
    }

    // Run spotlessApply before assemble
    tasks.named("assemble").configure {
        dependsOn("spotlessApply")
    }
}