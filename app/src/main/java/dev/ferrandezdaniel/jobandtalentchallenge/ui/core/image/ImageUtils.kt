package dev.ferrandezdaniel.jobandtalentchallenge.ui.core.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.io.InputStream
import java.net.URL

fun String.getBitmapFromURL(): Bitmap? {
    return try {
        val connection = URL(this).openConnection().apply {
            doInput = true
            connect()
        }
        val input: InputStream = connection.inputStream
        BitmapFactory.decodeStream(input)
    } catch (e: IOException) {
        null
    }
}
