package ua.kpi.comsys.IO8326.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Objects;

import ua.kpi.comsys.IO8326.fragments.FourthFragment;
import ua.kpi.comsys.IO8326.fragments.PageFragment;
import ua.kpi.comsys.IO8326.fragments.SecondFragment;
import ua.kpi.comsys.IO8326.fragments.ThirdFragment;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;

    public MyAdapter(Context context, FragmentManager fragmentManager, int behavior) {
        super(fragmentManager, behavior);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int index) {
        Fragment fragment = null;
        switch (index) {
            case 0:
                fragment = new PageFragment();
                break;
            case 1:
                fragment = new SecondFragment();
                break;
            case 2:
                fragment = new ThirdFragment();
                break;
            case 3:
                fragment = new FourthFragment();
                break;
        }
        return Objects.requireNonNull(fragment);
    }

    @Override
    public int getCount() {
        return 4;
    }
}