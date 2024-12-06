package dev.vishnuv.cooltoolbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vishnuv.cooltoolbar.ui.theme.CoolToolbarTheme

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    toolbarItem: ToolbarItem,
    height: Dp,
    isLongPressed: Boolean = false,
    isScrolling: Boolean = false,
    gutter: Int = 10
) {


    val paddingAnimation by animateDpAsState(
        label = "Left Padding",
        targetValue = if (isLongPressed) itemsOffset.dp else 0.dp,
        animationSpec = tween(
            easing = longPressAnimationCurve,
            durationMillis = longPressAnimationDuration
        )
    )

    val scaleAnimation by animateFloatAsState(
        label = "Scale",
        targetValue = if (isScrolling) 0.4f else 1f,
        animationSpec = tween(
            easing = scrollScaleAnimationCurve,
            durationMillis = scrollScaleAnimationDuration
        )
    )

    val widthAnimation by animateDpAsState(
        label = "Width",
        targetValue = if (isLongPressed) (toolbarWidth * 2).dp else height,
        animationSpec = tween(
            easing = longPressAnimationCurve,
            durationMillis = longPressAnimationDuration
        )
    )

    val heightAnimation by animateDpAsState(
        label = "Height",
        targetValue = height + if (isLongPressed) 10.dp else 0.dp,
        animationSpec = tween(
            easing = longPressAnimationCurve,
            durationMillis = longPressAnimationDuration
        )
    )

    Box(
        modifier
            .padding(start = paddingAnimation)
            .scale(scaleAnimation)
            .shadow(elevation = 1.dp, shape = CircleShape.copy(CornerSize(12.dp)))
            .background(toolbarItem.color, shape = CircleShape.copy(CornerSize(12.dp)))
            .size(height = heightAnimation, width = widthAnimation)
            ,
        contentAlignment = Alignment.Center
    ) {
        Row {
            Icon(toolbarItem.icon, contentDescription = toolbarItem.title, tint = Color.White)
            AnimatedVisibility(visible = isLongPressed) {
                Text(
                    toolbarItem.title,
                    style = TextStyle(fontSize = 18.sp, color = Color.White),
                    maxLines = 1,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }


}

@Preview(name = "Toolbar Not Pressed")
@Composable
private fun ToolbarPreview() {
    CoolToolbarTheme {
        Toolbar(toolbarItem = toolbarItems.first(), height = 56.dp)
    }
}

@Preview(name = "Toolbar Pressed")
@Composable
private fun ToolbarPressedPreview() {
    CoolToolbarTheme {
        Toolbar(
            toolbarItem = toolbarItems.first(),
            height = 56.dp,
            isLongPressed = true
        )
    }
}