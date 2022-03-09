package de.check24.demo.features.list.differentviews

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class DifferentViewAdapter :
    ListAdapter<ExampleListItems, DifferentViewAdapter.ViewHolder>(DifferentViewDiffCallback) {

    object DifferentViewDiffCallback : DiffUtil.ItemCallback<ExampleListItems>() {
        override fun areItemsTheSame(
            oldItem: ExampleListItems,
            newItem: ExampleListItems
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(
            oldItem: ExampleListItems,
            newItem: ExampleListItems
        ): Boolean {
            TODO("Not yet implemented")
        }

    }

    class ViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}