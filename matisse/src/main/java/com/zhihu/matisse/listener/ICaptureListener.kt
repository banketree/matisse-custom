package com.zhihu.matisse.listener

import android.content.Context

interface ICaptureListener {
    fun onCaptureListener(context: Context, requestCode: Int, isVideo: Boolean): Boolean
}