package ui.navigation

sealed class Screen {
    data object Starter : Screen()
    data object SignIn : Screen()
}
