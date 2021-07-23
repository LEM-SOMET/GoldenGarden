package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmcompany.goldengradenapp.Adapters.DesignAdapters.AdapterMeat
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.ActivityMeatsBinding

class MeatsActivity : AppCompatActivity() {
     lateinit var binding: ActivityMeatsBinding
     var itemList1 = ArrayList<ShopViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_meats)

        itemList1.add(ShopViewModel(R.drawable.meats1,"Khatna",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Carrot",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Tomato",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Onion",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Khatna",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Carrot",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Tomato",10.2,10,""))
        itemList1.add(ShopViewModel(R.drawable.meats1,"Onion",10.2,10,""))

        binding.meatRecyclerView.setHasFixedSize(true)
        var itemAdapter: AdapterMeat = AdapterMeat(this, itemList1)
        itemAdapter.contaxt = this
        binding.meatRecyclerView.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false))
        itemAdapter.itemList = itemList1
        binding.meatRecyclerView.adapter = itemAdapter
    }
}