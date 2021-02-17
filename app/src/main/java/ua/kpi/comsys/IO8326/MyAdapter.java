package ua.kpi.comsys.IO8326;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Objects;

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
        }
        return Objects.requireNonNull(fragment);
    }

    @Override
    public int getCount() {
        return 2;
    }
}