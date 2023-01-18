package com.qantas.test.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qantas.test.arch.viewmodel.MainViewModel
import com.qantas.test.callback.QantasAirportDetailsCallback
import com.qantas.test.databinding.ActivityMainBinding
import com.qantas.test.helper.adapter.QantasAirportsAdapter
import com.qantas.test.helper.const.GlobalConst
import com.qantas.test.helper.util.Resource
import com.qantas.test.model.QantasData
import dagger.hilt.android.AndroidEntryPoint


/**
 * AirportsListActivity - Use for Qantas Airports list Display Screen
 */
@AndroidEntryPoint
class AirportsListActivity : AppCompatActivity(), QantasAirportDetailsCallback {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            viewModel.qantasData.observe(this@AirportsListActivity) { result ->
                qantasAirportsList.adapter =
                    result.data?.let { QantasAirportsAdapter(this@AirportsListActivity, it) }
                qantasAirportsList.layoutManager =
                    LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                qantasAirportsList.addItemDecoration(
                    DividerItemDecoration(
                        baseContext,
                        LinearLayoutManager(
                            applicationContext,
                            RecyclerView.VERTICAL,
                            false
                        ).orientation
                    )
                )
                when (result) {
                    is Resource.Error -> {
                        progressBarVisibility(false)
                    }

                    is Resource.Loading -> {
                        progressBarVisibility(true)
                    }

                    is Resource.Success -> {
                        progressBarVisibility(false)
                    }
                }
            }
        }
    }

    private fun progressBarVisibility(visibility: Boolean) {
        if (visibility) {
            binding.progressLayout.progressView.bringToFront()
            binding.progressLayout.progressView.visibility = View.VISIBLE
        } else {
            binding.progressLayout.progressView.visibility = View.GONE
        }
    }

    override fun onItemClicked(customersData: QantasData) {
        val intent = Intent(this, QantasAirportDetailsActivity::class.java)
        intent.putExtra(GlobalConst.COUNTRY_CODE, customersData.country?.countryCode)
        intent.putExtra(GlobalConst.CITY_NAME, customersData.city?.cityName)
        intent.putExtra(GlobalConst.TIME_ZONE, customersData.city?.timeZoneName)
        startActivity(intent)
    }
}