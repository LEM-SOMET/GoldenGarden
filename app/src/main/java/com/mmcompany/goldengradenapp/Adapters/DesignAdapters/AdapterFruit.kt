package com.mmcompany.goldengradenapp.Adapters.DesignAdapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.FruitDetails
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.Fruitactivity
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.MeatsActivity
import com.mmcompany.goldengradenapp.databinding.CustomSingleItemFruitsBinding

class AdapterFruit(fruitactivity: Fruitactivity, list: ArrayList<ShopViewModel>) : RecyclerView.Adapter<IteAdapter>() {


    var context: Context? = null
    var shopList = ArrayList<ShopViewModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IteAdapter {
        var binding1= CustomSingleItemFruitsBinding.inflate(LayoutInflater.from(context),parent,false)
        var dapter = IteAdapter(binding1)
        return dapter
    }

    override fun onBindViewHolder(holder: IteAdapter, position: Int) {
        var dataSetter = shopList.get(position)
        holder.binding.fruitImage.setImageResource(dataSetter.image)
        holder.binding.fruitName.setText(dataSetter.name)
        holder.binding.tvPrice.setText("$${dataSetter.price}")
        holder.binding.backCardView.setBackgroundColor(Color.parseColor("${dataSetter.colors}"))
        holder.binding.backCardView.setOnClickListener(View.OnClickListener {
            var intent = Intent(context,FruitDetails::class.java).apply {
                putExtra("value",shopList)
                putExtra("index",position)
            }
            context?.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}

class IteAdapter (itemView: CustomSingleItemFruitsBinding):RecyclerView.ViewHolder(itemView.root){
    var binding = itemView

}
