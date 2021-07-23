package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmcompany.goldengradenapp.Adapters.DesignAdapters.VegetableAdapterAddtocart
import com.mmcompany.goldengradenapp.Models.VegetablesModels
import com.mmcompany.goldengradenapp.R

class AddtocardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocard)
        var dataList2 = intent.getSerializableExtra("value") as ArrayList<VegetablesModels>

        var recyclerView1: RecyclerView = findViewById(R.id.addtocartRecyclerview)
        recyclerView1.setHasFixedSize(true)
        var dataListRecycle: VegetableAdapterAddtocart = VegetableAdapterAddtocart( this, dataList2)
        dataListRecycle.contaxt = this
        recyclerView1.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false))
        dataListRecycle.list = dataList2
        recyclerView1.adapter = dataListRecycle
    }
}