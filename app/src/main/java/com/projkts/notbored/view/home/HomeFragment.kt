package com.projkts.notbored.view.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.os.bundleOf
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

        //aplly config to screen componnents
        setConfig()

        //initializing a cache value to user choice to terms
        sharedPreferences = context?.getSharedPreferences("ACEPTED_TERMS", Context.MODE_PRIVATE)!!

        //verifing if terms were acepted previously and configurating check and button start
        verifyAceptedCheckTerms()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun setConfig() {
        binding.seekBarPriceHome.isEnabled = false

        binding.seekBarNumberPartHome.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, currentValue: Int, p2: Boolean) {
                if (currentValue > 0) binding.textSeekNumberPartic.text =
                    currentValue.toString() else seek?.progress = 1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        binding.switchPrice.setOnCheckedChangeListener { compoundButton, b ->
            binding.seekBarPriceHome.isEnabled = b
        }

        binding.seekBarPriceHome.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, currentValue: Int, p2: Boolean) {
                binding.textSeekPrice.text = if(currentValue > 0) (currentValue.toDouble() / 10).toString() else "0"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        binding.textLinkTermsHome.setOnClickListener() {
            findNavController().navigate(R.id.action_homeFragment_to_termFragment)
        }

        binding.checkTermsHome.setOnCheckedChangeListener { compoundButton, b ->
            binding.btnStart.isEnabled = b
            sharedPreferences.edit().putBoolean("ACEPTED_TERMS", b).apply()
        }

        binding.btnStart.setOnClickListener {
            val bundle = bundleOf(
                "numberParticipants" to binding.textSeekNumberPartic.text,
                "price" to if (binding.switchPrice.isChecked) binding.textSeekPrice.text else null
            )
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment, bundle)
        }
    }

    private fun verifyAceptedCheckTerms() {
        binding.btnStart.isEnabled = sharedPreferences.getBoolean("ACEPTED_TERMS", false)
        binding.checkTermsHome.isChecked = sharedPreferences.getBoolean("ACEPTED_TERMS", false)
    }

}