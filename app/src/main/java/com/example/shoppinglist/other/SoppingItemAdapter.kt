package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entity.ShoppingItem
import com.example.shoppinglist.ui.datalist.ShoppingViewModel
import kotlinx.android.synthetic.main.shoppimg_item.view.*

class ShoppingItemAdapter(
    var item : List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shoppimg_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItemView = item[position]

        holder.itemView.tv_name.text = currentItemView.name
        holder.itemView.tv_amount.text = "${currentItemView.amount}"

        holder.itemView.iv_delete.setOnClickListener {
            viewModel.delete(currentItemView)
        }

        holder.itemView.iv_plus.setOnClickListener {
            currentItemView.amount++
            viewModel.upsert(currentItemView)
        }

        holder.itemView.iv_minus.setOnClickListener {
            if (currentItemView.amount>0){
                currentItemView.amount--
                viewModel.upsert(currentItemView)
            }
        }
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}