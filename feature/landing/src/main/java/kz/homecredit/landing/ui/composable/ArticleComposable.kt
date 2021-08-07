package kz.homecredit.landing.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kz.homecredit.core.common.CoilImage
import kz.homecredit.core.extension.fullScreen
import kz.homecredit.core.extension.toColor
import kz.homecredit.landing.ui.LandingViewModel


@Composable
fun ArticleUI(viewModel: LandingViewModel) {

    val articles = viewModel.getArticlePagination().collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

        items(articles) { article ->
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                article?.downloadUrl?.let { loadImage(it, viewModel) }
                BasicText(
                    style = TextStyle(fontWeight = FontWeight.SemiBold, fontFamily = FontFamily.SansSerif),
                    text = "Author: " + article?.author + "\n" + "Title: " + article?.title,
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 8.dp, start = 4.dp)
                        .background(color = "#FFFFFF".toColor())
                        .padding(4.dp)
                )
            }
        }
        articles.apply {
            when {
                loadState.refresh is LoadState.Loading -> item {
                    showProgress()
                }
                loadState.append is LoadState.Loading -> {
                    item { showProgress() }
                }
            }
        }
    }

    openImage(viewModel)

}

@Composable
fun loadImage(url: String, viewModel: LandingViewModel) {
    CoilImage(
        model = url,
        modifier = Modifier.fillMaxWidth()
            .border(
                width = 4.dp,
                color = Color.White,
                shape = RoundedCornerShape(0.dp)
            )
            .clickable(onClick = {
                viewModel.openImage(url)
            })
    )
}

@Composable
fun openImage(viewModel: LandingViewModel) {
    val url = viewModel.photo.observeAsState("")
    if (url.value.isNotEmpty()) {
        Dialog(
            content = {
                CoilImage(
                    model = url.value,
                    modifier = Modifier.fillMaxWidth()
                        .border(width = 5.dp, color = Color.White, shape = RoundedCornerShape(5.dp))
                )
            },
            onDismissRequest = { viewModel.openImage("") }
        )
    }
}

@Composable
fun showProgress() {
    Box(modifier = Modifier.fullScreen(backgroundColor = Color.White)) {
        CircularProgressIndicator(
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
