package com.ainsigne.personsdemoapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ainsigne.personsdemoapp.R
import com.ainsigne.personsdemoapp.base.BaseFragment
import com.ainsigne.personsdemoapp.databinding.FragmentDetailsBinding
import com.ainsigne.personsdemoapp.databinding.FragmentMainBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    override fun setUpView() {
        super.setUpView()
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}