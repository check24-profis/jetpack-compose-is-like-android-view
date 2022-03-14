package de.check24.demo.features.list.staggered

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.check24.demo.databinding.ColorItemBinding
import kotlin.random.Random


class StaggeredAdapter :
    ListAdapter<Int, StaggeredAdapter.ColorViewHolder>(StaggeredDiffUtilCallback) {

    object StaggeredDiffUtilCallback : DiffUtil.ItemCallback<Int>() {

        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
            oldItem == newItem
    }

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder =
        ColorViewHolder(
            ColorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = getItem(position)
        val binding = ColorItemBinding.bind(holder.itemView)

        with(binding) {
            colorCard.setCardBackgroundColor(color)
            colorCard.updateLayoutParams {
                width = 120.dp
                height = Random.nextInt(100, 250).dp
            }
        }
    }

    val Int.dp get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}




