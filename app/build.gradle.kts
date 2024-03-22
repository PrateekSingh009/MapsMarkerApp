plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.mapsmarkerapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mapsmarkerapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true
        viewBinding = true
    }

}
secrets {
    propertiesFileName = "secrets.properties"

    defaultPropertiesFileName = "local.defaults.properties"

    ignoreList.add("keyToIgnore")
    ignoreList.add("sdk.*")
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    implementation("androidx.fragment:fragment-ktx:1.4.0")

    //Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //room
    implementation ("androidx.room:room-ktx:2.6.0")
    implementation( "androidx.room:room-common:2.6.0")
    implementation ("androidx.room:room-runtime:2.6.0")
    kapt ("androidx.room:room-compiler:2.6.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:dagger-android-processor:2.48.1")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Maps SDK for Android
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.2.0")
    implementation("com.google.maps.android:maps-utils-ktx:5.0.0")
}