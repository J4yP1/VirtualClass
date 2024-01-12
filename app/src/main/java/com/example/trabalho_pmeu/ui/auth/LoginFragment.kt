package com.example.trabalho_pmeu.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trabalho_pmeu.R
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.trabalho_pmeu.databinding.FragmentLoginPBinding


/*import com.example.trabalho_pmeu.databinding.FragmentLoginBinding
import com.example.trabalho_pmeu.helper.BaseFragment
import com.example.trabalho_pmeu.helper.FirebaseHelper
import com.example.trabalho_pmeu.helper.showBottomSheet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase*/

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginPBinding? = null
    private val binding get() = _binding!!

    //private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginPBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {
        //binding.btnLogin.setOnClickListener { validateData() }

        binding.btnRegisterPage.setOnClickListener {
            findNavController().navigate(R.id.action_loginP_to_registerP)
        }

        binding.btnRecover.setOnClickListener {
            findNavController().navigate(R.id.action_loginP_to_recoverFragment)
        }
    }
/*
    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {

               // hideKeyboard()

                //binding.progressBar.isVisible = true

                loginUser(email, password)

            } else {
                /*showBottomSheet(
                    message = R.string.text_password_empty_login_fragment*/
                )
            }
        } else {
            /*showBottomSheet(
                message = R.string.text_email_empty_login_fragment*/
            )
        }
    }*/
/*
    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_loginP_to_homeP)
                } else {
                    /*showBottomSheet(
                        message = FirebaseHelper.validError(task.exception?.message ?: "")
                    )*/
                    //binding.progressBar.isVisible = false
                }
            }
    }
*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}