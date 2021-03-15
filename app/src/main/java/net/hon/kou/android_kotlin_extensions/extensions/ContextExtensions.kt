package net.hon.kou.android_kotlin_extensions.extensions

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.provider.MediaStore

fun Context.createUri(fileName: String, mimeType: String): Uri? {
    val contentValues = ContentValues()
    contentValues.put(MediaStore.Images.Media.TITLE, fileName)
    contentValues.put(MediaStore.Images.Media.MIME_TYPE, mimeType)
    return this.contentResolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        contentValues
    )
}