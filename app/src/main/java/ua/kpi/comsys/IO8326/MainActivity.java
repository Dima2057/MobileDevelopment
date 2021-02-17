package ua.kpi.comsys.IO8326;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final int[] tabIcons = {
            R.drawable.ic_baseline_architecture_24,
            R.drawable.ic_baseline_branding_watermark_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        MyAdapter pageAdapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pageAdapter);


        tabLayout.addTab(tabLayout.newTab().setText("PageOne"));
        tabLayout.addTab(tabLayout.newTab().setText("PageTwo"));
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


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