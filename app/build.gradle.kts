plugins {
    alias(libs.plugins.lombok)
}

dependencies {
    implementation(libs.commons.text)
    implementation(project(":utilities"))
    implementation(libs.langchain4j.openai)
    implementation(libs.langchain4j.anthropic)
    implementation(platform(libs.langchain4j.bom))
    implementation(libs.logback.classic)
    implementation(libs.kotlin.logging)
}

application {
    mainClass = "org.example.app.AppKt"
}
