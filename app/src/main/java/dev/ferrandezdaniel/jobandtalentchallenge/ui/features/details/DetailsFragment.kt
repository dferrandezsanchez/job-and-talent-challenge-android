package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ferrandezdaniel.jobandtalentchallenge.R
import dev.ferrandezdaniel.jobandtalentchallenge.databinding.DetailsFragmentBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.bindings.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: DetailsViewModel by viewModel()
    private val binding: DetailsFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailsTitle.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}