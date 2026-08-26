plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.apk.builder"
    compileSdk = 30

    defaultConfig {
        applicationId = "com.apk.builder"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    
    packagingOptions {
        exclude("META-INF/DEPENDENCIES.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
    }
    
    dependenciesInfo {
        isIncludeInApk = false
        isIncludeInBundle = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("com.android.tools:sdklib:25.3.0")
    implementation("com.android.tools:r8:2.2.64")
    implementation("org.eclipse.jdt.core.compiler:ecj:4.6.1")
}