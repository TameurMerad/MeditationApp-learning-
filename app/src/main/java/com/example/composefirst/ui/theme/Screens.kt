package com.example.composefirst.ui.theme

sealed class Screens (val route:String){

    object MainScreen :Screens("main_screen")
    object SecoundScreen :Screens("secound_screen")

    fun withArgs(vararg arg :String):String{
        return buildString {
            append(route)
            arg.forEach {
                append("/$it")
            }
        }
    }

}
