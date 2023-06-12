package com.miron.logisticquizfootball.presentaion.navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")


    object FirstLevelOne: Screen(route = "first_level_screen")
    object FirstLevelTwo: Screen(route = "first_level_2")
    object FirstLevelThree: Screen(route = "first_level_3")
    object FirstLevelFourth: Screen(route = "first_level_4")
    object FirstLevelFife: Screen(route = "first_level_5")

    object SecondLevelOne: Screen(route = "second_level_screen")
    object SecondLevelTwo: Screen(route = "second_level_two")
    object SecondLevelThree: Screen(route = "second_level_three")
    object SecondLevelFour: Screen(route = "second_level_four")
    object SecondLevelFive: Screen(route = "second_level_five")

    object ThirdLevel: Screen(route = "third_level_screen")
    object FourthLevel: Screen(route = "fourth_level_screen")
    object InfoScreen: Screen(route = "info_screen")
    object SettingsScreen: Screen(route = "settings_screen")
    object RuleScreen: Screen(route = "rule_screen")
    object SplashScreen: Screen(route = "splash_screen")
}
