import Versions.APPLICATION_ID
import Versions.COMPILE_SDK
import Versions.MIN_SDK
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}


android {
    compileSdkVersion(COMPILE_SDK)

    defaultConfig {
        applicationId = APPLICATION_ID
        minSdkVersion(MIN_SDK)
        targetSdkVersion(COMPILE_SDK)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "com.ainsigne.personsapp.HiltRunnerTest"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions("personsapp")
    productFlavors {
        create("prod") {
            dimension = "personsapp"
            applicationId("com.ainsigne.personsapp")
            versionNameSuffix("")
        }
        create("mock") {
            dimension = "personsapp"
            applicationId("com.ainsigne.personsapp")
            versionNameSuffix("_mock")
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

androidComponents {
    beforeVariants { variantBuilder ->

        // To check for a certain build type, use variantBuilder.buildType == "<buildType>"
        if (variantBuilder.productFlavors.containsAll(listOf("personsapp" to "prod")) && variantBuilder.buildType == "debug") {
            // Gradle ignores any variants that satisfy the conditions above.
            variantBuilder.enabled = false
        }
        if (variantBuilder.productFlavors.containsAll(listOf("personsapp" to "mock")) && variantBuilder.buildType == "release") {
            // Gradle ignores any variants that satisfy the conditions above.
            variantBuilder.enabled = false

        }

    }
}


dependencies {
    implementation(project(":ui"))
    api(project(":utilities"))
    implementation(project(":data"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.materialDesign)
    implementation(Libraries.androidLegacySupport)
    implementation(Libraries.supportAnnotation)
    implementation(Libraries.fragmentKtx)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGson)
    implementation(Libraries.httpLogging)

    implementation(Libraries.appInspectorRuntime)

    implementation(Libraries.navFragment)
    implementation(Libraries.navUi)

    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(Libraries.kaptRoom)

    implementation(Libraries.coreKtx)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesKotlinx)
    implementation(Libraries.liveData)
    implementation(Libraries.appInspectorRuntime)

    implementation(Libraries.viewModelKtx)

    implementation(Libraries.hiltDagger)
    kapt(Libraries.hiltDaggerKaptCompiler)
    implementation(Libraries.hiltViewModel)
    kapt(Libraries.kaptAndroidXCompiler)
    implementation(Libraries.lifecycleRuntime)


    testImplementation(Libraries.junitTestImp)
    testImplementation(Libraries.coroutineTestImp)
    testImplementation(Libraries.archCoreTestImp)
    testImplementation(Libraries.hiltDaggerTestImp)
    testImplementation(Libraries.junitRunner)
    testImplementation(Libraries.coroutineTest)

    androidTestImplementation(Libraries.coroutineTest)
    androidTestImplementation(Libraries.runnerAndroidTestImp)
    androidTestImplementation(Libraries.expressoCoreAnroidTestImp)
    androidTestImplementation(Libraries.junitRunner)
}
