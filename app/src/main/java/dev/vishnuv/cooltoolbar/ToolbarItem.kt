package dev.vishnuv.cooltoolbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Translate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import dev.vishnuv.cooltoolbar.ui.theme.Amber
import dev.vishnuv.cooltoolbar.ui.theme.Cyan
import dev.vishnuv.cooltoolbar.ui.theme.DeepOrangeAccent
import dev.vishnuv.cooltoolbar.ui.theme.LightBlueAccent
import dev.vishnuv.cooltoolbar.ui.theme.Pink
import dev.vishnuv.cooltoolbar.ui.theme.PinkAccent

data class ToolbarItem(val title: String, val color: Color, val icon: ImageVector)

val toolbarItems = listOf(
    ToolbarItem("Edit", PinkAccent, Icons.Default.Edit),
    ToolbarItem("Delete", LightBlueAccent, Icons.Default.Delete),
    ToolbarItem("Comment", Cyan, Icons.Default.Comment),
    ToolbarItem("Post", DeepOrangeAccent, Icons.Default.PostAdd),
    ToolbarItem("Favorite", Pink, Icons.Default.Star),
    ToolbarItem("Details", Amber, Icons.Default.Details),
    ToolbarItem("Languages", PinkAccent, Icons.Default.Translate),
    ToolbarItem("Settings", LightBlueAccent, Icons.Default.Settings),
    ToolbarItem("Edit", PinkAccent, Icons.Default.Edit),
    ToolbarItem("Delete", LightBlueAccent, Icons.Default.Delete),
    ToolbarItem("Comment", Cyan, Icons.Default.Comment),
    ToolbarItem("Post", DeepOrangeAccent, Icons.Default.PostAdd),
    ToolbarItem("Favorite", Pink, Icons.Default.Star),
    ToolbarItem("Details", Amber, Icons.Default.Details),
    ToolbarItem("Languages", PinkAccent, Icons.Default.Translate),
    ToolbarItem("Settings", LightBlueAccent, Icons.Default.Settings)
)
