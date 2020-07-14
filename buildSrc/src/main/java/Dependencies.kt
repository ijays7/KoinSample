object ApplicationId {
    const val id = "com.ijays.koinsample"
}

object Release {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = 29

    const val buildTools = "29.0.2"

    const val gradle = "4.0.0"
    const val kotlin = "1.3.72"

    const val appcompat = "1.1.0"
    const val design = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.1.0"

    const val koin = "2.0.1"
    const val koinFramgnet = "2.1.0-alpha-8"

    const val rxAndroid = "2.1.1"

    const val room = "2.2.3"

    const val junit = "4.12"

    const val androidx_test = "1.1.1"

    const val espresso = "3.2.0"

    const val hilt = "2.28-alpha"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val koinAndroid = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinFragment = "org.koin:koin-androidx-fragment:${Versions.koinFramgnet}"

    const val rxjava = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object Androidx {
    const val appcompt = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.design}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    const val androidxTest = "androidx.test.ext:junit:${Versions.androidx_test}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
}
