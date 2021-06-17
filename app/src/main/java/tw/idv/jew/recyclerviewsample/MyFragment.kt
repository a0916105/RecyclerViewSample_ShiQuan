package tw.idv.jew.recyclerviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tw.idv.jew.recyclerviewsample.databinding.ActivityMainBinding
import java.lang.RuntimeException

class MyFragment : Fragment() {

    companion object {
        fun newInstance() = MyFragment()
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("This property is only valid between onCreateView and onDestroyView")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = MyAdapter()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        adapter.setData(genData())

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun genData() = (0..100).map {
        MyData(it.toString())
    }
}