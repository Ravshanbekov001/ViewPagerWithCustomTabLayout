package com.example.viewpagerwithcustomtablayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerwithcustomtablayout.databinding.FragmentItemBinding
import com.example.viewpagerwithcustomtablayout.models.ViewPager2ItemData

interface ViewPagerCallBack {

    fun viewPagerClickListener(position: Int)
}

class ViewPager2Adapter(
    val list: List<ViewPager2ItemData>,
    val viewPagerCallBack: ViewPagerCallBack,
) :
    RecyclerView.Adapter<ViewPager2Adapter.VH>() {

    inner class VH(var itemRv: FragmentItemBinding) : RecyclerView.ViewHolder(itemRv.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemRv.pageItemImage.setImageResource(list[position].image)
        holder.itemRv.kattaText.text = list[position].big_text
        holder.itemRv.kichkinaText.text = list[position].small_text


        holder.itemRv.pageItemImage.setOnClickListener {
            viewPagerCallBack.viewPagerClickListener(position)
        }
    }

    override fun getItemCount(): Int = list.size
}