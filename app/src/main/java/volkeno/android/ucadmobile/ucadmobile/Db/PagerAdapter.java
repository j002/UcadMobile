package volkeno.android.ucadmobile.ucadmobile.Db;

/**
 * Created by number on 21/09/15.
 */

    import android.support.v4.app.Fragment;
    import android.support.v4.app.FragmentActivity;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentPagerAdapter;

    import volkeno.android.ucadmobile.ucadmobile.tabs.Admission;
    import volkeno.android.ucadmobile.ucadmobile.tabs.Debouche;
    import volkeno.android.ucadmobile.ucadmobile.tabs.Faculty_tab;
    import volkeno.android.ucadmobile.ucadmobile.tabs.Institute_tab;
    import volkeno.android.ucadmobile.ucadmobile.tabs.Objectif;
    import volkeno.android.ucadmobile.ucadmobile.tabs.SubjectContain;
    import volkeno.android.ucadmobile.ucadmobile.tabs.SubjectContainActivity;
    import volkeno.android.ucadmobile.ucadmobile.tabs.Trainingschool_tab;
    import volkeno.android.ucadmobile.ucadmobile.tabs.UcadInfo_tab;
    import volkeno.android.ucadmobile.ucadmobile.view_with_tabs;

public   class PagerAdapter extends FragmentPagerAdapter {
    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    private FragmentActivity fragmentActivity;
    public PagerAdapter(FragmentManager fm,FragmentActivity fragmentActivity1) {
        super(fm);
        fragmentActivity=fragmentActivity1;
    }

    @Override
    public Fragment getItem(int position) {
        if(fragmentActivity.getClass().equals(new view_with_tabs().getClass())){
            switch (position) {
                case 0:
                    // Top Rated fragment activity
                    return new UcadInfo_tab();
                case 1:
                    // Games fragment activity
                    return new Faculty_tab();
                case 2:
                    // Movies fragment activity
                    return new Institute_tab();
                case 3:
                    // Movies fragment activity
                    return new Trainingschool_tab();
            }
        }else if(fragmentActivity.getClass().equals(new SubjectContainActivity().getClass())){

                switch (position) {
                    case 0:
                        // Top Rated fragment activity
                        return new Admission();
                    case 1:
                        // Games fragment activity
                        return new SubjectContain();
                    case 2:
                        // Movies fragment activity
                        return new Objectif();
                    case 3:
                        // Movies fragment activity
                        return new Debouche();

            }

        }
        return null;
        }






    @Override
    public int getCount() {
        return 4;
    }



}
