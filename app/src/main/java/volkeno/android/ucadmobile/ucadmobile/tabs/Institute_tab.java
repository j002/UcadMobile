package volkeno.android.ucadmobile.ucadmobile.tabs;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
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
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContain;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContainActivity;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;

/**
 * Created by number on 21/09/15.
 */
public class Institute_tab extends Fragment {
    Insert Insert =new Insert();
    RealmResults<Institute> institute;
    int size;
    ViewPager pager;
    List <String> name=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.institute_tab, container, false);
       // try {


       // } catch (RealmMigrationNeededException ex) {

        //}
        pager=(ViewPager)rootView.findViewById(R.id.pager);

        Realm realm = Realm.getInstance(this.getActivity());
        size=Insert.InsertInstitute(this.getActivity());
        RealmResults<Institute> Institute1=null;
        institute = Insert.SelectInstitute(realm, this.getActivity(), Institute1,"");
        ListView listview = (ListView)  rootView.findViewById(R.id.instituteList);
        List<ItemObject> allItems = getAllItemObject();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        for(int i=0;i<allItems.size();i++)
            name.add(allItems.get(i).getTitte());
        listview.setAdapter(customAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
               /* Toast.makeText(getActivity(), "visible" + position,
                        Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(getActivity(), DepartmentContainActivity.class);
                intent.putExtra("department", name.get(position).toString());
                startActivity(intent);
               /* Intent intent = new Intent(getActivity(), DepartmentContainActivity.class);
                startActivity(intent);*/

            }
        });

        return rootView;
    }

    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        for(int i=0;i<size;i++ )
        items.add(new ItemObject(institute.get(i).getName()));
        return items;
    }

}
