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
        // JitPack ist extrem wichtig für den Angads25 FilePicker!
        maven { url = uri("https://jitpack.io") } 
    }
}

rootProject.name = "ApkBuilder"

include(":app")
