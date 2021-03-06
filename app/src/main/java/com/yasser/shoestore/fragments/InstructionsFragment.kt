package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yasser.shoestore.R
import com.yasser.shoestore.databinding.FragmentInstructionsBinding

/*
This is the Third Screen for the app the Instruction on how to use the app
 */
class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
         val binding: FragmentInstructionsBinding =
             DataBindingUtil. inflate(inflater,
                 R.layout.fragment_instructions,
                 container, false)

        // Setting onClickListeners for Navigating to ShoesList Fragment
        binding.buttonInstructions.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())
        }

        return binding.root
    }

}