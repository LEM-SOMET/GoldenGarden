package com.mmcompany.goldengradenapp.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mmcompany.goldencoraladdison.Models.CallbackMethod.Onclick
import com.mmcompany.goldencoraladdison.Models.CallbackMethod.PayemntCallBack
import com.mmcompany.goldengradenapp.Models.VegetablesModels
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.VegetableActivity
import com.mmcompany.goldengradenapp.Screens.ActivitysContain.VegetableDetails
import com.mmcompany.goldengradenapp.databinding.CustomSingleItemAddtocartBinding
import java.text.DecimalFormat

class VegetablesAdapters(
    vegetableActivity: VegetableActivity,
    dataList1: ArrayList<VegetablesModels>
) : Adapter<Adpater1>() {
    var list= ArrayList<VegetablesModels>()
    var contaxt: Context? = null
    var tempList = ArrayList<VegetablesModels>()
    var onclick: Onclick? =  null
    var callPay: PayemntCallBack? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adpater1 {
        var binding = CustomSingleItemAddtocartBinding.inflate(LayoutInflater.from(contaxt),parent,false)
        var ad1 = Adpater1(binding)
        return  ad1
    }

    override fun onBindViewHolder(holder: Adpater1, position: Int) {
        var datasetter: VegetablesModels = list.get(position)
        holder.binding.imgVgetId.setImageResource(datasetter.v_img)
        holder.binding.vCodeId.setText(datasetter.v_code)
        holder.binding.tvVgetNameId.setText(datasetter.v_name)
        holder.binding.vPriceId.setText("$"+datasetter.v_price.toString())
        holder.binding.vQtyId.setText(datasetter.v_qty.toString())
        holder.binding.vTotalId.setText("$" + datasetter.v_total.toString())

        holder.binding.addtocartView.setOnClickListener(View.OnClickListener {
            var intent = Intent(contaxt,VegetableDetails::class.java).apply {
                putExtra("item",list)
                putExtra("index",position)
            }
            contaxt?.startActivity(intent)
        })

        var getSelectedQty: Int = 0
        var payment: Double = 0.0
        val dec = DecimalFormat("#.00")

        holder.binding.btnAddId.setVisibility(View.VISIBLE)
        holder.binding.btnAddId.setOnClickListener(View.OnClickListener {
            holder.binding.btnAddId.setVisibility(View.GONE)
            getSelectedQty++

            var price = datasetter.v_price
            var total: Double = getSelectedQty * price
            datasetter.v_total = total
            payment  = payment +  total
            datasetter.payment = payment
            datasetter.v_qty = getSelectedQty
            if (datasetter.v_qty >= 0){
                tempList.add(datasetter)
                onclick?.onSubmit(tempList)
            }

            holder.binding.vTotalId.setText("\$${dec.format(total)}")
            holder.binding.tvQtyShowId.setText("$getSelectedQty")
            holder.binding.vQtyId.setText(getSelectedQty.toString())
        })

        holder.binding.btnSumId.setOnClickListener(View.OnClickListener {
            getSelectedQty++
            var price = datasetter.v_price
            var total: Double = getSelectedQty * price
            datasetter.v_total = total
            datasetter.v_qty = getSelectedQty
            payment  = payment +  total
            datasetter.payment = payment

            holder.binding.vTotalId.setText("\$${dec.format(total)}")
            holder.binding.tvQtyShowId.setText("$getSelectedQty")
            holder.binding.vQtyId.setText(getSelectedQty.toString())
        })

        holder.binding.btnSubId.setOnClickListener(View.OnClickListener {
            getSelectedQty--
                if (getSelectedQty <= 0) {
                    holder.binding.btnAddId.setVisibility(View.VISIBLE)
                }
            if (getSelectedQty == 0) {
                tempList.remove(datasetter)
                Log.d("Data Delerted", "==========> ${datasetter} ")
                Log.d("Data Delerted", "==========> ${tempList.size} ")
            } else {
                datasetter.v_qty = getSelectedQty
                var price = datasetter.v_price
                var total: Double = getSelectedQty * price
                datasetter.v_total = total
                datasetter.v_qty = getSelectedQty
                payment  = payment -  total
                datasetter.payment = payment

                holder.binding.vTotalId.setText("\$${dec.format(total)}")
                holder.binding.tvQtyShowId.setText("$getSelectedQty")
                holder.binding.vQtyId.setText(getSelectedQty.toString())
                holder.binding.tvQtyShowId.setText("$getSelectedQty")
            }

        })

    }
    override fun getItemCount(): Int {
        return list.size
    }
}
class Adpater1(itemView: CustomSingleItemAddtocartBinding) : ViewHolder(itemView.root) {
    var binding = itemView
}