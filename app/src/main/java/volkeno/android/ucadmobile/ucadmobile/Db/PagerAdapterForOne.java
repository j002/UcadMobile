package volkeno.android.ucadmobile.ucadmobile.Db;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import volkeno.android.ucadmobile.ucadmobile.Actu;
import volkeno.android.ucadmobile.ucadmobile.Actu_activity;
import volkeno.android.ucadmobile.ucadmobile.SectorContainActivity;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContain;
import volkeno.android.ucadmobile.ucadmobile.Tabcontain.DepartmentContainActivity;
import volkeno.android.ucadmobile.ucadmobile.tabs.SectorContain;
import volkeno.android.ucadmobile.ucadmobile.tabs.SubjectContain;
import volkeno.android.ucadmobile.ucadmobile.tabs.SubjectContainActivity;

/**
 * Created by number on 02/10/15.
 */
public class PagerAdapterForOne extends FragmentPagerAdapter {
    private FragmentActivity fragment;
    public PagerAdapterForOne(FragmentManager fm,FragmentActivity f1) {

        super(fm);
        setFragment(f1);
    }

    @Override
    public Fragment getItem(int position) {
        if(getFragment().getClass()==new DepartmentContainActivity().getClass())
        return new DepartmentContain();
        else if(getFragment().getClass()==new SubjectContainActivity().getClass())
            return new SubjectContain();
        else if(getFragment().getClass()==new SectorContainActivity().getClass())
            return new SectorContain();
        else
            return new Actu();
    }

    @Override
    public int getCount() {
        return 1;
    }


    public FragmentActivity getFragment() {
        return fragment;
    }

    public void setFragment(FragmentActivity fragment) {
        this.fragment = fragment;
    }
}
