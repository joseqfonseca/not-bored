package com.projkts.notbored

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            startActivity(Intent("", null, this, NavActivity::class.java))
            finish()
        }
    }
}