package com.projkts.notbored.view.term

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentTermBinding


class TermFragment : Fragment(R.layout.fragment_term) {

    private val binding: FragmentTermBinding by lazy {
        FragmentTermBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setBtnCloseTermsListener()
        return binding.root//inflater.inflate(R.layout.fragment_term, container, false)
    }

    private fun setBtnCloseTermsListener() {
        binding.btnCloseTerm.setOnClickListener {
            //close the fragment
        }
    }

}