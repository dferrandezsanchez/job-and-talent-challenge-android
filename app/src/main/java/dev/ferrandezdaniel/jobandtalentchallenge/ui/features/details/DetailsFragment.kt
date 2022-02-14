package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dev.ferrandezdaniel.jobandtalentchallenge.R
import dev.ferrandezdaniel.jobandtalentchallenge.databinding.DetailsFragmentBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.bindings.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: DetailsViewModel by viewModel()
    private val binding: DetailsFragmentBinding by viewBinding()
    private val arguments: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(arguments.restaurantModel) {
            Glide.with(requireContext()).load(this.logo).into(binding.restaurantDetailsImage)
            binding.restaurantDetailsTitle.text = this.name
            binding.restaurantDetailsType.text = this.type
            binding.restaurantDetailsDesc.text = this.description
        }
    }
}
