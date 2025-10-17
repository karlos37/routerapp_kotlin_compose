package ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.AppTextField
import ui.components.PrimaryButton
import ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onBack: () -> Unit,
    onSignIn: (email: String, password: String) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val emailError = email.isNotBlank() && !email.contains("@")
    val passwordError = password.isNotBlank() && password.length < 8
    val isValid = !emailError && !passwordError && email.isNotBlank() && password.isNotBlank()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Sign In") },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    // Using simple text as a placeholder for an icon to avoid a platform-specific vector
                    Text("←", style = MaterialTheme.typography.titleLarge)
                }
            }
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.space16)
        ) {
            AppTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                isError = emailError,
                supportingText = if (emailError) "Enter a valid email" else null
            )
            AppTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isPassword = true,
                isError = passwordError,
                supportingText = if (passwordError) "Minimum 8 characters" else null
            )
            Spacer(Modifier.height(Dimens.space24))
            PrimaryButton(text = "Sign In", enabled = isValid) {
                onSignIn(email, password)
            }
        }
    }
}
