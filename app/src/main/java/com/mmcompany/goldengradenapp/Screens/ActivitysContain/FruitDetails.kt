package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.ActivityFruitDetailsBinding
import com.mmcompany.goldengradenapp.databinding.ActivityFruitactivityBinding
import com.mmcompany.goldengradenapp.databinding.ActivityVegetableDetailsBinding

class FruitDetails : AppCompatActivity() {
    lateinit var binding: ActivityFruitDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fruit_details)


        var items = intent.getSerializableExtra("value") as ArrayList<ShopViewModel>
        var i:Int = intent.getIntExtra("index",0) as Int
        binding.imgItem.setImageResource(items.get(i).image)
        binding.tvItemName.setText(items.get(i).name)
        binding.tvItemName1.setText(items.get(i).name)

        binding.itemColoView.setBackgroundColor(Color.parseColor("${items.get(i).colors}"))
        binding.imbtnadd.setBackgroundColor(Color.parseColor("${items.get(i).colors}"))
        binding.imbtnsub.setBackgroundColor(Color.parseColor("${items.get(i).colors}"))
        binding.tvItemName.setTextColor(Color.parseColor("${items.get(i).colors}"))
        binding.tvItemName1.setTextColor(Color.parseColor("${items.get(i).colors}"))

    }
}