package kz.homecredit.landing.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.compose.*
import dagger.hilt.android.AndroidEntryPoint
import kz.homecredit.landing.ui.composable.ArticleUI


@AndroidEntryPoint
class LandingFragment : Fragment() {

    private val viewModel: LandingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(backgroundColor = Color.White,
                            content = {
                                BasicText(
                                    text = "Articles",
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                        .padding(start = 16.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Monospace,
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            })
                    }
                ) {
                    NavHost(
                        navController,
                        startDestination = Screen.Articles.route
                    ) {
                        composable(Screen.Articles.route) { ArticleUI(viewModel) }
                    }
                }

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigator.navigateBy(this)
    }
}