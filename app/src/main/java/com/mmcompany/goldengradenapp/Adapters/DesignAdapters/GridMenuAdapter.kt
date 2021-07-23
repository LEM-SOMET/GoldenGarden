package com.mmcompany.goldengradenapp.Adapters.DesignAdapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.mmcompany.goldengradenapp.Models.GridMenuModel
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.Fruitactivity
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.MeatsActivity
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.VegetableActivity
import com.mmcompany.goldengradenapp.Screens.Fragments.HomeScreensFragment
import com.mmcompany.goldengradenapp.databinding.CustomSingleItemMenuBinding

class GridMenuAdapter(homeScreensFragment: HomeScreensFragment, getList: ArrayList<GridMenuModel>) : Adapter<GridMenu>() {
    var gridMenu = ArrayList<GridMenuModel>()
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridMenu {
        var binding1 = CustomSingleItemMenuBinding.inflate(LayoutInflater.from(context),parent,false)
        var adapter = GridMenu(binding1)
        return  adapter
    }

    override fun onBindViewHolder(holder: GridMenu, position: Int) {
        var gridMenuSetter = gridMenu.get(position)
        holder.binding.image.setImageResource(gridMenuSetter.image)
        holder.binding.tvCategory.setText(gridMenuSetter.menuName)

        holder.binding.menuView.setOnClickListener(View.OnClickListener {
            if (gridMenu.get(position).menuName.equals("Vegetables")){
                var intent = Intent(context,VegetableActivity::class.java).apply {  }
                context?.startActivity(intent)
            } else if(gridMenu.get(position).menuName.equals("Fruits")) {
                var intent = Intent(context,Fruitactivity::class.java).apply {  }
                context?.startActivity(intent)
            }else if(gridMenu.get(position).menuName.equals("Meats")) {
                var intent = Intent(context,MeatsActivity::class.java).apply {  }
                context?.startActivity(intent)
            }

        })
    }

    override fun getItemCount(): Int {
        return gridMenu.size
    }
}

class GridMenu (itemView: CustomSingleItemMenuBinding): ViewHolder(itemView.root){
    var binding = itemView
}
