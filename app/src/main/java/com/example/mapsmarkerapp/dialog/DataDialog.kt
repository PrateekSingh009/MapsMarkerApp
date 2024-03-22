package com.example.mapsmarkerapp.dialog

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.mapsmarkerapp.databinding.DataDialogBinding
import com.example.mapsmarkerapp.extensions.setWidthPercent
import com.example.mapsmarkerapp.model.MarkerEntity
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

class DataDialog(
    private val latlng : LatLng,
    private val saveData : (markerEntity: MarkerEntity) -> Unit
) : DialogFragment() {
    private lateinit var _binding : DataDialogBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setWidthPercent(85)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            latEditText.setText(latlng.latitude.toString())
            lanEditText.setText(latlng.longitude.toString())

            Save.setOnClickListener {
                val newMarker = MarkerEntity(
                    id = 0,
                    name = nameEditText.text.toString(), // add null check
                    age = ageEditText.text.toString().toInt(),
                    relation = rlnEditText.text.toString(),
                    address = getAddress(latlng),
                    lat = latEditText.text.toString().toDouble(),
                    long = lanEditText.text.toString().toDouble()
                )
                saveData.invoke(newMarker)
                dialog?.dismiss()
            }
        }

    }
    private fun getAddress(latLng: LatLng): String {
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val address: Address?
        var addressText = ""

        val addresses: List<Address>? =
            geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

        if (addresses?.isNotEmpty() == true) {
            address = addresses[0]
            addressText = address.getAddressLine(0)
        } else{
            addressText = "its not appear"
        }
        return addressText
    }
}