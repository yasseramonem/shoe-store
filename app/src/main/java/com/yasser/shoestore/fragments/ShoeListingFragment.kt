package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yasser.shoestore.R
import com.yasser.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentShoeListingBinding =
            DataBindingUtil.inflate( inflater,
            R.layout.fragment_shoe_listing,
            container, false)

        return binding.root
    }
}