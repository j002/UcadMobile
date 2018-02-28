package volkeno.android.ucadmobile.ucadmobile.tabs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Actu_activity;
import volkeno.android.ucadmobile.ucadmobile.Db.ImageAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.ItemObject;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;

/**
 * Created by number on 21/09/15.
 */
public class UcadInfo_tab extends Fragment {


    Insert Insert =new Insert();
    RealmResults<News> news;
    int size;
    List <String> name=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ucadinfo_tab, container, false);
        Realm realm = null;
        // try {

        //  } catch (RealmMigrationNeededException ex) {

        //  }
        //   Insert.InsertNewsType(this.getActivity());
//         realm = Realm.getDefaultInstance();
        realm = Realm.getInstance(this.getActivity());
        Insert.InsertNewsType(this.getActivity());
        size=Insert.InsertNews(this.getActivity());
        RealmResults<News> news1=null;
        news = Insert.SelectInfos(realm, this.getActivity(), news1,"");
        ListView Listview = (ListView)  rootView.findViewById(R.id.ucadList);
        List<ItemObject> allItems = getAllItemObject();
        ImageAdapter customAdapter = new ImageAdapter(getActivity(), allItems,this);
        Listview.setAdapter(customAdapter);
        String title;
        for(int i=0;i<allItems.size();i++) {

            name.add(allItems.get(i).getTitte());
//            title=news1.get(i).getTittle();
        }
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), Actu_activity.class);
                Toast.makeText(getActivity(),"beussna", Toast.LENGTH_LONG).show();
                intent.putExtra("Information", name.get(position).toString());
                startActivity(intent);
            }


        });

        return rootView;
    }
    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        for(int i=0;i<size;i++ )
            items.add(new ItemObject(R.drawable.ic_launcher,news.get(i).getTittle(), news.get(i).getContent()));
        return items;
    }
}
