package tw.idv.jew.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.idv.jew.recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyFragment.newInstance())
                .commitNow()
        }
    }
}