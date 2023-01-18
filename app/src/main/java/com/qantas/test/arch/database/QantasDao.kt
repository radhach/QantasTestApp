package com.qantas.test.arch.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qantas.test.helper.const.DatabaseConst
import com.qantas.test.model.QantasData
import kotlinx.coroutines.flow.Flow

/**
 * for all data base operations we will use this class
 */
@Dao
interface QantasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(qantas: List<QantasData>)

    @Query("DELETE FROM ${DatabaseConst.QANTAS_TABLE}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${DatabaseConst.QANTAS_TABLE}")
    fun getQantas(): Flow<List<QantasData>>
}