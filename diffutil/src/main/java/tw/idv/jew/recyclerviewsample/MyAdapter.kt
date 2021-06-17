package tw.idv.jew.recyclerviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import tw.idv.jew.recyclerviewsample.databinding.AdapterMainBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private var list = listOf<MyData>()

    fun setData(list: List<MyData>) {
        val callback = MyDiffUtil(this.list, list)
        val result = DiffUtil.calculateDiff(callback)
        this.list = list
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(AdapterMainBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}

class MyViewHolder(private val binding: AdapterMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: MyData) {
        binding.title.text = data.value
    }
}