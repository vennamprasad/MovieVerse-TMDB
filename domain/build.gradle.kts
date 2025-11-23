plugins {
    alias(libs.plugins.movieverse.kotlin)
    alias(libs.plugins.ksp)
    kotlin("kapt")
}

dependencies{
    //kotlin datetime
    implementation(libs.kotlinx.datetime)

    /** Dagger */
    implementation(libs.dagger.android)
    kapt(libs.dagger.compiler)

}
