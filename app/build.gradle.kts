plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.bankingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bankingapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
    val roomVersion = "2.6.1"

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.compose.ui:ui:1.6.0")
    implementation ("androidx.compose.material:material:1.6.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.activity:activity-compose:1.8.2")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.6.0")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.6.0")

    //Splash screen
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Leak Canary
    debugImplementation ("com.squareup.leakcanary:leakcanary-android:2.8.1")

    //Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")

    //Room
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    kapt("androidx.room:room-compiler:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
//        annotationProcessor ("com.google.dagger:hilt-android-compiler:2.44")
    //Coroutine lifecycle scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

//    Dagger Hilt
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0")
    kapt ("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson Converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Hilt Navigation
    implementation("androidx.hilt:hilt-navigation:1.1.0")

    //Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.25.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.25.0")

}

kapt {
    correctErrorTypes =true
}