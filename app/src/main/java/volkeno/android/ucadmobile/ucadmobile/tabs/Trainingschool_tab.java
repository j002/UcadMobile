package volkeno.android.ucadmobile.ucadmobile.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmMigration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContainActivity;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool;

/**
 * Created by number on 21/09/15.
 */
public class Trainingschool_tab extends Fragment {

    List <String> name=new ArrayList<>();
    Insert Insert =new Insert();
    RealmResults<Trainingschool> trainingSchool;
    int size;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.trainningschool_tab, container, false);
        // try {

        //  } catch (RealmMigrationNeededException ex) {

        // }

        Realm realm = Realm.getInstance(this.getActivity());
        // realm.clear(Trainingschool.class);

        size=Insert.InsertTrainningschool(this.getActivity());
        RealmResults<Trainingschool> trainingSchool1=null;
        trainingSchool = Insert.SelectTrainingSchool(realm, this.getActivity(),trainingSchool1,"");
        ListView Listview = (ListView)  rootView.findViewById(R.id.trainingSchoolList);
        List<ItemObject> allItems = getAllItemObject();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        for(int i=0;i<allItems.size();i++)
            name.add(allItems.get(i).getTitte());
        Listview.setAdapter(customAdapter);
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), DepartmentContainActivity.class);
                intent.putExtra("department", name.get(position).toString());
                startActivity(intent);
            }


        });
        return rootView;
    }
    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        for(int i=0;i<size;i++)
            items.add(new ItemObject(trainingSchool.get(i).getName()));
        return items;
    }
}
