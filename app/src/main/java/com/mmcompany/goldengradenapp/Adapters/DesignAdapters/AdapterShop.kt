package com.mmcompany.goldengradenapp.Adapters.DesignAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.Fruitactivity
import com.mmcompany.goldengradenapp.Screens.Fragments.FragmentShopping
import com.mmcompany.goldengradenapp.databinding.CustomItemShoppingBinding

class AdapterShop(fragmentShopping: FragmentShopping, listItem: ArrayList<ShopViewModel>) : RecyclerView.Adapter<Adapters>() {


    var context: Context? = null
    var shopList = ArrayList<ShopViewModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapters {
        var binding1= CustomItemShoppingBinding.inflate(LayoutInflater.from(context),parent,false)
        var dapter = Adapters(binding1)
        return dapter
    }

    override fun onBindViewHolder(holder: Adapters, position: Int) {
        var dataSetter = shopList.get(position)
        holder.binding.imageItemshop.setImageResource(dataSetter.image)
        holder.binding.tvItemName.setText(dataSetter.name)
        holder.binding.tvDiscount.setText("${dataSetter.dis}%")
        holder.binding.tvItemPrice.setText("$${dataSetter.price}")
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}

class Adapters (itemView: CustomItemShoppingBinding):RecyclerView.ViewHolder(itemView.root){
    var binding = itemView

}
