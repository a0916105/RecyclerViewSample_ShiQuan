package tw.idv.jew.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tw.idv.jew.recyclerviewsample.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch {
            with(binding) {
                recyclerView.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = adapter
            }
            val list = getList()
            val attachList = mutableListOf<MyData>()
            val random = Random.Default
            while (list.size > 0) {
                list.poll()?.let {
                    adapter.addData(it)
                    attachList.add(it)
                }
                delay(10)
                if (random.nextBoolean()) {
                    attachList.randomOrNull()?.let {
                        adapter.removeData(it)
                        attachList.remove(it)
                        list.add(it)
                        delay(10)
                    }
                }
            }
        }
    }

    private fun getList(): Queue<MyData> {
        val list = (0..100).map(::getData).toMutableList()
        list.shuffle()
        return LinkedList(list)
    }

    private fun getData(id: Int) = MyData(id, id.toString())
}