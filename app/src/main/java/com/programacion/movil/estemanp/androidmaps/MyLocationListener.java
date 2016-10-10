package com.programacion.movil.estemanp.androidmaps;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by estemanp on 10/10/16.
 */

public class MyLocationListener implements LocationListener {

    private MapsActivity mapsActivity;

    public MapsActivity getMapsActivity() {
        return mapsActivity;
    }

    public void setMapsActivity(MapsActivity mapsActivity) {
        this.mapsActivity = mapsActivity;
    }

    @Override
    public void onLocationChanged(Location location) {
        updateLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this.mapsActivity.getBaseContext(), "El Gps está encendido!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        this.mapsActivity.startActivity(intent);
        Toast.makeText(this.mapsActivity.getBaseContext(), "El Gps está apagado!! ",
                Toast.LENGTH_SHORT).show();
    }

    private void updateLocation(Location location) {
        if(location != null){
            this.mapsActivity.updateLocation(location);
        }
    }

}
