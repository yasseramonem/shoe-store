package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yasser.shoestore.R
import com.yasser.shoestore.databinding.FragmentLoginBinding

/*
This is the base Fragment for the app contains login Layout
 */

class LoginFragment : Fragment() {


//    Initializing Binding Variable
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        // Using DataBindingUtil to inflate the root layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        // Setting onClick Listeners for the buttons
        binding.createButton.setOnClickListener {
            navigate()
        }
        binding.loginButton.setOnClickListener {
            navigate()
        }

        return binding.root
    }

    // Navigating from Login Fragment to WelcomeFragment
    private fun navigate(){
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    // Overriding onViewCreated to execute Logo animations and to hide ActionBar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()


        binding.logo.alpha = 0f
        binding.logo.animate().setDuration(1200).alpha(1f).scaleX(0.65F).scaleY(0.65F)
                .withEndAction{
                    binding.logo.animate().setDuration(750).y(0.2F).withEndAction {
                        binding.apply {
                            linearLayout.visibility = View.VISIBLE
                            loginButton.visibility = View.VISIBLE
                            createButton.visibility = View.VISIBLE
                        }
                    }
                }
    }
}