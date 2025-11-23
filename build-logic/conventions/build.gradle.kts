plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidLibraryConvention") {
            id = libs.plugins.movieverse.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidComposeLibraryConvention") {
            id = libs.plugins.movieverse.android.compose.get().pluginId
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }

        register("kotlinLibraryConvention") {
            id = libs.plugins.movieverse.kotlin.get().pluginId
            implementationClass = "KotlinLibraryConventionPlugin"
        }

        register("androidApplicationConvention") {
            id = libs.plugins.movieverse.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}