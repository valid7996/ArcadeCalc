package com.validbv.arcadecalc

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // حالت edge-to-edge (بدون نوار بالا و پایین) — سازگار با Android 5+
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)

        // مخفی کردن نوار وضعیت و ناوبری (روش مدرن + fallback برای Android قدیمی)
        val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // Fullscreen برای Android قدیمی (API < 30)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
            )
        }

        // تنظیمات WebView
        webView = findViewById(R.id.webview)
        webView.settings.apply {
            javaScriptEnabled = true          // لازم برای منطق ماشین حساب
            domStorageEnabled = true           // برای ذخیره تاریخچه
            mediaPlaybackRequiresUserGesture = false // پخش صدای 8-بیتی بدون کلیک
            loadWithOverviewMode = true
            useWideViewPort = true
            builtInZoomControls = false        // غیرفعال کردن zoom موبایل
            displayZoomControls = false
            textZoom = 100                     // جلوگیری از تغییر فونت توسط سیستم
        }

        // WebChromeClient برای Web Audio API
        webView.webChromeClient = WebChromeClient()

        // WebViewClient برای لود فایل‌های local
        webView.webViewClient = WebViewClient()

        // لود فایل HTML از assets
        webView.loadUrl("file:///android_asset/index.html")
    }

    // مدیریت دکمه برگشت
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            @Suppress("DEPRECATION")
            super.onBackPressed()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
