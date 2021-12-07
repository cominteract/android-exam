import Versions.COMPILE_SDK
import Versions.TARGET_SDK
import Versions.MIN_SDK

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(COMPILE_SDK)

    defaultConfig {
        minSdkVersion(MIN_SDK)
        targetSdkVersion(TARGET_SDK)
        // apply the pro guard rules for library
        consumerProguardFiles("consumer-rules.pro")
    }
    flavorDimensions("personsapp")
    productFlavors {
        create("prod") {
            dimension = "personsapp"
        }
        create("stg") {
            dimension = "personsapp"
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
        dataBinding = true
        viewBinding = true
    }
    testOptions.unitTests.isIncludeAndroidResources = true
}


dependencies {


    api(project(":domain"))

    implementation(Libraries.coreKtx)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesKotlinx)
    implementation(Libraries.kotlinSerializationJson)
    implementation(Libraries.retrofitGson)
    implementation(Libraries.dataStorePreference)
    implementation(Libraries.hiltDagger)
    kapt(Libraries.hiltDaggerKaptCompiler)

    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    kapt(Libraries.kaptRoom)

    testImplementation(Libraries.junitTestImp)
}