package com.example.viewpagerwithcustomtablayout

import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.viewpagerwithcustomtablayout.adapters.ViewPager2Adapter
import com.example.viewpagerwithcustomtablayout.adapters.ViewPagerCallBack
import com.example.viewpagerwithcustomtablayout.databinding.ActivityMainBinding
import com.example.viewpagerwithcustomtablayout.fragments.ItemFragment
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
