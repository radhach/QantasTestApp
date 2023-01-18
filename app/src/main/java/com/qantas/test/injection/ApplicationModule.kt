package com.qantas.test.injection

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.qantas.test.arch.api.QantasDataApi
import com.qantas.test.arch.database.QantasDatabase
import com.qantas.test.arch.repository.MainRepository
import com.qantas.test.arch.repository.MainRepositoryImpl
import com.qantas.test.helper.const.DatabaseConst
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideRandomDataApi(): QantasDataApi =
        Retrofit.Builder()
            .baseUrl(QantasDataApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(QantasDataApi::class.java)

    @Provides
    fun provideMainRepository(api: QantasDataApi, db: QantasDatabase): MainRepository =
        MainRepositoryImpl(api, db)

    @Singleton
    @Provides
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, QantasDatabase::class.java, DatabaseConst.DATABASE_NAME)
            .addMigrations()
            .build()
}