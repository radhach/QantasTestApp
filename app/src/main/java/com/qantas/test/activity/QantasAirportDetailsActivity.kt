package com.qantas.test.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qantas.test.R
import com.qantas.test.databinding.QantasAirportDetailsBinding
import com.qantas.test.helper.const.GlobalConst

/**
 * QantasAirportDetailsActivity - Use for Qantas Airports Details Display Screen
 */
class QantasAirportDetailsActivity : AppCompatActivity() {

    private lateinit var binding: QantasAirportDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QantasAirportDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCountryCode.text =
            getString(R.string.countryCode).plus(intent.getStringExtra(GlobalConst.COUNTRY_CODE))
        binding.tvTimeZone.text =
            getString(R.string.timeZone).plus(intent.getStringExtra(GlobalConst.TIME_ZONE))
        binding.tvCityName.text =
            getString(R.string.cityName).plus(intent.getStringExtra(GlobalConst.CITY_NAME))

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
