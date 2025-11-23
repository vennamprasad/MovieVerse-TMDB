package com.prasadvennam.tmdb.screen.my_collections.create_collection_dialog

import com.prasadvennam.tmdb.base.BaseViewModel
import com.prasadvennam.domain.usecase.collection.AddNewCollectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateCollectionDialogViewModel @Inject constructor(
    private val createNewCollection: AddNewCollectionUseCase,
) :
    BaseViewModel<CreateCollectionDialogUiState, CreateCollectionDialogEvent>(
        CreateCollectionDialogUiState()
    ), CreateCollectionDialogInteractionListener {

    override fun onCancelClick() {
        sendEvent(CreateCollectionDialogEvent.OnCancelCollectionCreation)
    }

    override fun onCreateClick() {
        launchWithResult(
            action = {
                createNewCollection(
                    collectionName = uiState.value.collectionName,
                    collectionDescription = ""
                )
            },
            onSuccess = ::onCollectionSAddedSuccessfully,
            onError = ::onAddCollectionFailed,
            onStart = { updateState { it.copy(isLoading = true) } },
            onFinally = {}
        )
    }

    private fun onCollectionSAddedSuccessfully(collectionId: Int) {
        updateState { it.copy(isLoading = false, collectionId = collectionId) }
        sendEvent(CreateCollectionDialogEvent.OnCollectionAddedSuccessfully)
    }

    private fun onAddCollectionFailed(error: Int) {
        updateState { it.copy(isLoading = false) }
        sendEvent(CreateCollectionDialogEvent.OnAddCollectionFailed(error))
    }


    override fun onCollectionNameChange(name: String) {
        updateState {
            it.copy(
                collectionName = name
            )
        }
    }
}