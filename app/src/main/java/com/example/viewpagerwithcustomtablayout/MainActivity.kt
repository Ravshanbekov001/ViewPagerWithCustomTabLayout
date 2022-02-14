package com.example.viewpagerwithcustomtablayout

import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerwithcustomtablayout.adapters.ViewPager2Adapter
import com.example.viewpagerwithcustomtablayout.adapters.ViewPagerCallBack
import com.example.viewpagerwithcustomtablayout.databinding.ActivityMainBinding
import com.example.viewpagerwithcustomtablayout.databinding.ItemRvBinding
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var bindingItem: ItemRvBinding

    lateinit var list: ArrayList<ViewPager2ItemData>
    lateinit var viewPager2Adapter: ViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bindingItem = ItemRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar transparent background
        window.decorView.systemUiVisibility =
            SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = resources.getColor(android.R.color.transparent)

        // NavigationBar transparent background
        window.decorView.systemUiVisibility =
            FLAG_LAYOUT_NO_LIMITS or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.navigationBarColor = resources.getColor(android.R.color.transparent)


        list = ArrayList()
        list.add(ViewPager2ItemData(R.drawable.splash1,
            "Xush kelibsiz",
            "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                    "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘"))

        list.add(ViewPager2ItemData(R.drawable.splash2,
            "Hikoyalar dunyosi",
            "Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                    "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! "))

        list.add(ViewPager2ItemData(R.drawable.splash3,
            "Kitob ortidan..",
            "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                    " Kelmadi jonimg'a hech oromi jondin yaxshilig'."))

        list.add(ViewPager2ItemData(R.drawable.splash4,
            "Bizga qo`shiling",
            "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                    " Endi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?"))


        viewPager2Adapter = ViewPager2Adapter(list)
        binding.viewPager2.adapter = viewPager2Adapter

        binding.otkazibYuborish.setOnClickListener {
            binding.viewPager2.currentItem = list.size - 1
        }


        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> }.attach()


    }
}
