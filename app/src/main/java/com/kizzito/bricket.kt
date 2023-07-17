package com.kizzito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.kizzito.databinding.FragmentHomeBinding


class bricket : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.briquettes_production, container, false)
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mywebview: WebView = view.findViewById(R.id.webv9)
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
        mywebview.loadUrl("https://stkizitohighschoolug.com/projects/briquettes-production/")
        mywebview.settings.javaScriptEnabled = true
        mywebview.settings.allowContentAccess = true
        mywebview.settings.useWideViewPort = true
        mywebview.settings.domStorageEnabled = true
    }
}