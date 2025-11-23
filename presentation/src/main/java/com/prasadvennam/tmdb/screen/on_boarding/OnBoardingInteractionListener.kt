package com.prasadvennam.tmdb.screen.on_boarding

interface OnBoardingInteractionListener {
    fun onPageChanged(pageIndex: Int)
    fun onClickPreviousButton()
    fun onClickNextButton()
    fun onClickGetStartedButton()
}