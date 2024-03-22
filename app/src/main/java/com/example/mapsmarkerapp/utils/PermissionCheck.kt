package com.example.mapsmarkerapp.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

open class PermissionCheck {

     fun checkLocationPermission(activity : Activity) {
        if(ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
        }
        return
    }
}