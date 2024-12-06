package com.example.hw1_mouth4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw1_mouth4.R
import com.example.hw1_mouth4.databinding.FragmentFirstBinding
import com.example.hw1_mouth4.ui.Data.User

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.send.setOnClickListener {
            val email = binding.textEmail.text.toString()
            if (email.contains("@")) {
                User(
                    name = binding.textName.text.toString(),
                    email = email,
                    password = binding.textPassword.text.toString()

                )
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                        User()
                    )
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Некорректный адрес электронной почты",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}