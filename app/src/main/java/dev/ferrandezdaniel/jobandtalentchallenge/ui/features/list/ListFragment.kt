package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ferrandezdaniel.jobandtalentchallenge.R
import dev.ferrandezdaniel.jobandtalentchallenge.databinding.ListFragmentBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.bindings.viewBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model.RestaurantModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.list_fragment) {

    private lateinit var adapter: RestaurantsListAdapter
    private val viewModel: ListViewModel by viewModel()
    private val binding: ListFragmentBinding by viewBinding()
    private val restaurantsList = ArrayList<RestaurantModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        observers()
    }

    private fun setupRecycler() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.listRestaurantsList.layoutManager = linearLayoutManager
        adapter = RestaurantsListAdapter(requireContext(), restaurantsList) {
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(it)
            findNavController().navigate(action)
        }
        binding.listRestaurantsList.adapter = adapter
    }

    private fun observers() {
        viewModel.loadingData.observe(viewLifecycleOwner) {
            if (it)
                binding.listRestaurantsProgress.show()
            else
                binding.listRestaurantsProgress.hide()
        }
        viewModel.restaurantsList.observe(viewLifecycleOwner) {
            restaurantsList.clear()
            it.map { restaurantModel ->
                restaurantsList.add(restaurantModel)
                adapter.notifyItemChanged(restaurantsList.indexOf(restaurantModel))
            }
        }
        viewModel.restaurantsException.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }
}
