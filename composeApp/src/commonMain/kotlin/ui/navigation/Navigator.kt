package ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

class Navigator(initial: Screen) {
    private val backStack = mutableStateListOf(initial)

    val current: Screen get() = backStack.last()

    fun push(screen: Screen) { backStack += screen }
    fun pop(): Boolean {
        return if (backStack.size > 1) { backStack.removeLast(); true } else false
    }
}

@Composable
fun rememberNavigator(start: Screen): Navigator = remember { Navigator(start) }

@Composable
fun NavigableHost(
    navigator: Navigator,
    content: @Composable (Screen) -> Unit
) {
    AnimatedContent(
        targetState = navigator.current,
        transitionSpec = {
            val forward = (initialStateIndex < targetStateIndex)
            val direction = if (forward) AnimatedContentTransitionScope.SlideDirection.Left
                            else AnimatedContentTransitionScope.SlideDirection.Right
            (slideIntoContainer(direction, tween(250)) + fadeIn(tween(250))) togetherWith
            (slideOutOfContainer(direction, tween(250)) + fadeOut(tween(200)))
        }, label = "navTransition"
    ) { screen ->
        content(screen)
    }
}

private val AnimatedContentTransitionScope<Screen>.initialStateIndex: Int get() = indexOf(initialState)
private val AnimatedContentTransitionScope<Screen>.targetStateIndex: Int get() = indexOf(targetState)

private fun indexOf(screen: Screen): Int = when (screen) {
    is Screen.Starter -> 0
    is Screen.SignIn -> 1
}
