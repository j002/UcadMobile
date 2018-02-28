package volkeno.android.ucadmobile.ucadmobile.tabs;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapterForOne;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Subject;

/**
 * Created by HP on 06/10/2015.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SubjectContainActivity extends FragmentActivity implements
        ActionBar.TabListener {
    private ViewPager viewPager;
    private PagerAdapter mAdapter;
    private ActionBar actionBar;
    private String[] tabs = { "Admission", "Programme", "Objectif","Debouches" };
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        viewPager = (ViewPager) findViewById(R.id.pagersubject);
        actionBar = getActionBar();

         mAdapter = new PagerAdapter(getSupportFragmentManager(),this);
         viewPager.setAdapter(mAdapter);
         actionBar.setHomeButtonEnabled(false);
         actionBar.setTitle("informatique");
     //   actionBar.setTitle(sub.get(0).getDepartment().getName());

         actionBar.setDisplayHomeAsUpEnabled(true);
         actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener((android.app.ActionBar.TabListener) this));
        } viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_with_tabs, menu);
        return true;
    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

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
