package volkeno.android.ucadmobile.ucadmobile.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Subject;


/**
 * Created by HP on 06/10/2015.
 */
public class SubjectContain extends Fragment {
    Insert Insert =new Insert();
    RealmResults<Subject> subjects;
    int size;
    String name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.subject, container, false);
        // try {


        // } catch (RealmMigrationNeededException ex) {

        //}

        Realm realm = Realm.getInstance(this.getActivity());
        Insert.InsertDiplomatype(this.getActivity());
        Insert.InsertDetaileddiploma(this.getActivity());
        Insert.InsertModule(this.getActivity());

        Bundle extras = getActivity().getIntent().getExtras();
        if (savedInstanceState == null) {

            if(extras == null) {
                name=extras.getString("Sector");

            } else {
                name=extras.getString("Sector");
            }
        } else {

            name=extras.getString("Sector");
        }

        size=Insert.InsertSubject(this.getActivity());
        RealmResults<Subject> subjects1=null;
        subjects = Insert.SelectSubject(realm, this.getActivity(), subjects1);
        GridView gridview = (GridView)  rootView.findViewById(R.id.gridView1);

        List<ItemObject> allItems = getAllItemObject();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        gridview.setAdapter(customAdapter);

        return rootView;
    }
    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("MATIERES"));
        items.add(new ItemObject("NOMBRE HEURE DE COURS"));
        items.add(new ItemObject("NOMBRE HEURE DE TD"));
        items.add(new ItemObject("NOMBRE HEURE DE TP"));
       // for(int i=0;i<size;i++ )

        items.add(new ItemObject( subjects.get(0).getName()));
        items.add(new ItemObject( subjects.get(0).getHoursofcourses()));
        items.add(new ItemObject( subjects.get(0).getHoursofpraticalwork()));
        items.add(new ItemObject( subjects.get(0).getHoursoftutorials()));
        items.add(new ItemObject( subjects.get(1).getName()));
        items.add(new ItemObject( subjects.get(1).getHoursofcourses()));
        items.add(new ItemObject( subjects.get(1).getHoursofpraticalwork()));
        items.add(new ItemObject( subjects.get(1).getHoursoftutorials()));
        return items;
    }


}
