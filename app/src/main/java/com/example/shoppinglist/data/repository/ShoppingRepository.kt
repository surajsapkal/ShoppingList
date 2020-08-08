package com.example.shoppinglist.data.repository

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entity.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDAO().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllShoppingItem() = db.getShoppingDAO().getAllShoppingitem()
}