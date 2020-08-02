package com.dhruvdt.rsmonline.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.dhruvdt.rsmonline.R;
import com.dhruvdt.rsmonline.fragment.SwitchFragment;
import com.dhruvdt.rsmonline.fragment.LedFragment;
import com.dhruvdt.rsmonline.fragment.SandGFragment;
import com.dhruvdt.rsmonline.fragment.WireFragment;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_wire, R.string.tab_switch,R.string.tab_sandg,R.string.tab_led};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a SwitchFragment (defined as a static inner class below).
      //  return SwitchFragment.newInstance(position + 1);
        switch (position){
            case 0:
                WireFragment wireFragment = new WireFragment();
                return wireFragment;

            case 1:
                SwitchFragment switchFragment = new SwitchFragment();
                return switchFragment;
            case 2:
                SandGFragment sandGFragment = new SandGFragment();
                return sandGFragment;
            case 3:
                LedFragment ledFragment = new LedFragment();
                return ledFragment;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}