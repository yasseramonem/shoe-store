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
import com.yasser.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {


    private lateinit var binding: FragmentShoeListingBinding


    private val viewModel: ViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_shoe_listing,
                container, false)




        binding.floatingButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }



        viewModel.shoeAdded.observe(viewLifecycleOwner, {
            addView()
        })

            return binding.root
        }


    private fun addView(){

        for ( i in viewModel.shoesList) {
            val shoeItem = View.inflate(context, R.layout.shoe_item ,null)
            if(shoeItem.parent != null){
                binding.shoeList.removeView(shoeItem)
            }
                binding.shoeList.addView(shoeItem)
        }
        }
    }




