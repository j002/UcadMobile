package volkeno.android.ucadmobile.ucadmobile;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import volkeno.android.ucadmobile.ucadmobile.Db.Insert;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapter;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class view_with_tabs extends FragmentActivity implements
        ActionBar.TabListener {
    private ViewPager viewPager;
    private PagerAdapter mAdapter;
    private ActionBar actionBar;
    Insert Insertinto;
    private String[] tabs = { "UcadInfo", "Faculte", "Instituts universitaire","Instituts et Ecole de Formation" };
    public static FragmentManager fragmentManager;



    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_with_tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
       /* Insertinto=new Insert();
        Insertinto.SelectFaculty()*/
        mAdapter = new PagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(mAdapter);

        actionBar.setHomeButtonEnabled(false);
        // actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener((android.app.ActionBar.TabListener) this));
        }
        fragmentManager = getSupportFragmentManager();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

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
        actionBar.setTitle(Html.fromHtml("<font color='#0000ff'>" + "Ucadmobile" + "</font>"));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.BLUE));
        actionBar.setSplitBackgroundDrawable(new ColorDrawable(Color.BLACK));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_with_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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






}
