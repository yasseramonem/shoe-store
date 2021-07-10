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

        // Assigning Shoe Data Class to shoe var in ShoeDetail binding
        binding.shoe = shoe

        // setting onClick for cancel button
        binding.buttonCancel.setOnClickListener {
            navigate()
        }

        //setting onClick Listener for Save button to add the data retrieved from user via DataBinding
        binding.buttonSave.setOnClickListener {

            getShoe()
            viewModel.newShoe()
            navigate()

        }

        return binding.root
    }

    // Adding a shoe data item in the shoe list
    private fun getShoe(){

        viewModel.shoesList.add(shoe)
    }

    //Navigating to ShoeListing fragment
    private fun navigate(){
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
    }

}