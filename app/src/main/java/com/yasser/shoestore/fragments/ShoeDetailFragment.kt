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
import com.yasser.shoestore.Shoes
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentShoeDetailBinding
import com.yasser.shoestore.databinding.ShoeItemBinding


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding


    private lateinit var shoeItemBinding: ShoeItemBinding


    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate( inflater,
            R.layout.fragment_shoe_detail,
            container, false)


        shoeItemBinding = DataBindingUtil.inflate(inflater,R.layout.shoe_item,container,false)


        shoeItemBinding.viewModel = viewModel


        binding.buttonSave.setOnClickListener {

            getShoe()
            viewModel.newShoe()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())

        }



        return binding.root
    }

    private fun getShoe(){

        viewModel.shoesList.add( Shoes (
                binding.editTextModel.text.toString(),
                binding.editTextCompany.text.toString(),
                binding.editTextSize.text.toString(),
                binding.editTextDesc.text.toString()))
    }


}
//
//val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//imm.hideSoftInputFromWindow(view.windowToken, 0)