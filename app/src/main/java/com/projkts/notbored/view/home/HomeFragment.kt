package com.projkts.notbored.view.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //aplly config to screen componnents
        setConfig()

        //initializing a cache value to user choice to terms
        sharedPreferences = context?.getSharedPreferences("ACEPTED_TERMS", Context.MODE_PRIVATE)!!

        //verifing if terms were acepted previously and configurating check and button start
        verifyAceptedCheckTerms()

        return binding.root
    }

    private fun setConfig() {
        binding.textLinkTermsHome.setOnClickListener() {
            findNavController().navigate(R.id.action_homeFragment_to_termFragment)
        }

        binding.checkTermsHome.setOnCheckedChangeListener { compoundButton, b ->
            binding.btnStart.isEnabled = b
            sharedPreferences.edit().putBoolean("ACEPTED_TERMS", b).apply()
        }

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }
    }

    private fun verifyAceptedCheckTerms(){
        binding.btnStart.isEnabled = sharedPreferences.getBoolean("ACEPTED_TERMS", false)
        binding.checkTermsHome.isChecked = sharedPreferences.getBoolean("ACEPTED_TERMS", false)
    }

}