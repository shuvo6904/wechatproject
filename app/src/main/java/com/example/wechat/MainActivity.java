package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.wechat.databinding.ActivityMainBinding;
import com.example.wechat.menu.ChatsFragment;
import com.example.wechat.menu.ContactsFragment;
import com.example.wechat.menu.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setUpViewPager(binding.viewPagerID);
        binding.tabLayoutID.setupWithViewPager(binding.viewPagerID);

        setSupportActionBar(binding.tollBarID);

        binding.viewPagerID.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                changeFabIcon(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeFabIcon(final int index) {

        binding.fActionId.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                switch (index)
                {
                    case 0:
                        binding.fActionId.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));
                        break;

                    case 1:
                        binding.fActionId.setImageDrawable(getDrawable(R.drawable.ic_baseline_photo_camera_24));
                        break;

                    case 2:
                        binding.fActionId.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));
                        break;
                }

                binding.fActionId.show();

            }
        }, 400);
    }


    private void setUpViewPager (ViewPager viewPager){

        MainActivity.SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ChatsFragment(), "Chats");


        adapter.addFragment(new StatusFragment(), "Status");

        adapter.addFragment(new ContactsFragment(), "Contacts");

        viewPager.setAdapter(adapter);

    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager){

            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment (Fragment fragment, String title){

            mFragmentList.add(fragment);

            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.menuSearchID:
                Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
                break;

            case R.id.menuOptionsID:
                Toast.makeText(this, "Options", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}