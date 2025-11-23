package com.prasadvennam.tmdb.screen.profile.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.prasadvennam.tmdb.designSystem.component.bottomsheet.MovieVerseBottomSheet
import com.prasadvennam.tmdb.designSystem.component.card.MessageInfoCard
import com.prasadvennam.tmdb.designSystem.theme.Theme
import com.prasadvennam.tmdb.presentation.R

@Composable
fun LogoutBottomSheet(
    visible: Boolean,
    onDismiss: () -> Unit,
    onLogoutClick: () -> Unit,
) {
    AnimatedVisibility(visible) {
        MovieVerseBottomSheet(
            onClose = onDismiss,
            onDismissRequest = onDismiss,
            showCancelIcon = false,
        ) {
            MessageInfoCard(
                title = stringResource(R.string.are_you_sure_you_want_to_logout),
                description = stringResource(R.string.you_can_always_sign_back_in_with_your_account),
                icon = painterResource(R.drawable.due_tone_logout),
                showButtonsGroup = true,
                firstButtonText = stringResource(R.string.cancel),
                onClickFirstButton = onDismiss,
                secondButtonText = stringResource(R.string.logout),
                onClickSecondButton = onLogoutClick,
                descriptionTextStyle = Theme.textStyle.body.small.medium,
                iconColor = Theme.colors.additional.primary.red,
                secondButtonBackground = Theme.colors.additional.primary.red,
                iconCircleBackgroundColor = Theme.colors.additional.secondary.red
            )
        }
    }
}
