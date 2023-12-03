plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion( 34)

    defaultConfig {
        applicationId = "com.application.vision"
        minSdkVersion(31)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // additional release configurations...
        }
        getByName("debug") {
            // debug configurations...
        }
        // additional build types...
    }
    aaptOptions {
        noCompress("tflite")
        noCompress("lite")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation (fileTree (mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:")
    implementation ("androidx.core:core-ktx:1.3.0")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.android.gms:play-services-tflite-gpu:16.2.0")
    implementation("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-runtime:2.4.0") // adjust version number if needed

    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.2.0")
    //CameraX
    implementation ("androidx.camera:camera-core:1.0.0-alpha02")
    implementation ("androidx.camera:camera-camera2:1.0.0-alpha02")
    // Task API
    implementation ("org.tensorflow:tensorflow-lite:2.8.0") // adjust version number if needed
    implementation ("com.google.mlkit:object-detection:17.0.0")
    implementation ("com.google.mlkit:face-detection:16.1.5")
    implementation ("com.google.mlkit:image-labeling:17.0.7")
    implementation ("org.tensorflow:tensorflow-lite-gpu:2.8.0")
}