package com.mmcompany.goldengradenapp.Screens.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mmcompany.goldengradenapp.Adapters.DesignAdapters.GridMenuAdapter
import com.mmcompany.goldengradenapp.Models.GridMenuModel
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.FragmentHomeScreensBinding


class HomeScreensFragment : Fragment() {

    var getList = ArrayList<GridMenuModel>()
    lateinit var binding: FragmentHomeScreensBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getList.clear()
        getList.add(GridMenuModel("Vegetables",R.drawable.vegetableico))
        getList.add(GridMenuModel("Fruits",R.drawable.fruitico))
        getList.add(GridMenuModel("Meats",R.drawable.meats))
        getList.add(GridMenuModel("Things",R.drawable.vegetlogo))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreensBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerviewGridMenu.setHasFixedSize(true)
        var gridViewAdapter: GridMenuAdapter= GridMenuAdapter(this,getList)
        gridViewAdapter.context = context
        binding.recyclerviewGridMenu.setLayoutManager(GridLayoutManager(context,3))
        gridViewAdapter.gridMenu = getList
        binding.recyclerviewGridMenu.adapter = gridViewAdapter

    }
}