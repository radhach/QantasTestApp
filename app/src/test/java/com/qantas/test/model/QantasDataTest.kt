package com.qantas.test.model

import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class QantasDataTest {

    private lateinit var trackingData: List<QantasData>

    @Before
    fun setUp() {
        trackingData = listOf(
            QantasData(
                id = 1, airportName = "AAAA",
                city = City("ass", "pasipic"),
                country = Country("123", countryName = "qwww")
            )
        )

    }

    @Test
    fun tracking() {
        assertNotEquals(
            listOf(
                QantasData(
                    id = 1, airportName = "BBBB",
                    city = City("ass", "pasipic"),
                    country = Country("123", countryName = "qwww")
                )
            ), trackingData
        )
        assertEquals(
            listOf(
                QantasData(
                    id = 1, airportName = "AAAA",
                    city = City("ass", "pasipic"),
                    country = Country("123", countryName = "qwww")
                )
            ), trackingData
        )
    }

}