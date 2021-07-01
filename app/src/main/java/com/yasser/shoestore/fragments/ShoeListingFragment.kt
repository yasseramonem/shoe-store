package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.yasser.shoestore.R
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentShoeListingBinding =
            DataBindingUtil.inflate( inflater,
            R.layout.fragment_shoe_listing,
            container, false)

//        binding.shoeItem.addView()

        return binding.root
    }
}