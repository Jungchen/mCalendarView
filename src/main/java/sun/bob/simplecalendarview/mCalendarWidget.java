package sun.bob.simplecalendarview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sun.bob.mcalendarview.R;


/**
 * Created by sunkuan on 15/3/23.
 */
public class mCalendarWidget extends ViewPager {

    public mCalendarWidget(Context context) {
        super(context);
        this.setId(R.id.calendarViewPager);
        this.setAdapter(new ScreenSlidePagerAdapter(((ActionBarActivity) context).getSupportFragmentManager()));
        this.setCurrentItem(500);
    }
    public mCalendarWidget(Context context,AttributeSet attr){
        super(context);
        this.setId(R.id.calendarViewPager);
        this.setAdapter(new ScreenSlidePagerAdapter(((ActionBarActivity) context).getSupportFragmentManager()));
        this.setCurrentItem(500);
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            int year = mMonthData.getCurrentYear();
            int month = mMonthData.getCurrentMonth();
            if(position > 500){
                year += (position - 500)/12;
                month += (position - 500)%12;
            }else{
                year -= (500 - position)/12;
                month -= (500 - position)%12;
            }
            mCalendarViewFragment fragment = new mCalendarViewFragment();
            mMonthData monthData = new mMonthData(getContext());
            monthData.changeMonth(year, month);
            fragment.setMonthData(monthData);
            return fragment;
        }
        @Override
        public int getCount() {
            return 1000;
        }
    }
}
