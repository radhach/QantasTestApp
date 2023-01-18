package com.qantas.test.helper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qantas.test.R
import com.qantas.test.callback.QantasAirportDetailsCallback
import com.qantas.test.model.QantasData

/**
 *  adapter for the qantas airports
 *  @param itemClickListener click listener for list item
 *  @param airportsData data to display in list
 */
class QantasAirportsAdapter(
    private val itemClickListener: QantasAirportDetailsCallback,
    private var airportsData: List<QantasData>
) :
    RecyclerView.Adapter<QantasAirportsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.qantas_airport_list_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvAirportName.text = airportsData[position].airportName
        holder.tvCountryName.text = airportsData[position].country?.countryName

        holder.viewMoreBtn.setOnClickListener {
            itemClickListener.onItemClicked(airportsData[position])
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return airportsData.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val tvAirportName: TextView = itemView.findViewById(R.id.tvAirportName)
        val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)
        val viewMoreBtn: ImageButton = itemView.findViewById(R.id.viewMoreBtn)
    }
}