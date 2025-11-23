plugins {
    alias(libs.plugins.movieverse.android.compose)
}

android {
    namespace = "com.prasadvennam.tmdb.design_system"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.material3)
    implementation(libs.readmore.material3)
    implementation(libs.cloudy)
    implementation(libs.androidx.appcompat)

}