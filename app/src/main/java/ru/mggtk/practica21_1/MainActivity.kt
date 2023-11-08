package ru.mggtk.practica21_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.ProgressBar
import ru.mggtk.practica21_1.R.id.webViewMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun click(view: View){
        val prg: ProgressBar = findViewById(R.id.progressBar)
        val webView = findViewById<WebView>(webViewMain)
        var runnable: Runnable = Runnable {
            webView.post(Runnable{
                prg.visibility = View.VISIBLE
                webView.loadUrl("https://github.com/")
            })
            Thread.sleep(1000)
            prg.visibility = View.INVISIBLE


        }
        val thread: Thread = Thread(runnable)
        thread.start()
        view.isEnabled = false
    }
}