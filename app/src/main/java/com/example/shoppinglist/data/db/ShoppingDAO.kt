package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entity.ShoppingItem

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingitem(): LiveData<List<ShoppingItem>>
}