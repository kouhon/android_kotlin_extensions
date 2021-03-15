package net.hon.kou.android_kotlin_extensions

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import net.hon.kou.android_kotlin_extensions.databinding.ActivityMainBinding
import net.hon.kou.android_kotlin_extensions.extensions.createUri
import net.hon.kou.android_kotlin_extensions.extensions.startCamera
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(this.layoutInflater)
    }

    private val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult? ->
        when (result?.resultCode) {
            android.app.Activity.RESULT_OK -> {
                Timber.tag("startCamera").i("RESULT_OK")
            }
            android.app.Activity.RESULT_CANCELED -> {
                Timber.tag("startCamera").i("RESULT_CANCELED")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.viewBinding.root)

        this.viewBinding.startCameraButton.setOnClickListener {
            this.startCamera(
                outPutUri = Uri.parse(
                    this.createUri("cameraTest.jpeg", "image/jpeg")!!.toString()
                ),
                activityResultLauncher = this.activityResultLauncher
            )
        }
    }
}