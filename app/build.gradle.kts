plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.apk.builder"
    compileSdk = 34 

    defaultConfig {
        applicationId = "com.apk.builder"
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
    // --- 1. Moderne AndroidX & UI Komponenten ---
    // (Diese ziehen automatisch viewpager, drawerlayout, lifecycle, savedstate etc. nach sich)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.8.1")

    // --- 2. Google Guava (ersetzt den 'guava-30.1.1-jre' Ordner) ---
    implementation("com.google.guava:guava:33.2.1-android")

    // --- 3. Android Build Tools & Bundletool ---
    // (Ersetzt die Ordner 'common', 'bundletool' und 'sdklib')
    implementation("com.android.tools:common:31.4.2")
    implementation("com.android.tools:sdklib:31.4.2")
    implementation("com.android.tools.build:bundletool:1.15.6")

    // --- 4. ASM Support für Bytecode-Verarbeitung ---
    // (Ersetzt den 'asmsupport' Ordner)
    implementation("org.ow2.asm:asm:9.7")
    implementation("org.ow2.asm:asm-commons:9.7")

    // --- 5. Deine Projekt-spezifischen Bibliotheken (wie zuvor besprochen) ---
    implementation("org.apache.commons:commons-compress:1.26.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0")
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.2")
    implementation("io.github.Rosemoe.sora-editor:language-java:0.23.2")
    implementation("com.github.angads25:filepicker:1.1.1")
}
