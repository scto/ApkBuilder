pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://repo.gradle.org/gradle/libs-releases") }
        maven { url = uri("https://jitpack.io") } // WICHTIG!
    }
    }
}

rootProject.name = "ApkBuilder"

include(
    ":app"
)
