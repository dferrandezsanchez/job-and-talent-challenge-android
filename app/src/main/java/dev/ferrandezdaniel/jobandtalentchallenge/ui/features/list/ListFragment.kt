package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ferrandezdaniel.jobandtalentchallenge.R
import dev.ferrandezdaniel.jobandtalentchallenge.databinding.ListFragmentBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.bindings.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.list_fragment) {

    private val viewModel: ListViewModel by viewModel()
    private val binding: ListFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listTitle.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }
    }
}
