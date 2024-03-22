package com.example.mapsmarkerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.mapsmarkerapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MarkerInfoWindowAdapter(
    mContext: Context
) : GoogleMap.InfoWindowAdapter {
    var mWindow: View = LayoutInflater.from(mContext).inflate(R.layout.marker_info_window, null)
    val resource = mContext.resources

    private fun setInfoWindowText(marker: Marker) {
        val tvName = mWindow.findViewById<TextView>(R.id.name)
        val tvAge = mWindow.findViewById<TextView>(R.id.age)
        val tvLatitude = mWindow.findViewById<TextView>(R.id.latitude)
        val tvLongitude = mWindow.findViewById<TextView>(R.id.longitude)

        tvName.text = String.format(resource.getString(R.string.marker_name), marker.title)
        tvAge.text =
            String.format(resource.getString(R.string.marker_age), marker.snippet.toString())
        tvLatitude.text =
            String.format(resource.getString(R.string.marker_lat), marker.position.latitude)
        tvLongitude.text =
            String.format(resource.getString(R.string.marker_long), marker.position.longitude)

    }

    override fun getInfoContents(p0: Marker): View? {
        setInfoWindowText(p0)
        return mWindow
    }

    override fun getInfoWindow(p0: Marker): View? {
        setInfoWindowText(p0)
        return mWindow
    }
}