package com.projkts.notbored.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.projkts.notbored.MainActivity
import com.projkts.notbored.R
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext


class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)

        //showSlash()
    }

    override fun onResume() {
        super.onResume()
        showSlash()
    }

    private fun showSlash() {
        thread(true) {
            Thread.sleep(2500L)
            startActivity(Intent("", null, this, MainActivity::class.java))
            finish()
        }
    }
}