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
import com.yasser.shoestore.Shoe
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val shoe = Shoe("","","","")

    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate( inflater,
            R.layout.fragment_shoe_detail,
            container, false)




        binding.shoe = shoe

        binding.buttonSave.setOnClickListener {

            getShoe()
            viewModel.newShoe()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())

        }

        return binding.root
    }

    private fun getShoe(){

        viewModel.shoesList.add(shoe)
    }


}
//
//val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//imm.hideSoftInputFromWindow(view.windowToken, 0)