package com.kizzito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class fish : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fish, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mywebview: WebView = view.findViewById(R.id.webv13)
        //webview client: this is the object responsible for most actions inside a webview
        mywebview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String

            ): Boolean {
                view?.loadUrl(url)

                return true
            }
        }
        mywebview.loadUrl("https://stkizitohighschoolug.com/projects/fish-farming/")
        mywebview.settings.javaScriptEnabled = true
        mywebview.settings.allowContentAccess = true
        mywebview.settings.useWideViewPort = true
        mywebview.settings.domStorageEnabled = true
    }
}
