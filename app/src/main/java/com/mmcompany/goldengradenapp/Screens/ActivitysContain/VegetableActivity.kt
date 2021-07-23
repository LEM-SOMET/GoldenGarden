package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmcompany.goldencoraladdison.Models.CallbackMethod.Onclick
import com.mmcompany.goldengradenapp.Adapters.VegetablesAdapters
import com.mmcompany.goldengradenapp.Models.VegetablesModels
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.ActivityVegetableBinding
import java.text.DecimalFormat

class VegetableActivity : AppCompatActivity() {

    var dataList1 = ArrayList<VegetablesModels>()
    private lateinit var binding: ActivityVegetableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_vegetable)
        dataList1 = ArrayList<VegetablesModels>()

        dataList1.add(VegetablesModels(R.drawable.katna,"Katna","04",0,4.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.cuccamber,"Cuccamber","01",0,2.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.carrot,"Carrot","02",0,11.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.tomato,"Tomato","03",0,8.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.katna,"Katna","04",0,4.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.cuccamber,"Cuccamber","01",0,2.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.carrot,"Carrot","02",0,11.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.tomato,"Tomato","03",0,8.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.katna,"Katna","04",0,4.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.cuccamber,"Cuccamber","01",0,2.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.carrot,"Carrot","02",0,11.4,0.0,0.0))
        dataList1.add(VegetablesModels(R.drawable.tomato,"Tomato","03",0,8.4,0.0,0.0))

        binding.recyclerviewIdList.setHasFixedSize(true)
        var listAdapterView: VegetablesAdapters = VegetablesAdapters(this, dataList1)
        listAdapterView.contaxt = this
        binding.recyclerviewIdList.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false))

        listAdapterView.list = dataList1
        binding.recyclerviewIdList.adapter = listAdapterView
        val dec = DecimalFormat("#.00")

        var btn: ImageButton = findViewById(R.id.btn_add_to_cart_id)
        listAdapterView.onclick = object : Onclick {
            override fun <D> onSubmit(d: D) {
                var model = d as ArrayList<VegetablesModels>
                if(model.size >= 0) {
                    btn.setOnClickListener(View.OnClickListener {
                        var intent = Intent(this@VegetableActivity, AddtocardActivity::class.java).apply {
                            putExtra("value",model)
                            putExtra("index",model.size)
                        }
                        this@VegetableActivity?.startActivity(intent)
                    })
                }
            }
        }
    }

}