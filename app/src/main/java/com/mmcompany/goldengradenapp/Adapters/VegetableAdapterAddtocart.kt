package com.mmcompany.goldengradenapp.Adapters.DesignAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmcompany.goldengradenapp.Models.VegetablesModels
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.AddtocardActivity
import com.mmcompany.goldengradenapp.databinding.CustomItemOnadtocartBinding
import java.text.DecimalFormat

class VegetableAdapterAddtocart(
    addtocardActivity: AddtocardActivity,
    dataList2: ArrayList<VegetablesModels>
) : RecyclerView.Adapter<VegetAddtocart>() {
    var list= ArrayList<VegetablesModels>()
    var contaxt: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetAddtocart {
        var binding2 = CustomItemOnadtocartBinding.inflate(LayoutInflater.from(contaxt),parent,false)
        var ad1 = VegetAddtocart(binding2)
        return  ad1
    }

    override fun onBindViewHolder(holder: VegetAddtocart, position: Int) {
        var datasetter: VegetablesModels = list.get(position)
        val dec = DecimalFormat("#.00")
        holder.binding.imgVgetIdAddtocart.setImageResource(datasetter.v_img)
        holder.binding.tvVgetNameIdAddtocart.setText(datasetter.v_name)
        holder.binding.vCodeId.setText(datasetter.v_code)
        holder.binding.vQtyIdAddtocart.setText(datasetter.v_qty.toString())
        holder.binding.vPriceIdAddtocart.setText("$" + dec.format(datasetter.v_price))
        holder.binding.vTotalIdAddtocart.setText("$" + dec.format(datasetter.v_total))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class VegetAddtocart(itemView: CustomItemOnadtocartBinding): RecyclerView.ViewHolder(itemView.root){
    var binding = itemView
}
