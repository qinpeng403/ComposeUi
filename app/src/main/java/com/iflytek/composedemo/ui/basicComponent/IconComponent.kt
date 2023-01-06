package com.iflytek.composedemo.ui.basicComponent


import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iflytek.composedemo.R

@Composable
fun iconSample() {
    Icon(
        modifier = Modifier.size(200.dp),
        imageVector = Icons.Default.AccountBox,
        contentDescription = null,
        tint = Color.Red
    )
}

@Composable
fun iconSample1() {
    Icon(
        painter = painterResource(id = R.drawable.icon_number_3),
        contentDescription = null
    )
}

@Composable
fun iconSample2() {
    var bitmap: ImageBitmap? = null
    with(LocalContext.current){
        bitmap = ImageBitmap.imageResource(resources,R.drawable.icon_number_3)
    }
    bitmap?.let { Icon(bitmap = it, contentDescription = null) }
}


@Preview(
    name = "iconSample",
    group = "iconSample-group",
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = Devices.PIXEL,
    fontScale = 1f,
    locale = "zh",
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun iconSamplePreview() {
    iconSample()
}
