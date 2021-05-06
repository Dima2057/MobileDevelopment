package ua.kpi.comsys.IO8326;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import ua.kpi.comsys.IO8326.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {
    private final int[] tabIcons = {
            R.drawable.ic_baseline_architecture_24,
            R.drawable.ic_baseline_branding_watermark_24,
            R.drawable.ic_baseline_desktop_mac_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Graphics"));
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(tabIcons[2]);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        MyAdapter pageAdapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pageAdapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}