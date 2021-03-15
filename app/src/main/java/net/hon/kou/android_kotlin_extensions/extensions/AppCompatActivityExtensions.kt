package net.hon.kou.android_kotlin_extensions.extensions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.startCamera(
        outPutUri: Uri,
        activityResultLauncher: ActivityResultLauncher<Intent>
) {
    activityResultLauncher.launch(
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, outPutUri)
    )
}