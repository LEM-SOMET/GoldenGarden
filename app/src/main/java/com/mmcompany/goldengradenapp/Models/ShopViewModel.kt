package com.mmcompany.goldengradenapp.Models

import java.io.Serializable

data class ShopViewModel (var image: Int, var name: String,
                          var price: Double, var dis: Int,var colors: String): Serializable {
}