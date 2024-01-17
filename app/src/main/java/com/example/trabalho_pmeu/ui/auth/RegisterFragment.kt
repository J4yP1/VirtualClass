package com.example.trabalho_pmeu.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.trabalho_pmeu.R
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.trabalho_pmeu.databinding.FragmentRegisterPBinding
import com.example.trabalho_pmeu.helper.BaseFragment
import com.example.trabalho_pmeu.helper.FirebaseHelper
import com.example.trabalho_pmeu.helper.showBottomSheet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : BaseFragment() {

    private var _binding: FragmentRegisterPBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterPBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {
        binding.btnRegister.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {

                hideKeyboard()

                binding.progressBar.isVisible = true

                registerUser(email, password)

            } else {
                showBottomSheet(message = R.string.text_password_empty_register_fragment)
            }
        } else {
            showBottomSheet(message = R.string.text_email_empty_register_fragment)
        }
    }

    private fun registerUser(email: String, password: String) {
         auth.createUserWithEmailAndPassword(email, password)
             .addOnCompleteListener(requireActivity()) { task ->
                 if (task.isSuccessful) {
                     findNavController().navigate(R.id.action_global_homeP)
                 } else {
                     showBottomSheet(
                         message = FirebaseHelper.validError(
                             task.exception?.message ?: ""
                         )
                     )
                     Toast.makeText(
                         requireContext(),
                         FirebaseHelper.validError(task.exception?.message ?: ""),
                         Toast.LENGTH_SHORT
                     ).show()
                     binding.progressBar.isVisible = false
                 }
             }
     }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}