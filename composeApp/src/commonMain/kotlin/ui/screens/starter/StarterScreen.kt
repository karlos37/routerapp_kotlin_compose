package ui.screens.starter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.components.PrimaryButton
import ui.components.SecondaryButton
import ui.theme.Dimens

@Composable
fun StarterScreen(
    onGetStarted: () -> Unit,
    onAlreadyHaveAccount: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Mimosa\nRouter\nCompanion",
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.space16)
        ) {
            PrimaryButton(text = "Get Started", onClick = onGetStarted)
            SecondaryButton(text = "Already have an account?", onClick = onAlreadyHaveAccount)
        }
    }
}
