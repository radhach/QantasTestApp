package com.qantas.test.arch

import com.qantas.test.BaseServiceTest
import com.qantas.test.arch.api.QantasDataApi
import com.qantas.test.model.QantasData
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class QantasApiTest : BaseServiceTest() {

    @MockK(relaxed = true)
    private lateinit var mainApiService: QantasDataApi


    @Before
    fun setup() {
        createServer()
        MockKAnnotations.init(this, relaxed = true)
        mainApiService = retrofit.create(QantasDataApi::class.java)
    }


    @Test
    fun getQantasSuccess() = runBlocking {
        enqueueResponse("qantasDetails.json")
        val details: List<QantasData> = mainApiService.retrieveQantasData()
        Assert.assertEquals(details[0].airportName, "Anaa")
    }

    @Test
    fun getQantasError() = runBlocking {
        enqueueResponse("qantasDetails.json")
        val details: List<QantasData> = mainApiService.retrieveQantasData()
        Assert.assertNotEquals(details[0].airportName, "q")
    }
}
