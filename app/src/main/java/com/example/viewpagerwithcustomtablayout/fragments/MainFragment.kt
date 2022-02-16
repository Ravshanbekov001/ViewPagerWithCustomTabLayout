package com.example.viewpagerwithcustomtablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.viewpagerwithcustomtablayout.R
import com.example.viewpagerwithcustomtablayout.adapters.ViewPager2Adapter
import com.example.viewpagerwithcustomtablayout.adapters.ViewPagerCallBack
import com.example.viewpagerwithcustomtablayout.databinding.FragmentMainBinding
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    lateinit var list: ArrayList<ViewPager2ItemData>
    lateinit var viewPager2Adapter: ViewPager2Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // StatusBar transparent background
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        requireActivity().window.statusBarColor = resources.getColor(android.R.color.transparent)

        // NavigationBar transparent background
        requireActivity().window.decorView.systemUiVisibility =
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        requireActivity().window.navigationBarColor =
            resources.getColor(android.R.color.transparent)

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


        val listImage = listOf(R.drawable.splash1_1,
            R.drawable.splash2_2,
            R.drawable.splash3_3,
            R.drawable.splash4_4)

        viewPager2Adapter = ViewPager2Adapter(list, object : ViewPagerCallBack {
            override fun viewPagerClickListener(position: Int) {
                findNavController().navigate(R.id.action_mainFragment_to_setImageFragment,
                    bundleOf("image" to listImage[position]))
            }
        })
        binding.viewPager2.adapter = viewPager2Adapter

        binding.otkazibYuborish.setOnClickListener {
            binding.viewPager2.currentItem = list.size - 1
        }


        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> }.attach()
    }
}