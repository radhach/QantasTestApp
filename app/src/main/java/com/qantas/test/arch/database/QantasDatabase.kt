package com.qantas.test.arch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.qantas.test.helper.const.DatabaseConst
import com.qantas.test.model.CityConverter
import com.qantas.test.model.CountryConverter
import com.qantas.test.model.QantasData

/**
 *  for initialization of dao class and database version  info we will use this class
 */
@Database(entities = [QantasData::class], version = DatabaseConst.DATABASE_VERSION)
@TypeConverters(CityConverter::class, CountryConverter::class)
abstract class QantasDatabase : RoomDatabase() {

    abstract fun qantasDao(): QantasDao
}