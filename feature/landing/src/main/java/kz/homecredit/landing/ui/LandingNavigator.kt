package kz.homecredit.landing.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.ui.graphics.vector.VectorAsset
import kz.homecredit.landing.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: VectorAsset) {
    object Articles : Screen("articles", R.string.news, Icons.Filled.Image)
}