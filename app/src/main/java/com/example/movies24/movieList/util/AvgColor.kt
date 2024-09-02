package com.example.movies24.movieList.util

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

@Composable
fun getAvgColor(imageBitmap: ImageBitmap):Color{  //SearchPT whole composable
    var avgColor by remember { mutableStateOf(Color.Transparent) }

    LaunchedEffect(key1 = Unit) {
        val compatibleBitmap= imageBitmap.asAndroidBitmap().copy(Bitmap.Config.ARGB_8888,false)

        val pixels=IntArray(compatibleBitmap.width * compatibleBitmap.height)
        compatibleBitmap.getPixels(pixels,0,compatibleBitmap.width,0,0,compatibleBitmap.width,compatibleBitmap.height)

        var redSum=0
        var greenSum=0
        var blueSum=0

        for(pixel in pixels){
            val red=android.graphics.Color.red(pixel)
            val green=android.graphics.Color.green(pixel)
            val blue=android.graphics.Color.blue(pixel)

            redSum=redSum+ red
            greenSum=greenSum+green
            blueSum=blueSum+blue
        }

        val pixelCount= pixels.size
        val avgRed=redSum/pixelCount
        val avgBlue= blueSum/pixelCount
        val avgGreen = greenSum/pixelCount

        avgColor=Color(avgRed,avgGreen,avgBlue)
    }

    val hsl = FloatArray(3)
    ColorUtils.colorToHSL(avgColor.toArgb(),hsl)

    val darkerLightness=hsl[2]-0.1f

    val darkerColor=ColorUtils.HSLToColor(
        floatArrayOf(
            hsl[0],hsl[1],darkerLightness
        )
    )
    return Color(darkerColor)
}
