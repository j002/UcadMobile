package volkeno.android.ucadmobile.ucadmobile.Tabcontain;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.SectorContainActivity;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;

/**
 * Created by number on 01/10/15.
 */
public class DepartmentContain  extends Fragment implements GoogleMap.OnMapClickListener{

    Double Longitude,Latitude;

    private GoogleMap mMap;
    CircleOptions circleOptions;
    ProgressDialog progressDialog;
    Insert Insert =new Insert();
    RealmResults<Department> department;
    TextView text;
    int size=0;
    String name;
    List <String> namelist=new ArrayList<>();

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.departement, container, false);


        Realm realm = Realm.getInstance(this.getActivity());
        RealmResults<Department> Department1=null;
        realm=Realm.getInstance(this.getActivity());

        //  Insert.InsertFac(this.getActivity());
        Bundle extras = getActivity().getIntent().getExtras();
        if (savedInstanceState == null) {

            if(extras == null) {
                name=extras.getString("department");

            } else {
                name=extras.getString("department");
            }
        } else {
            name=extras.getString("department");
        }
        department = Insert.SelectDepartment(realm, this.getActivity(), Department1,name);
        if(department.isEmpty()){
            Insert.InsertDepartment(this.getActivity());
            department = Insert.SelectDepartment(realm, this.getActivity(), Department1,name);
        }

        ActionBar actionBar = getActivity().getActionBar();
       // actionBar.setTitle(department.get(0).getFaculty().getName());
        actionBar.setDisplayHomeAsUpEnabled(true);
        text=(TextView)rootView.findViewById(R.id.facDescription);
        if(department.get(0).getFaculty()!=null)
        {
            text.setText(department.get(0).getFaculty().getDescription());
            Latitude = department.get(0).getFaculty().getLatgeo();
            Longitude = department.get(0).getFaculty().getLonggeo();
            actionBar.setTitle(Html.fromHtml("<font color='#000'>" + department.get(0).getFaculty().getName() + "</font>"));
        }
        if(department.get(0).getSchool()!=null)
        {
            text.setText(department.get(0).getSchool().getDescription());
            Latitude = department.get(0).getSchool().getLatgeo();
            Longitude = department.get(0).getSchool().getLonggeo();
            actionBar.setTitle(department.get(0).getSchool().getName());
            actionBar.setTitle(Html.fromHtml("<font color='#000'>" + department.get(0).getSchool().getName() + "</font>"));
        }
        if(department.get(0).getInstitute()!=null)
        {
            text.setText(department.get(0).getInstitute().getDescription());
            Latitude = department.get(0).getInstitute().getLatgeo();
            Longitude = department.get(0).getInstitute().getLonggeo();
            actionBar.setTitle(Html.fromHtml("<font color='#000'>" + department.get(0).getInstitute().getName() + "</font>"));
        }
        // f=(Fragment)findViewById(R.)
        ListView listview = (ListView)  rootView.findViewById(R.id.depList);
        List<ItemObject> allItems = getAllItemObject();

        Toast.makeText(getActivity(), "Visible"+department.size(),
                Toast.LENGTH_SHORT).show();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        listview.setAdapter(customAdapter);
        //listview.etId();

        setUpMapIfNeeded();
        mMap.setOnMapClickListener(this);

        for(int i=0;i<allItems.size();i++)
            namelist.add(allItems.get(i).getTitte());
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), SectorContainActivity.class);

                intent.putExtra("Departement", namelist.get(position).toString());
                startActivity(intent);
            }


        });



        return rootView;

    }
    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        for(int i=0;i<department.size();i++){
            items.add(new ItemObject(department.get(i).getName()));
        }
        return items;
    }




    /***** Sets up the mMap if it is possible to do so *****/
    public void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    private void setUpMap() {
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        mMap.addMarker(new MarkerOptions().position(new LatLng(Latitude, Longitude)).title(""));
        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Latitude,
                Longitude), 16.0f));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the mMap from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map)).getMap(); // getMap is deprecated
            // Check if we were successful in obtaining the mMap.
            if (mMap != null)
                setUpMap();
        }
    }

    /**** The mapfragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****/
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    @Override
    public void onMapClick(LatLng latLng) {
        Intent intent = new Intent(getActivity(), MapActivity.class);

        intent.putExtra("longi", Longitude);
        intent.putExtra("lati", Latitude);
        // intent.putExtra("map", String.valueOf(mMap));
        startActivity(intent);
    }
}
