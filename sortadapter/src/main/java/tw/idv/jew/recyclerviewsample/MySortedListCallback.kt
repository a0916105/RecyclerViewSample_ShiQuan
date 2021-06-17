package tw.idv.jew.recyclerviewsample;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedListAdapterCallback

class MySortedListCallback(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) :
        SortedListAdapterCallback<MyData>(adapter) {

        override fun compare(o1: MyData?, o2: MyData?): Int {
            return (o1?.id ?: 0) - (o2?.id ?: 0)
        }

        override fun areContentsTheSame(
            oldItem: MyData?,
            newItem: MyData?
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(item1: MyData?, item2: MyData?): Boolean {
            return item1?.id == item2?.id
        }
}