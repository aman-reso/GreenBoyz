package com.example.tripgo.locationManager

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.IntentSender.SendIntentException
import android.location.Location
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import java.lang.ref.WeakReference


abstract class LocationManager(var context: WeakReference<Context>) : LocationListener, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener {

    private var mGoogleApiClient: GoogleApiClient? = null
    private var mLocationRequest: LocationRequest? = null
    private var currentLatitude = 0.0
    private var currentLongitude = 0.0

    open fun createGoogleApiClient() {
        if (mLocationRequest == null) {
            mGoogleApiClient = GoogleApiClient.Builder(context.get()!!).addConnectionCallbacks(this).addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build()
        }
        if (mLocationRequest != null) {
            mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)
                .setFastestInterval(1 * 1000);
        }
    }

    open fun startLocationService() {
        if (mGoogleApiClient?.isConnected == false) {
            mGoogleApiClient?.connect();
        }
    }

    open fun removeCallbacks() {
        if (mGoogleApiClient?.isConnected == true) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient!!, this);
            mGoogleApiClient?.disconnect();
        }
    }

    @SuppressLint("MissingPermission")
    override fun onLocationChanged(p0: Location) {
        currentLatitude = p0.latitude;
        currentLongitude = p0.longitude;

        println("http-->$currentLatitude")
        println("https-->$currentLongitude")

    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {
        val location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient!!)

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient!!, mLocationRequest!!, this)
        } else {
            //If everything went fine lets get latitude and longitude
            currentLatitude = location.latitude
            currentLongitude = location.longitude
            println("http-->$currentLatitude")
            println("https-->$currentLongitude")
        }
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                (context?.get()!! as Activity?)?.let { connectionResult.startResolutionForResult(it, CONNECTION_FAILURE_RESOLUTION_REQUEST) }
            } catch (e: SendIntentException) {
                e.printStackTrace()
            }
        } else {
            Log.e("Error", "Location services connection failed with code " + connectionResult.errorCode)
        }
    }

    companion object {
        private const val CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000
    }

}