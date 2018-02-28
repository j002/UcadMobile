package volkeno.android.ucadmobile.ucadmobile;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapterForOne;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;

public class Actu_activity extends FragmentActivity {
String nameinfo;
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departmentcontainactivity);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pagerDep);
        ActionBar actionBar = this.getActionBar();
       /* Insertinto=new Insert();
        Insertinto.SelectFac()*/
        PagerAdapterForOne mAdapter = new PagerAdapterForOne(getSupportFragmentManager(), this);
        viewPager.setAdapter(mAdapter);
        Bundle extras = this.getIntent().getExtras();
        if (savedInstanceState == null) {

            if(extras == null) {
                nameinfo=extras.getString("Information");

            } else {
                nameinfo=extras.getString("Information");
            }
        } else {

            nameinfo=extras.getString("Information");
        }


        actionBar.setTitle(nameinfo);
        // actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actusport, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();

        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
