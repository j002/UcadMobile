package volkeno.android.ucadmobile.ucadmobile.tabs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContainActivity;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty;


/**
 * Created by number on 21/09/15.
 */
public class Faculty_tab extends Fragment {

    Insert Insert = new Insert();
    RealmResults<Faculty> Faculty;
    int size;
    ImageAdapter customAdapter;
    List <String> name=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.faculty_tab, container, false);
        //  try {

        // } catch (RealmMigrationNeededException ex) {

        // }
        Realm realm = Realm.getInstance(this.getActivity());
        size = Insert.InsertFaculty(this.getActivity());
        final RealmResults<Faculty> fac = null;
        Faculty = Insert.SelectFaculty(realm, this.getActivity(), fac,"");

        List<ItemObject> allItems = getAllItemObject();
        customAdapter = new ImageAdapter(getActivity(), allItems, this);
        final ListView listview;
        listview = (ListView) rootView.findViewById(R.id.facultyList);
        listview.setAdapter(customAdapter);
        for(int i=0;i<allItems.size();i++)
            name.add(allItems.get(i).getTitte());

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), DepartmentContainActivity.class);
                intent.putExtra("department", name.get(position).toString());
                startActivity(intent);
            }


        });

        return rootView;
    }

    private List<ItemObject> getAllItemObject() {
        List<ItemObject> items = new ArrayList<>();
        for (int i = 0; i < size; i++)
            items.add(new ItemObject(Faculty.get(i).getName()));
        return items;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub


    }
}




