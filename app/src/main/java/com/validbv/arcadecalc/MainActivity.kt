package com.validbv.arcadecalc

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // مخفی کردن کامل نوار وضعیت و ناوبری برای حالت ایمرسیو
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

        webView = findViewById(R.id.webview)
        webView.settings.apply {
            javaScriptEnabled = true // فعالسازی جاوا اسکریپت برای صداهای 8 بیتی
            domStorageEnabled = true // فعالسازی حافظه برای سابقه
            mediaPlaybackRequiresUserGesture = false // اجازه پخش صدا بدون کلیک اولیه
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        // WebChromeClient برای اجرای صحیح Web Audio API (بسیار مهم)
        webView.webChromeClient = WebChromeClient()
        
        // WebViewClient برای لود کردن فایل‌های لوکال
        webView.webViewClient = WebViewClient()

        // لود کردن فایل اچ‌تی‌ام‌ال از پوشه assets
        webView.loadUrl("file:///android_asset/index.html")
    }

    // مدیریت دکمه برگشت گوشی
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
