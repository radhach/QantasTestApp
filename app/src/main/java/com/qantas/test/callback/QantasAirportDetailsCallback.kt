package com.qantas.test.callback

import com.qantas.test.model.QantasData


interface QantasAirportDetailsCallback {

    /**
     * Callback to be invoked when a  item has been clicked.
     *
     * @param customersData The associated list item
     */
    fun onItemClicked(customersData: QantasData)

}