plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"
    
    defaultConfig {
        applicationId = "com.apk.builder"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0.0"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    packagingOptions {
        exclude("META-INF/DEPENDENCIES.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
    }
    
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
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