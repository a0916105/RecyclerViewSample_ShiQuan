package tw.idv.jew.recyclerviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import tw.idv.jew.recyclerviewsample.databinding.AdapterMainBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val list = SortedList(
        MyData::class.java,
        MySortedListCallback(this)
    )

    fun addData(item: MyData) {
        list.add(item)
    }

    fun removeData(item: MyData) {
        list.remove(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(AdapterMainBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size()
    }
}

class MyViewHolder(private val binding: AdapterMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: MyData) {
        binding.title.text = data.value
    }
}