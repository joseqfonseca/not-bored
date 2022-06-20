package com.projkts.notbored.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projkts.notbored.R
import com.projkts.notbored.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    private fun setCheckListener(){
        //checar o click do texto do terms
        binding.checkTermsHome.setOnClickListener {
            Toast.makeText(this, "Testeeee",3)
        }
    }
}