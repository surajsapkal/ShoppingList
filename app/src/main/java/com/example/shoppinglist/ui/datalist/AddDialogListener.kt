package com.example.shoppinglist.ui.datalist

import com.example.shoppinglist.data.db.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}