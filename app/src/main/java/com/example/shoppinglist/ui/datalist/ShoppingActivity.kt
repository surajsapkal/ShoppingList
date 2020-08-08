package com.example.shoppinglist.ui.datalist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entity.ShoppingItem
import com.example.shoppinglist.data.repository.ShoppingRepository
import com.example.shoppinglist.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        rv_shoppingItem.layoutManager = LinearLayoutManager(this)
        rv_shoppingItem.adapter = adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            adapter.item = it
            adapter.notifyDataSetChanged()
        })

        fab_add.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}