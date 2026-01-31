plugins {
    id("com.diffplug.spotless") version "6.25.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
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
