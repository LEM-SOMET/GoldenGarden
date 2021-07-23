package com.mmcompany.goldengradenapp.Screens.ActivitysContain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mmcompany.goldengradenapp.Models.VegetablesModels
import com.mmcompany.goldengradenapp.R
import com.mmcompany.goldengradenapp.databinding.ActivityVegetableDetailsBinding

class VegetableDetails : AppCompatActivity() {

    private lateinit var binding: ActivityVegetableDetailsBinding
    private  var text = "\t Here are some adjectives for vegetable: tasteless stewed, bitter leafy, surprisingly delectable, plump, rich, blindly animated, overlying dark, night-time certain, pitifully sparse, finest autumnal, loose and bibulous, inexpensive italian, delicious and attractive, strongly tinctorial, fitful but rewarding, squeaky ..."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_vegetable_details)
        var item = intent.getSerializableExtra("item") as ArrayList<VegetablesModels>
        var pos = intent.getIntExtra("index",0) as Int
        binding.imgVegetid.setImageResource(item.get(pos).v_img)
        binding.tvVgetVameId.setText(item.get(pos).v_name)
        binding.tvPrice.setText("$"+item.get(pos).v_price)
        binding.tvDetailVgt.setText("$text")

    }
}