package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yasser.shoestore.R
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_welcome,
                container, false)


        binding.viewModel = viewModel


        binding.buttonWelcome.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToOnboardingFragment())
        }

        return binding.root
    }

}