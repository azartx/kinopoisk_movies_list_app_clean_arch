plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.solo4.kinoapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.solo4.kinoapp"
        minSdk = 24
        targetSdk = 33
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
        viewBinding = true
    }
}

dependencies {

    /* ******************** Tests ********************* */
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Core library
    androidTestImplementation("androidx.test:core:1.5.0")

    // AndroidJUnitRunner and JUnit Rules
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")

    // Assertions
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.ext:truth:1.5.0")

    // Espresso dependencies
    androidTestImplementation( "androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation( "androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation( "androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation( "androidx.test.espresso:espresso-accessibility:3.5.1")
    androidTestImplementation( "androidx.test.espresso:espresso-web:3.5.1")
    androidTestImplementation( "androidx.test.espresso.idling:idling-concurrent:3.5.1")

    androidTestImplementation( "androidx.test.espresso:espresso-idling-resource:3.5.1")

    // paging tests
    testImplementation("androidx.paging:paging-common-ktx:3.2.1")

    /* \\\\\\\\\\\\\\\\\\\\\\\\\\\ End Tests ///////////////////////////// */

    // androidx
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    debugImplementation("androidx.fragment:fragment-testing:1.6.1")

    // paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-rxjava3:3.2.1")

    // dagger
    implementation("com.google.dagger:dagger-android:2.48")
    kapt("com.google.dagger:dagger-android-processor:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.7.0")

    // rx3
    implementation("io.reactivex.rxjava3:rxjava:3.1.6")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")

    // okhttp + retrofit + utils
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.4.0")
    implementation("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:2.7.1")

    // gson
    implementation("com.google.code.gson:gson:2.10.1")

    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // youtube webview player
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")
}