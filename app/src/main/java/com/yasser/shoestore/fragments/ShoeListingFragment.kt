package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.yasser.shoestore.R
import com.yasser.shoestore.Shoe
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentShoeListingBinding
import com.yasser.shoestore.databinding.ShoeItemBinding

class ShoeListingFragment : Fragment() {

    // Intializing ShoeLising Binding, ShoeItemBinding and ViewModel
    private lateinit var binding: FragmentShoeListingBinding

    private lateinit var shoeItemBinding: ShoeItemBinding

    private val viewModel: ViewModel by activityViewModels()

    //overriding onCreate to enable options Menu
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

        //setting onClickListener for the floating button
        binding.floatingButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }


        //Observing the liveData field from the viewModel
        viewModel.shoeAdded.observe(viewLifecycleOwner, {

            //looping through LiveData List of shoes and sending each item to addView()
            for(shoe in it) {
                addView(shoe)
            }
        })

        return binding.root
    }


    //Adding a new ShoeItem using a custom layout (shoe_item.xml) and updating textViews via DataBinding
    private fun addView(shoe: Shoe) {

        shoeItemBinding = ShoeItemBinding.inflate(LayoutInflater.from(requireContext()))
        shoeItemBinding.shoe = shoe


            if (shoeItemBinding.root.parent != null) {
                binding.shoeList.removeAllViews()
            }
            binding.shoeList.addView(shoeItemBinding.root)

    }

    //inflating options Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    //Navigating to LoginFragment when menu item is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*Getting the NavController and calling navigateUp() to control backButton behaviour
          when returning to LoginFragment on Logout MenuItem is pressed
        */
        val navController = requireView().findNavController()
        navController.navigateUp()
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

}






