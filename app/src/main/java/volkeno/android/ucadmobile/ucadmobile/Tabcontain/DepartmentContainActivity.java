package volkeno.android.ucadmobile.ucadmobile.Tabcontain;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapter;
import volkeno.android.ucadmobile.ucadmobile.Db.PagerAdapterForOne;
import volkeno.android.ucadmobile.ucadmobile.R;
import volkeno.android.ucadmobile.ucadmobile.tabs.Institute_tab;
import volkeno.android.ucadmobile.ucadmobile.view_with_tabs;

/**
 * Created by number on 02/10/15.
 */
public class DepartmentContainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private PagerAdapterForOne mAdapter;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.departmentcontainactivity);
        viewPager = (ViewPager) findViewById(R.id.pagerDep);
        mAdapter = new PagerAdapterForOne(getSupportFragmentManager(),this);
        viewPager.setAdapter(mAdapter);
        ActionBar actionBar = getActionBar();
      // actionBar.setTitle();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
        actionBar.setDisplayHomeAsUpEnabled(true);

       }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                view_with_tabs i=new view_with_tabs();
             //   i.getActionBar().
              //  Intent homeIntent = new Intent(this,view_with_tabs.class );
                //homeIntent.putExtra("tab_index", "2");
                //homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
               // startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
/*
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
    }*/
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}