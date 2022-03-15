package de.check24.compose.demo.features.list.differentviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.check24.compose.demo.databinding.ContentItemBinding
import de.check24.compose.demo.databinding.TitleItemBinding

val CONTENT_TYPE = 0
val TITLE_TYPE = 1

class DifferentViewAdapter :
    ListAdapter<ExampleListItems, RecyclerView.ViewHolder>(DifferentViewDiffCallback) {

    object DifferentViewDiffCallback : DiffUtil.ItemCallback<ExampleListItems>() {

        override fun areItemsTheSame(
            oldItem: ExampleListItems,
            newItem: ExampleListItems
        ): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(
            oldItem: ExampleListItems,
            newItem: ExampleListItems
        ): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TITLE_TYPE)
            TitleViewHolder(
                TitleItemBinding.inflate(
                    LayoutInflater
                        .from(parent.context), parent, false
                ).root
            )
        else ContentViewHolder(
            ContentItemBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleViewHolder) {
            val titleItem = getItem(position) as ExampleListItems.TitleItem
            val binding = TitleItemBinding.bind(holder.itemView)

            binding.title.text = titleItem.title
        } else if (holder is ContentViewHolder) {
            val contentItem = getItem(position) as ExampleListItems.ContentItem
            val binding = ContentItemBinding.bind(holder.itemView)

            with(binding) {
                contentTitle.text = contentItem.title
                contentBody.text = contentItem.body
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ExampleListItems.ContentItem) CONTENT_TYPE
        else TITLE_TYPE
    }

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}