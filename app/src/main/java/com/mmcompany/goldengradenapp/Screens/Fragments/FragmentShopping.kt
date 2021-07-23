package com.mmcompany.goldengradenapp.Screens.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mmcompany.goldengradenapp.Adapters.DesignAdapters.AdapterShop
import com.mmcompany.goldengradenapp.Models.ShopViewModel
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.FragmentShoppingBinding


class FragmentShopping : Fragment() {

    lateinit var binding : FragmentShoppingBinding
    var listItem = ArrayList<ShopViewModel>()
    var grideAdapter: AdapterShop? = null

    var getSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listItem.clear()
        listItem.add(ShopViewModel(R.drawable.katna,"Khatna",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.carrot,"Carrot",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.tomato,"Tomato",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.onion,"Onion",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.katna,"Khatna",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.carrot,"Carrot",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.tomato,"Tomato",10.2,10,""))
        listItem.add(ShopViewModel(R.drawable.onion,"Onion",10.2,10,""))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerviewViewGrid.setHasFixedSize(true)
        var gridItemShopAdapter: AdapterShop = AdapterShop(this,listItem)
        gridItemShopAdapter.context = context
        binding.recyclerviewViewGrid.setLayoutManager(GridLayoutManager(context,2))
        gridItemShopAdapter.shopList = listItem
        binding.recyclerviewViewGrid.adapter = gridItemShopAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingBinding.inflate(inflater)
        return binding.root
    }

}