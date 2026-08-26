plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.apk.builder"
    
    // Modernisierte Syntax: 'compileSdk' als Property statt als Funktion
    // Aktualisiert auf 34 (Android 14), da 30 veraltet ist.
    compileSdk = 34 
    
    // 'buildToolsVersion' kann komplett entfernt werden, das Android Gradle Plugin 
    // verwendet automatisch die optimal passende Version.

    defaultConfig {
        applicationId = "com.apk.builder"
        // Modernisierte Syntax
        minSdk = 26
        targetSdk = 34 
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
    // Falls du wirklich lokale JARs im libs-Ordner hast
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Modernisierte UI-Bibliotheken (aktuelle Versionen)
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    
    // HINWEIS: sdklib:25.3.0 ist extrem alt (von ca. 2017). 
    // Falls du die Android Tools zwingend brauchst, nutze eine aktuellere Version:
    implementation("com.android.tools:sdklib:31.4.2") 

    // Deine benötigten Bibliotheken aus unserem vorherigen Schritt:
    implementation("org.apache.commons:commons-compress:1.26.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0")
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.2")
    implementation("io.github.Rosemoe.sora-editor:language-java:0.23.2")
    implementation("com.github.angads25:filepicker:1.1.1")
}
