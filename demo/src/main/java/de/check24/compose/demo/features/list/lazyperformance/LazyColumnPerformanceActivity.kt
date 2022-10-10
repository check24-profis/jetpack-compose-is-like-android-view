package de.check24.compose.demo.features.list.lazyperformance

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import de.check24.compose.demo.theme.DemoTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LazyColumnPerformanceActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleList = mutableListOf<ConversationItem>()

        for (i in 0..400) {
            exampleList.add(ConversationItem(i, "Title $i"))
        }

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "LazyColumn Performance")
                            })
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ExampleItemsListView(listOfExampleItems = exampleList)
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ExampleItemsListView(listOfExampleItems: List<ConversationItem>) {
    val isLoading = remember { mutableStateOf(false) }
    SwipeRefresh(
        modifier = Modifier.fillMaxSize(),
        state = rememberSwipeRefreshState(isRefreshing = isLoading.value),
        onRefresh = {
            MainScope().launch {
                isLoading.value = true
                delay(2000)
                isLoading.value = false
            }
        },
    ) {
        LazyColumn(
            modifier =
            Modifier.fillMaxSize()
        ) {
            items(
                items = listOfExampleItems,
                key = { it.id }
            ) { item ->
                @OptIn(ExperimentalFoundationApi::class)
                SwipeToDismiss(
                    state = rememberDismissState(),
                    modifier = Modifier
                        .padding(vertical = 1.dp)
                        .animateItemPlacement(),
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(Color.Yellow)
                                .padding(horizontal = 20.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = "HIDE",
                                color = Color.White,
                                style = MaterialTheme.typography.h3,
                            )
                        }
                    },
                    dismissContent = {
                        ConversationItem(
                            modifier = Modifier.background(Color.White),
                            text = item.title
                        )
                    }
                )
            }
        }
    }
}


@Composable
fun ConversationItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(140.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {

        ImageCardWithBadge(
            modifier = Modifier
                .height(82.dp)
                .width(82.dp),
            badgeText = "BLA",
            imageUrl = "https://placeimg.com/300/300/any?$text",
        )

//        Box(
//            modifier = Modifier
//                .height(82.dp)
//                .width(82.dp)
//        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {

            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1
            )

            Row {
                Text(
                    text = "serviceText",
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .weight(1f),
                    maxLines = 1
                )

                Text(
                    text = "16:20",
                    color = Color.LightGray,
                    maxLines = 1
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
            ) {


                Text(
                    text = "last message",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    maxLines = 1
                )

                CircularBadge(
                    text = "1"
                )
            }
        }
    }
}

@Composable
fun CircularBadge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(22.dp)
            .height(22.dp)
            .clip(CircleShape)
            .background(Color.Blue),
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center),
            fontSize = 12.sp,
            color = Color.White,
            maxLines = 1
        )
    }
}


@Composable
internal fun ImageCardWithBadge(
    modifier: Modifier = Modifier,
    badgeText: String? = null,
    badgeBackgroundColor: Color = Color.Black,
    badgeTextColor: Color = Color.White,
    imageUrl: String?
) {
    Card(
        modifier = modifier
    ) {
        Box {
            GlideImage(
                url = imageUrl,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )

            if (badgeText != null) {
                Text(
                    text = badgeText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(badgeBackgroundColor),
                    fontSize = 12.sp,
                    color = badgeTextColor,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}


@Composable
fun GlideImage(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    onImageReady: (() -> Unit)? = null,
    onFailPlaceHolderColor: Color = Color.LightGray
) {
    BoxWithConstraints {
        var image by remember { mutableStateOf<ImageBitmap?>(null) }
        val context = LocalContext.current

        DisposableEffect(key1 = url) {
            if (url == null) {
                return@DisposableEffect onDispose {
                    image = null
                }
            }
            val glide = Glide.with(context)

            val target = ProfisGlideCustomTarget<Bitmap>(
                onCleared = { image = null },
                onReady = { resource, _ ->
                    image = resource.asImageBitmap()
                    onImageReady?.invoke()
                }
            )
            val size = with(constraints) {
                IntSize(
                    if (maxWidth in 1 until Int.MAX_VALUE) maxWidth else Target.SIZE_ORIGINAL,
                    if (maxHeight in 1 until Int.MAX_VALUE) maxHeight else Target.SIZE_ORIGINAL
                )
            }

            glide
                .asBitmap()
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .override(size.width, size.height)
                .into(target)

            onDispose {
                image = null
                glide.clear(target)
            }
        }

        ActualImage(
            image = image,
            placeHolderColor = onFailPlaceHolderColor,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
        )
    }
}

@Composable
private fun ActualImage(
    image: ImageBitmap?,
    placeHolderColor: Color,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
) {
    if (image != null) {
        Image(
            bitmap = image,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
        )
    } else {
        Image(
            painter = ColorPainter(placeHolderColor),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
        )
    }
}

data class ConversationItem(
    val id: Int,
    val title: String,
)

class ProfisGlideCustomTarget<V : Any>(
    val onCleared: (placeholder: Drawable?) -> Unit = {},
    val onReady: (resource: V, transition: Transition<in V>?) -> Unit = { _, _ -> },
    val onStarted: (placeholder: Drawable?) -> Unit = {},
    val onFailed: (placeholder: Drawable?) -> Unit = {}
) : CustomTarget<V>() {
    override fun onLoadCleared(placeholder: Drawable?) = onCleared(placeholder)
    override fun onLoadStarted(placeholder: Drawable?) = onStarted(placeholder)
    override fun onLoadFailed(errorDrawable: Drawable?) = onFailed(errorDrawable)
    override fun onResourceReady(resource: V, transition: Transition<in V>?) = onReady(resource, transition)
}

@Preview(showSystemUi = true)
@Composable
private fun ConversationPreview() {
    DemoTheme {
        ConversationItem(text = "BLA")
    }
}