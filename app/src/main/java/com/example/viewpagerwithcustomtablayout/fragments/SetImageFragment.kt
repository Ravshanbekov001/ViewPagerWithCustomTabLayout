package com.example.viewpagerwithcustomtablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.viewpagerwithcustomtablayout.R
import com.example.viewpagerwithcustomtablayout.adapters.ViewPager2Adapter
import com.example.viewpagerwithcustomtablayout.adapters.ViewPagerCallBack
import com.example.viewpagerwithcustomtablayout.databinding.FragmentSetImageBinding
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SetImageFragment : Fragment() {

    lateinit var binding: FragmentSetImageBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentSetImageBinding.inflate(layoutInflater)

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


        binding.setImage.setImageResource(arguments?.getInt("image")!!)

        binding.setImage.setOnClickListener {
            findNavController().popBackStack()
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SetImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}