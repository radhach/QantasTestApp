package com.qantas.test.arch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.qantas.test.arch.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * basic View model for qantas data
 *@param repository
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    repository: MainRepository
) : ViewModel() {

    val qantasData = repository.getQantasData().asLiveData()
}