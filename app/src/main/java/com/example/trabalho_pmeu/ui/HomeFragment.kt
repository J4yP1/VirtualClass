package com.example.trabalho_pmeu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trabalho_pmeu.R
import androidx.navigation.fragment.findNavController
import com.example.trabalho_pmeu.databinding.FragmentHomePBinding
import com.example.trabalho_pmeu.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomePBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        configTablayout()

        initClicks()
    }

    private fun initClicks() {
        binding.ibLogout.setOnClickListener { logoutApp() }
    }

    private fun logoutApp() {
        auth.signOut()
        findNavController().navigate(R.id.action_homeP_to_auth)
    }

    private fun configTablayout() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(TodoFragment(), "Por fazer")
        adapter.addFragment(DoingFragment(), "A fazer")
        adapter.addFragment(DoneFragment(), "Feito")

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}