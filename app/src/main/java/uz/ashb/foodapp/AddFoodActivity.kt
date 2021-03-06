package uz.ashb.foodapp

import Cache.MySharedPrefarance
import Models.Food
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        title = "Taom qo'shish"

        MySharedPrefarance.init(this)

        btn_save.setOnClickListener {
            val name = edt_food_name.text.toString().trim()
            val products = edt_food_products.text.toString().trim()
            val preparationOrder = edt_preparation_order.text.toString().trim()

            if (name!="" && products!="" && preparationOrder!=""){
                val list = MySharedPrefarance.obektString
                list.add(Food(name, products, preparationOrder))
                MySharedPrefarance.obektString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Ma'lumot yetarli emas", Toast.LENGTH_SHORT).show()
            }

        }

    }
}