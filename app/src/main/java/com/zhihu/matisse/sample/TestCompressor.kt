package com.zhihu.matisse.sample

import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.destination
import id.zelory.compressor.constraint.format
import id.zelory.compressor.constraint.quality
import id.zelory.compressor.constraint.size
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

object TestCompressor {

    fun test(context: AppCompatActivity, pathList: List<String>) {
        GlobalScope.launch {
            val absolutePath = Environment.getExternalStorageDirectory().absolutePath + "/1/";
            for (path in pathList) {
                val file = File(path)
                val compressedImageFile = Compressor.compress(context, file) {
                    quality(80)
                    format(Bitmap.CompressFormat.WEBP)
                    size(1024 * 100) // 100kb
//                    destination(File(absolutePath, file.name))
                }

                Log.i("", "$compressedImageFile")
            }
        }
    }
}