package papitas.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import papitas.fragments.AccountingFragment;
import papitas.fragments.MyInvoiceFragment;

/**
 * Created by juanm on 22/06/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new MyInvoiceFragment();
        }
        else if (position == 1)
        {
            fragment = new AccountingFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "MY INVOICES";
        }
        else if (position == 1)
        {
            title = "ACCOUNTING";
        }
        return title;
    }
}
