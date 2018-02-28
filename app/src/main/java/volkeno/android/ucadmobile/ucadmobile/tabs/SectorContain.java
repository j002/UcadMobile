package volkeno.android.ucadmobile.ucadmobile.tabs;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Sector;

/**
 * Created by HP on 08/10/2015.
 */
public class SectorContain extends Fragment {
    Insert Insert =new Insert();
    RealmResults<Sector> sector;
    TextView text;
    int size=0;
    String name;

    List <String> namelist=new ArrayList<>();
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sector, container, false);


        Realm realm = Realm.getInstance(this.getActivity());
    final     RealmResults<Sector> Sector1=null;
        realm=Realm.getInstance(this.getActivity());
        Insert.InsertDiplomatype(this.getActivity());
        Insert.InsertDepartment(this.getActivity());
        Insert.InsertTrainningschool(this.getActivity());
        //  Insert.InsertFac(this.getActivity());
        Bundle extras = getActivity().getIntent().getExtras();
        if (savedInstanceState == null) {

            if(extras == null) {
                name=extras.getString("Departement");

            } else {
                name=extras.getString("Departement");
            }
        } else {

            name=extras.getString("Departement");
        }
        sector = Insert.SelectSector(realm, this.getActivity(), Sector1);
        if(sector.isEmpty()){
            Insert.InsertSector(this.getActivity());
            sector = Insert.SelectSector(realm, this.getActivity(), Sector1);
        }

    //   text=(TextView)rootView.findViewById(R.id.facDescription);
      //  text.setText(department.get(0).getFaculty().getDescription());
        // f=(Fragment)findViewById(R.)
        ListView listview = (ListView)  rootView.findViewById(R.id.listsector);
        List<ItemObject> allItems = getAllItemObject();

        Toast.makeText(getActivity(), "Visible" + sector.size(),
                Toast.LENGTH_SHORT).show();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        listview.setAdapter(customAdapter);
        //listview.etId();

        ActionBar actionBar = getActivity().getActionBar();
       actionBar.setTitle(sector.get(0).getDepartment().getName());
      // actionBar.setTitle("INFORMATIQUE");
        actionBar.setDisplayHomeAsUpEnabled(true);

        for(int i=0;i<allItems.size();i++)
            namelist.add(allItems.get(i).getTitte());
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), SubjectContainActivity.class);
                intent.putExtra("Sector", namelist.get(position).toString());
                startActivity(intent);
            }


        });



        return rootView;

    }
    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
       // for(int i=0;i<sector.size();i++){
            items.add(new ItemObject(sector.get(0).getName()));
       // }
        return items;
    }







}
