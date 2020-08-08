package com.example.shoppinglist.ui.datalist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entity.ShoppingItem
import kotlinx.android.synthetic.main.dailog_add_shopping_item.*
import kotlinx.android.synthetic.main.shoppimg_item.*

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dailog_add_shopping_item)

        tv_add.setOnClickListener {
            val name = et_name.text.toString()
            val amount = et_amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"All Fields are Required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel.setOnClickListener {
            cancel()
        }
    }
}