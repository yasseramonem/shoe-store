package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yasser.shoestore.R
import com.yasser.shoestore.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val binding: FragmentOnboardingBinding =
             DataBindingUtil. inflate(inflater,
                 R.layout.fragment_onboarding,
                 container, false)

        return binding.root
    }

}