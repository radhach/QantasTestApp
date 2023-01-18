package com.qantas.test.arch.repository

import androidx.room.withTransaction
import com.qantas.test.arch.api.QantasDataApi
import com.qantas.test.arch.database.QantasDatabase
import com.qantas.test.helper.util.Resource
import com.qantas.test.helper.util.networkBoundResource
import com.qantas.test.model.QantasData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

/**
 * MainRepositoryImpl class - This class interacts with Qantas API Services. This Repository class
 * gets the data from the network. It handles all the Qantas related information from the
 * backend  and the View models can consume the Qantas related information and display in the Activity
 * @param  api for interacting with the qantas APIS.
 * @param db for data base operations
 */
class MainRepositoryImpl(
    private val api: QantasDataApi,
    private val db: QantasDatabase
) : MainRepository {

    private val dao = db.qantasDao()

    override fun getQantasData(): Flow<Resource<List<QantasData>>> = networkBoundResource(
        query = {
            dao.getQantas()
        },
        fetch = {
            delay(2000)
            api.retrieveQantasData()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                dao.deleteAll()
                dao.insertAll(restaurants)
            }
        }
    )

}