plugins {
    alias(libs.plugins.android.application)
}

android {
    compileSdkVersion(30)
    //buildToolsVersion = "30.0.3"
    namespace = "com.apk.builder"

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
    
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    
    packaging {
        resources.excludes.add("META-INF/DEPENDENCIES.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/LICENSE.txt")
    }
    
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("com.android.tools:sdklib:25.3.0")
    implementation("com.android.tools:r8:2.2.64")
    implementation("org.eclipse.jdt.core.compiler:ecj:4.6.1")

    // Apache Commons Compress
    implementation("org.apache.commons:commons-compress:1.26.0") // Aktuellste Version prüfen

    // Eclipse LSP4J (Language Server Protocol)
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0") // Aktuellste Version prüfen

    // Rosemoe Sora Editor
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.2") // Aktuellste Version prüfen
    implementation("io.github.Rosemoe.sora-editor:language-java:0.23.2")

    // Angads25 FilePicker (benötigt JitPack Repository)
    implementation("com.github.angads25:filepicker:1.1.1") 
}
