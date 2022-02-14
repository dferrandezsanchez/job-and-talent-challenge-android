package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dev.ferrandezdaniel.jobandtalentchallenge.databinding.RestaurantListItemBinding
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model.RestaurantModel

class RestaurantsListAdapter(
    private val context: Context,
    private val restaurantsList: ArrayList<RestaurantModel>,
    private val listener: (RestaurantModel) -> Unit
) : RecyclerView.Adapter<RestaurantsListAdapter.RestaurantsViewHolder>() {

    inner class RestaurantsViewHolder(val binding: RestaurantListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val binding = RestaurantListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RestaurantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        with(holder) {
            with(restaurantsList[position]) {
                binding.root.setOnClickListener { listener(this) }
                binding.restaurantItemListHeaderLayout.restaurantItemListHeaderTitle.text = this.name
                binding.restaurantItemListSubTitle.text = this.description
                binding.restaurantItemListHeaderLayout.restaurantItemListHeaderSubTitle.text = this.type
                Glide.with(context)
                    .load(this.logo)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.binding.restaurantItemListImage)

                Glide.with(context)
                    .load(this.logo)
                    .circleCrop()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.binding.restaurantItemListHeaderLayout.restaurantItemListHeaderAvatar)
            }
        }
    }

    override fun getItemCount(): Int = restaurantsList.size
}
