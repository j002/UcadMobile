package volkeno.android.ucadmobile.ucadmobile.Tabcontain;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import volkeno.android.ucadmobile.ucadmobile.R;

/**
 * Created by number on 06/10/15.
 */
public class MapActivity extends FragmentActivity {
    private GoogleMap mMap=null;
    double lati,longi;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map);
    ActionBar actionBar = this.getActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    Bundle extras = getIntent().getExtras();
    if (savedInstanceState == null) {

        if(extras == null) {
            lati=0;
            longi=0;
        } else {
            lati= extras.getDouble("lati");
            longi=extras.getDouble("longi");
        }
    } else {
       /* lati= (double) savedInstanceState.getSerializable("lati");
        longi= (double) savedInstanceState.getSerializable("longi");*/
        lati= extras.getDouble("lati");
        longi=extras.getDouble("longi");
    }
    onViewCreated(findViewById(R.id.mapFullScreen),extras);
    setUpMapIfNeeded();
    }
    /***** Sets up the mMap if it is possible to do so *****/
    public void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.mapFullScreen)).getMap();;
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    private void setUpMap() {
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        mMap.addMarker(new MarkerOptions().position(new LatLng(lati, longi)).title("Home"));
        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lati
                , longi), 16.0f));

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the mMap from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapFullScreen)).getMap(); // getMap is deprecated
            // Check if we were successful in obtaining the mMap.
            if (mMap != null)
                setUpMap();
        }
    }

    }

