package com.mmcompany.goldengradenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mmcompany.goldengradenapp.Screens.Fragments.FragmentShopping
import com.mmcompany.goldengradenapp.Screens.Fragments.HomeScreensFragment
import com.mmcompany.goldengradenapp.Screens.Fragments.MapFragment
import com.mmcompany.goldengradenapp.Screens.Fragments.UserInforFragment
import com.mmcompany.goldengradenapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        var homFragment  = HomeScreensFragment()
        var shopFrament = FragmentShopping()
        var userinforfragment = UserInforFragment()
        var map = MapFragment()
        setCurrentFragment(homFragment)

        binding.bottomNavigations.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(homFragment)
                R.id.shop->setCurrentFragment(shopFrament)
                R.id.map->setCurrentFragment(map)
                R.id.peronal->setCurrentFragment(userinforfragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.homeFragment,fragment)
            commit()
        }
}