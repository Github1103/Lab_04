package com.example.lab_04_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.lab_04_01.MyWebView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_web_view.*
import java.util.*
import java.lang.Object as Object

class MyWebView() : AppCompatActivity() {
    lateinit var webView:WebView
    lateinit var url:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_web_view)
        initView()
        setWebView()
    }

    private fun initView(){
        url =intent.data.toString()
    }

    private fun setWebView(){
        var webSettings=MyWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.allowFileAccess =true
        webSettings.allowContentAccess =true
        MyWebView.loadUrl(url)
        MyWebView.webViewClient =object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                MyWebView.loadUrl(url)
                return true
            }
        }
    }
}