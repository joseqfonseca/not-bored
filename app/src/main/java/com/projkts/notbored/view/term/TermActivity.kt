package com.projkts.notbored.view.term

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projkts.notbored.R
import com.projkts.notbored.databinding.ActivityTermBinding

class TermActivity : AppCompatActivity(R.layout.activity_term) {

    private val binding: ActivityTermBinding by lazy {
        ActivityTermBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBtnCloseTermsListener()
    }

    private fun setBtnCloseTermsListener(){
        binding.btnCloseTerm.setOnClickListener {
            finish()
        }
    }
}