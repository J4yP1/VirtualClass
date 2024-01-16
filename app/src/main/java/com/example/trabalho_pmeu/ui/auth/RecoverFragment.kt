package com.example.trabalho_pmeu.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.trabalho_pmeu.R
import com.example.trabalho_pmeu.databinding.FragmentRecoverBinding
import com.example.trabalho_pmeu.helper.FirebaseHelper
/*import com.example.trabalho_pmeu.helper.BaseFragment
import com.example.trabalho_pmeu.helper.FirebaseHelper
import com.example.trabalho_pmeu.helper.initToolbar
import com.example.trabalho_pmeu.helper.showBottomSheet*/
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecoverFragment : Fragment() {

    private var _binding: FragmentRecoverBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initToolbar(binding.toolbar)

        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {
        binding.btnRecover.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()

        if (email.isNotEmpty()) {
            //hideKeyboard()

            binding.progressBar.isVisible = true

            recoverAccountUser(email)
        } else {
            //showBottomSheet(message = R.string.text_email_empty_recover_account_fragment)
            Toast.makeText(requireContext(), "Informe o seu email", Toast.LENGTH_SHORT).show()
        }
    }

    private fun recoverAccountUser(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                   /* showBottomSheet(
                        message = R.string.text_email_send_sucess_recover_account_fragment
                    )*/
                    Toast.makeText(requireContext(), "Um link de recuperação foi enviado para o seu email.", Toast.LENGTH_SHORT).show()
                } else {
                   /* showBottomSheet(
                        message = FirebaseHelper.validError(task.exception?.message ?: "")
                    )*/
                    Toast.makeText(
                        requireContext(),
                        FirebaseHelper.validError(task.exception?.message ?: ""),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                binding.progressBar.isVisible = false
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
