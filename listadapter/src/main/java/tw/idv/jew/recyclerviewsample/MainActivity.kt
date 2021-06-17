package tw.idv.jew.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tw.idv.jew.recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyAdapter()
        lifecycleScope.launch {
            with(binding) {
                recyclerView.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = adapter

                adapter.setData(genData())
                delay(1000)
                adapter.setData(genData2())
                delay(1000)
                adapter.setData(genData())
                delay(1000)
                adapter.setData(genData2())
                delay(1000)
                adapter.setData(genData())
            }
        }
    }

    private fun genData() = (0..100).map {
        MyData(it, it.toString())
    }

    private fun genData2() = (0..100).map {
        MyData(it * 2, (it * 2).toString())
    }
}