package com.example.viewpagerwithcustomtablayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerwithcustomtablayout.databinding.ActivityMainBinding
import com.example.viewpagerwithcustomtablayout.databinding.ItemRvBinding
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData

interface ViewPagerCallBack {

    fun viewPagerClickListener()
}

class ViewPager2Adapter(
    val list: List<ViewPager2ItemData>,
//    val viewPagerCallBack: ViewPagerCallBack,
) :
    RecyclerView.Adapter<ViewPager2Adapter.VH>() {

    inner class VH(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    val selectedItemPosition = -1

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemRv.pageItemImage.setImageResource(list[position].image)
        holder.itemRv.kattaText.text = list[position].big_text
        holder.itemRv.kichkinaText.text = list[position].small_text

        if (selectedItemPosition == position) {

        }

        holder.itemRv.pageItemImage.setOnClickListener {
            holder.itemRv.pageItemImage.setImageResource(list[position].images[position])
            
            holder.itemRv.kattaText.isGone = true
            holder.itemRv.kichkinaText.isGone = true
        }


    }

    override fun getItemCount(): Int = list.size
}