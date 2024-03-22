package com.example.mapsmarkerapp.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.mapsmarkerapp.R
import com.example.mapsmarkerapp.adapter.MarkerInfoWindowAdapter
import com.example.mapsmarkerapp.data.MapsViewModel
import com.example.mapsmarkerapp.dialog.DataDialog
import com.example.mapsmarkerapp.model.MarkerEntity
import com.example.mapsmarkerapp.utils.PermissionCheck
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val mapsViewModel: MapsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openMapsFragment()
        setupObserver()
    }

    private fun setupObserver() {
        mapsViewModel.markerListLiveData.observe(this) { mMarkers ->
            for(mMarker in mMarkers){
                val latlng = LatLng(mMarker.lat,mMarker.long)
                val marker = MarkerOptions().position(latlng).title(mMarker.name).snippet(mMarker.id.toString())
                marker.icon(bitmapFromVector(applicationContext, R.drawable.baseline_location_on))
                mMap.addMarker(marker)?.showInfoWindow()
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,5.0f))
            }
        }
    }

    private fun openMapsFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val permission = PermissionCheck()
        permission.checkLocationPermission(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))

        mMap.setOnInfoWindowClickListener {
            setDeleteAlertDialog(it.snippet.toString().toInt())
        }

        mapsViewModel.getAllMarkers()

        mMap.setOnMapLongClickListener {
            val marker = MarkerOptions().position(it).title("New Marker")
            marker.icon(bitmapFromVector(applicationContext, R.drawable.baseline_add_location))
            mMap.addMarker(marker)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it,5.0f))
            showDialogFragment(it)
        }
    }

    private fun showDialogFragment(latlng : LatLng) {
        val dialogFragment = DataDialog(latlng , ::saveData)
        dialogFragment.show(
            supportFragmentManager,
            dialogFragment.tag
        )
    }

    private fun saveData(markerEntity: MarkerEntity) {
        mapsViewModel.insertMarkerData(markerEntity)
    }

    private fun deleteMarker(id : Int) {
        mapsViewModel.deleteMarkerData(id)
    }

    private fun bitmapFromVector(context: Context, vectorResId:Int): BitmapDescriptor? {
        var vectorDrawable: Drawable = ContextCompat.getDrawable(context,vectorResId)!!
        vectorDrawable.setBounds(0,0,vectorDrawable.intrinsicWidth,vectorDrawable.intrinsicHeight)
        var bitmap: Bitmap =
            Bitmap.createBitmap(vectorDrawable.intrinsicWidth,vectorDrawable.intrinsicHeight,Bitmap.Config.ARGB_8888)
        var canvas: Canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    private fun setDeleteAlertDialog(id : Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.delete)
        builder.setIcon(android.R.drawable.ic_delete)
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            deleteMarker(id)
        }
        builder.setNeutralButton("Cancel"){dialogInterface , which ->
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}