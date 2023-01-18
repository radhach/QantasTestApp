package com.qantas.test.arch.repository

import com.qantas.test.arch.api.QantasDataApi
import com.qantas.test.helper.util.Resource
import com.qantas.test.model.QantasData
import kotlinx.coroutines.flow.Flow


/**
 * [MainRepository] interface contains api calls related to Qantas module.
 */
interface MainRepository {

    fun getQantasData(): Flow<Resource<List<QantasData>>>


}