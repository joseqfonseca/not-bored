package com.projkts.notbored.view.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.projkts.notbored.R
import com.projkts.notbored.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, R.string.terms_text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}