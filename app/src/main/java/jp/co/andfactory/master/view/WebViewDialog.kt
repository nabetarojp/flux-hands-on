package jp.co.andfactory.master.view

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatDialog
import android.util.DisplayMetrics
import android.view.Window
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by watanabe on 2018/01/06.
 */
class WebViewDialog(context: Context) : AppCompatDialog(context) {

    @SuppressLint("SetJavaScriptEnabled")
    val webView = WebView(context).apply {
        webViewClient = WebViewClient()
        webChromeClient = WebChromeClient()
        settings.javaScriptEnabled = true
    }

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(webView)
        DisplayMetrics().let {
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(it)
            window.attributes = window.attributes.apply {
                width = it.widthPixels * 95 / 100
                height = it.heightPixels * 90 / 100
            }
        }
    }
}