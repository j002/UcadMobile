package volkeno.android.ucadmobile.ucadmobile.Db;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import java.util.List;

import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContain;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.tabs.Faculty_tab;
import volkeno.android.ucadmobile.ucadmobile.tabs.Institute_tab;
import volkeno.android.ucadmobile.ucadmobile.tabs.Trainingschool_tab;
import volkeno.android.ucadmobile.ucadmobile.tabs.UcadInfo_tab;

/**
 * Created by number on 28/09/15.
 */
public class ImageAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Fragment fragment;

    public ImageAdapter(Context context, List<ItemObject> customizedListView,Fragment fragment1) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
        fragment=fragment1;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        return (position == 0 )? 1 : 0;
        //&& fragment.getClass()==
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
       // ViewHolder1 listViewHolder1=null;
        String who=null;
        int theType = getItemViewType(position);

        if(convertView == null && fragment.getClass().getName().equals(new UcadInfo_tab().getClass().getName()))
        {
            who="true";
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.layoutinflaternews, parent, false);
            listViewHolder.screenShot = (ImageView)convertView.findViewById(R.id.screen_shot);
            listViewHolder.tittle = (TextView)convertView.findViewById(R.id.tittle);
            listViewHolder.textcontent = (TextView)convertView.findViewById(R.id.text);
            convertView.setTag(listViewHolder);
        }
        else if(convertView == null)
        {
           // who="false";
            listViewHolder = new ViewHolder();
         /*   if(theType==0 && fragment.getClass().equals(new DepartmentContain().getClass()))
            {
                convertView = layoutinflater.inflate(R.layout.layoutinflaterdepartment, parent, false);
            }*/
          //  else{
            convertView = layoutinflater.inflate(R.layout.layoutinflater, parent, false);
            listViewHolder.tittle = (TextView)convertView.findViewById(R.id.Title1);
           convertView.setTag(listViewHolder);
            //}
        }
       /* else if(theType==0)
        {

        }*/
        else
        {
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        if(who=="true"){
        listViewHolder.screenShot.setImageResource(listStorage.get(position).getScreenShot());
       // listViewHolder.tittle.setText(listStorage.get(position).getTitte());
        listViewHolder.textcontent.setText(listStorage.get(position).getTextcontent());
        }

            listViewHolder.tittle.setText(listStorage.get(position).getTitte());
        return convertView;
    }
    static class ViewHolder{
        ImageView screenShot;
        TextView tittle;
        TextView textcontent;
    }


}
