package com.ainsigne.personsdemoapp.ui.main


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ainsigne.personsdemoapp.base.BaseFragment
import com.ainsigne.personsdemoapp.databinding.FragmentMainBinding
import com.ainsigne.personsdemoapp.ui.main.adapter.PersonsAdapter
import kotlinx.coroutines.flow.collect

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    var adapter : PersonsAdapter? = null

    override fun setUpView() {
        super.setUpView()
        binding.apply {
            swipeRefresh.setOnRefreshListener {
                viewModel.refreshContent()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshContent()
    }


    override fun setUpObserver() {
        super.setUpObserver()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.personsState.collect { state ->
                when(state) {
                    is PersonsState.Error -> Log.d(" Data Error ", " Data ${state.error}")
                }
            }
        }
    }
}