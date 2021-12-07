package com.ainsigne.personsdemoapp.ui.details

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ainsigne.personsdemoapp.R
import com.ainsigne.personsdemoapp.base.BaseFragment
import com.ainsigne.personsdemoapp.databinding.FragmentDetailsBinding
import com.ainsigne.utilities.formatToDisplay
import com.ainsigne.utilities.loadUrl
import com.ainsigne.utilities.utcToDate

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val args : DetailsFragmentArgs by navArgs()

    override fun setUpView() {
        super.setUpView()
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            ivToolbar.loadUrl(drawable = R.drawable.app_icon, radius = R.dimen.default_corner_radius)
            ivPlaceholder.loadUrl(drawable = R.drawable.app_icon, radius = R.dimen.default_corner_radius)
            ivProfileLarge.loadUrl(url = args.user.largeUrl)
            tvUserGender.text = args.user.gender
            tvContactEmail.text = args.user.email
            tvContactMobile.text = args.user.phone
            tvUserBirthday.text = getString(R.string.birthday_with_age,  args.user.dob.utcToDate()?.formatToDisplay(), args.user.age.toString())
            tvUserFullname.text = args.user.fullName
            tvContactAddress.text = args.user.fullAddress
        }
    }
}