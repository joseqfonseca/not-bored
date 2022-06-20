package com.projkts.notbored.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projkts.notbored.view.home.HomeActivity
import com.projkts.notbored.R
import kotlin.concurrent.thread


class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        showSlash()
    }

    private fun showSlash() {
        thread(true) {
            Thread.sleep(2500L)
            startActivity(Intent("", null, this, HomeActivity::class.java))
            finish()
        }
    }
}