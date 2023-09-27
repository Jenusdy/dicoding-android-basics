package io.github.jenusdy.view_pager_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.metamorfosis_telur,
            R.drawable.metamorfosis_ulat,
            R.drawable.metamorfosis_kepompong,
            R.drawable.metamorfosis_kupu
        )

        val adapter = ViewPagerAdapter(images)

        viewPager = findViewById(R.id.imageViewPager)

        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


    }
}