package com.miron.logisticquizfootball.presentaion.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miron.logisticquizfootball.presentaion.fr.*
import com.miron.logisticquizfootball.presentaion.fr.first_level.*
import com.miron.logisticquizfootball.presentaion.fr.second_level.*
import com.miron.logisticquizfootball.presentaion.view_model.FourthLevelViewModel
import com.miron.logisticquizfootball.presentaion.view_model.QuizViewModel
import com.miron.logisticquizfootball.presentaion.view_model.SettingsViewModel

@Composable
fun MainNavController(navController: NavHostController, settingsViewModel: SettingsViewModel) {
    val quizViewModel: QuizViewModel = viewModel()
    val fourthLevelViewModel: FourthLevelViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.ThirdLevel.route) { ThirdLevelScreen(quizViewModel = quizViewModel, navController = navController ) }
        composable(Screen.FourthLevel.route) { FourthLevelScreen(quizViewModel = quizViewModel, navController = navController, fourthLevelViewModel = fourthLevelViewModel) }
        composable(Screen.InfoScreen.route) { InfoScreen() }
        composable(Screen.SettingsScreen.route) { SettingsScreen(navController, settingsViewModel = settingsViewModel) }
        composable(Screen.RuleScreen.route) { RuleScreen(navController = navController) }

        composable(Screen.FirstLevelOne.route) { FirstLevelScreen(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.FirstLevelTwo.route) { FirstLevelScreenTwo(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.FirstLevelThree.route) { FirstLevelScreenThree(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.FirstLevelFourth.route) { FirstLevelScreenFour(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.FirstLevelFife.route) { FirstLevelScreenFive(quizViewModel = quizViewModel, navController = navController) }

        composable(Screen.SecondLevelOne.route) { SecondLevel(quizViewModel = quizViewModel, navController = navController ) }
        composable(Screen.SecondLevelTwo.route) { SecondLevelTwo(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.SecondLevelThree.route) { SecondLevelThree(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.SecondLevelFour.route) { SecondLevelFour(quizViewModel = quizViewModel, navController = navController) }
        composable(Screen.SecondLevelFive.route) { SecondLevelFive(quizViewModel = quizViewModel, navController = navController) }
    }

}