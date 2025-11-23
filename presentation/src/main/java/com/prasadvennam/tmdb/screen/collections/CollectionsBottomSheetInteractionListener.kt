package com.prasadvennam.tmdb.screen.collections

interface CollectionsBottomSheetInteractionListener {
    fun onShowCollectionsBottomSheet(show: Boolean)
    fun onAddNewCollectionClick()
    fun onCollectionClicked(collectionId: Int)
    fun onCreateCollectionClicked()
    fun onRefresh()
    fun navigateToLogin()
}