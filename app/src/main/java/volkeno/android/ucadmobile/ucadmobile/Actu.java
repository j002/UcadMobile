package volkeno.android.ucadmobile.ucadmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;

/**
 * Created by HP on 09/10/2015.
 */
public class Actu extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_actusport, container, false);
        Intent intent = this.getActivity().getIntent();
        String nameinfo;
        Bundle extras = getActivity().getIntent().getExtras();
        if (savedInstanceState == null) {

            if(extras == null) {
                nameinfo=extras.getString("Information");

            } else {
                nameinfo=extras.getString("Information");
            }
        } else {

            nameinfo=extras.getString("Information");
        }
        Operation op = new Operation();
        News n=new News();
        n=op.voir(nameinfo,getContext());
        TextView title = (TextView) rootView.findViewById(R.id.textViewtitle);
        title.setText(n.getTittle());
        TextView content = (TextView)rootView.findViewById(R.id.textViewcontent);
        content.setText(n.getContent());



        //setBackground(getDrawable(R.drawable.lufy))


        //((ImageView) findViewById(R.id.imageView)).setImageDrawable(getDrawable(R.drawable.lufy));
        //((ImageView) findViewById(R.id.imageView)).setBackground(getResources().getDrawable(getResources().getIdentifier("luffy", "drawable", getPackageName())));
        ImageView img = (ImageView) rootView.findViewById(R.id.imageView);
        //int i=Integer.parseInt(n.getImage());
        //int imgname=Integer.getInteger(n.getImage());//Integer.parseInt();


        img.setImageResource(R.drawable.ic_launcher);//Integer.parseint

        return rootView;
    }
}
