package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mmcompany.goldengradenapp.Adapters.DesignAdapters.AdapterFruit
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.ActivityFruitactivityBinding

class Fruitactivity : AppCompatActivity() {
    private lateinit var binding: ActivityFruitactivityBinding
    var list = ArrayList<ShopViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fruitactivity)

        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF1",10.0,10,"#eb8500"))
        list.add(ShopViewModel(R.drawable.katna,"BFFFFFF2",10.0,10,"#039c12"))
        list.add(ShopViewModel(R.drawable.onion,"BFFFFFF3",10.0,10,"#e8b32c"))
        list.add(ShopViewModel(R.drawable.tomato,"BFFFFFF4",10.0,10,"#d45924"))
        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF5",10.0,10,"#eb8500"))
        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF1",10.0,10,"#eb8500"))
        list.add(ShopViewModel(R.drawable.katna,"BFFFFFF2",10.0,10,"#039c12"))
        list.add(ShopViewModel(R.drawable.onion,"BFFFFFF3",10.0,10,"#e8b32c"))
        list.add(ShopViewModel(R.drawable.tomato,"BFFFFFF4",10.0,10,"#d45924"))
        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF5",10.0,10,"#eb8500"))
        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF1",10.0,10,"#eb8500"))
        list.add(ShopViewModel(R.drawable.katna,"BFFFFFF2",10.0,10,"#039c12"))
        list.add(ShopViewModel(R.drawable.onion,"BFFFFFF3",10.0,10,"#e8b32c"))
        list.add(ShopViewModel(R.drawable.tomato,"BFFFFFF4",10.0,10,"#d45924"))
        list.add(ShopViewModel(R.drawable.carrot,"BFFFFFF5",10.0,10,"#eb8500"))

        binding.fruitRecyclerview.setHasFixedSize(true)
        var itemView: AdapterFruit = AdapterFruit(this,list)
        itemView.context = this
        binding.fruitRecyclerview.setLayoutManager(GridLayoutManager(this,2))
        itemView.shopList = list
        binding.fruitRecyclerview.adapter = itemView
    }
}