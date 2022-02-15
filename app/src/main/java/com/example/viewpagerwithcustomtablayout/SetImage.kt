package com.example.viewpagerwithcustomtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.viewpagerwithcustomtablayout.databinding.ActivitySetImageBinding

class SetImage : AppCompatActivity() {

    lateinit var binding: ActivitySetImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar transparent background
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = resources.getColor(android.R.color.transparent)

        // NavigationBar transparent background
        window.decorView.systemUiVisibility =
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.navigationBarColor = resources.getColor(android.R.color.transparent)

        val image = intent.getIntExtra("image", 0)
        binding.setImage.setImageResource(image)

    }
}