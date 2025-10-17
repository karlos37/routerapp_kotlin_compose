package com.karlos.routerapp_kotlin_compose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform