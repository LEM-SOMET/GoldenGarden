package com.mmcompany.goldengradenapp.Adapters.DesignAdapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.MeatsActivity
import com.mmcompany.goldengradenapp.databinding.CustomSingleItemMeatsBinding
class AdapterMeat(meatsActivity: MeatsActivity, itemList: ArrayList<ShopViewModel>) : RecyclerView.Adapter<ItemAdapter123>() {
    var contaxt: Context? = null
    var itemList = ArrayList<ShopViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter123 {
        var binding1 = CustomSingleItemMeatsBinding.inflate(LayoutInflater.from(contaxt),parent,false)
        var adapter = ItemAdapter123(binding1)
        return adapter
    }

    override fun onBindViewHolder(holder: ItemAdapter123, position: Int) {
        var dataSetter = itemList.get(position)
        holder.binding.imgMeat.setImageResource(dataSetter.image)
        holder.binding.tvnameItem.setText(dataSetter.name)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
class ItemAdapter123(iteView: CustomSingleItemMeatsBinding):RecyclerView.ViewHolder(iteView.root){
    var binding = iteView
}