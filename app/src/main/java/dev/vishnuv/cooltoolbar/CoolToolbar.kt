package dev.vishnuv.cooltoolbar

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.cooltoolbar.ui.theme.CoolToolbarTheme

@Composable
fun CoolToolbar(modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    val toolbarHeight = configuration.screenHeightDp.dp * 0.6f

    val itemHeight = toolbarWidth - (toolbarHorizontalPadding * 2)
    var longPressIndex by remember { mutableIntStateOf(-1) }

    val listState = rememberLazyListState()


    Box {
        Box(
            Modifier
                .height(toolbarHeight)
                .padding(start = 20.dp, top = 90.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(toolbarWidth.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                shape = CircleShape.copy(CornerSize(15.dp)),
                content = {}
            )

            LazyColumn(
                modifier = Modifier
                    .align(Alignment.Center)
                    .pointerInput(Unit) {
                        detectDragGesturesAfterLongPress(
                            onDragStart = { offset ->
                                longPressIndex = ((offset.y / 2) / itemHeight).toInt()
                            },
                            onDrag = { change, dragAmount ->
                                val yOffset = change.position.y
                                longPressIndex =
                                    ((yOffset * 0.4) / itemHeight).toInt() // 0.4 because height is 0.6 of the screen
                            },
                            onDragEnd = {
                                longPressIndex = -1 // -1 make long press false
                            },
                            onDragCancel = {
                                longPressIndex = -1
                            })

                    },
                contentPadding = PaddingValues(toolbarHorizontalPadding.dp),
                state = listState
            ) {
                items(toolbarItems.size) { index ->
                    val item = toolbarItems[index]
                    Toolbar(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        toolbarItem = item,
                        height = itemHeight.dp,
                        isLongPressed = longPressIndex == index,
                        isScrolling = listState.isScrollInProgress


                    )
                }
            }

        }
    }

}

@Preview
@Composable
private fun CoolToolbarPreview() {
    CoolToolbarTheme {
        CoolToolbar()
    }
}