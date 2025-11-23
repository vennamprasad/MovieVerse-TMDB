plugins {
    alias(libs.plugins.movieverse.android.compose)
}

android {
    namespace = "com.prasadvennam.tmdb.image_viewer"
}

dependencies {

    implementation(libs.androidx.core.ktx)

    api(libs.coil3.compose)
    implementation(libs.cloudy)
    implementation(libs.tensorflow.lite)
}