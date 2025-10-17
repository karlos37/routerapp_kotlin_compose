package com.karlos.routerapp_kotlin_compose

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.navigation.NavigableHost
import ui.navigation.Screen
import ui.navigation.rememberNavigator
import ui.screens.auth.SignInScreen
import ui.screens.starter.StarterScreen
import ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        val navigator = rememberNavigator(Screen.Starter)
        NavigableHost(navigator = navigator) { screen ->
            when (screen) {
                Screen.Starter -> StarterScreen(
                    onGetStarted = { navigator.push(Screen.SignIn) },
                    onAlreadyHaveAccount = { navigator.push(Screen.SignIn) }
                )
                Screen.SignIn -> SignInScreen(
                    onBack = { navigator.pop() },
                    onSignIn = { _, _ -> /* no-op for now */ }
                )
            }
        }
    }
}