package tw.idv.jew.recyclerviewsample

import androidx.recyclerview.widget.DiffUtil

object MyDiffUtil : DiffUtil.ItemCallback<MyData>() {
    override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
        return oldItem == newItem
    }
}