package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.yasser.shoestore.R
import com.yasser.shoestore.Shoe
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentShoeListingBinding
import com.yasser.shoestore.databinding.ShoeItemBinding

class ShoeListingFragment : Fragment() {


    private lateinit var binding: FragmentShoeListingBinding

    private lateinit var shoeItemBinding: ShoeItemBinding

    private val viewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing,
            container, false
        )



        binding.floatingButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }


        viewModel.shoeAdded.observe(viewLifecycleOwner, {
            for(shoe in it) {
                addView(shoe)
            }
        })

        return binding.root
    }


    private fun addView(shoe: Shoe) {


        shoeItemBinding = ShoeItemBinding.inflate(LayoutInflater.from(requireContext()))
        shoeItemBinding.shoe = shoe


            if (shoeItemBinding.root.parent != null) {
                binding.shoeList.removeAllViews()
            }
            binding.shoeList.addView(shoeItemBinding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController()) || super.onOptionsItemSelected(item)
    }

}






