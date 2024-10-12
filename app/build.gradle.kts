plugins {
    alias(libs.plugins.android.application) version "8.6.0" // Asegúrate de que esta versión sea compatible y actualizada
    alias(libs.plugins.kotlin.android) version "1.9.0" // Actualizado a la última versión de Kotlin
}

android {
    namespace = "com.example.myaplicacion01"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myaplicacion01"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11 // Actualizado a Java 11
        targetCompatibility = JavaVersion.VERSION_11 // Actualizado a Java 11
    }

    kotlinOptions {
        jvmTarget = "11" // Actualizado a JVM 11 para Kotlin
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Dependencia para Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.2")
    implementation("androidx.compose.material3:material3:1.2.0") // Versión estable más reciente

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
