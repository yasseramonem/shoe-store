package com.yasser.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yasser.shoestore.R
import com.yasser.shoestore.ViewModel
import com.yasser.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_login, container, false)

        binding.createButton.setOnClickListener {
            navigate()
        }

        binding.loginButton.setOnClickListener {

            navigate()
        }


        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

    private fun navigate(){

        viewModel.hasLoggedIn()
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

    }



}