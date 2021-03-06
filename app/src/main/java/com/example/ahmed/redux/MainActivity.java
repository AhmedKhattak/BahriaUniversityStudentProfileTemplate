package com.example.ahmed.redux;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmed.redux.Activities.FeedBackActivity;
import com.example.ahmed.redux.Activities.ProfileActivity;
import com.example.ahmed.redux.Activities.SettingsActivity;
import com.example.ahmed.redux.Adapters.NavDrawerAdapter;
import com.example.ahmed.redux.Fragments.Fragment1;
import com.example.ahmed.redux.Fragments.Fragment2;
import com.example.ahmed.redux.Fragments.Fragment3;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavDrawerAdapter.ClickListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String NAME = "Ahmed Khattak";
    String ENROLL = "01-134132-016";
    int PROFILE = R.drawable.test_account_pic;
    private ImageView logoutImageView;

    //String appPackageName = getPackageName();

    /* RecyclerView mRecyclerView;                           // Declaring RecyclerView
     NavDrawerAdapter mAdapter;                        // Declaring Adapter For Recycler View
     RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
     DrawerLayout Drawer;                                  // Declaring DrawerLayout*/
   /* ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle*/
    /*@Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MyMaterialThemezzz);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setupTabIcons();




       /* mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NavDrawerAdapter(this, NavDrawerItemProvider.getExamSeatingPlanData(),getResources().getColor(R.color.secondary_text));
        mAdapter.SetClickListener(this);
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager




        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        };


        Drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State*/

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withSelectionListEnabledForSingleProfile(false)
                .withActivity(this)
                .withHeaderBackground(R.drawable.nav_drawer_header_image)
                .addProfiles(
                        new ProfileDrawerItem().withName("Ahmed Khattak").withEmail("01-134132-016").withIcon(getResources().getDrawable(R.drawable.test_account_pic))

                ).withAlternativeProfileHeaderSwitching(false)
                .build();


        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Profile").withIcon(R.drawable.ic_account_grey600_24dp);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName("Notifications").withBadge("19").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.accent)).withIcon(R.drawable.ic_bell_ring_grey600_24dp);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(1).withName("Evaluation").withIcon(R.drawable.ic_format_list_bulleted_grey600_24dp);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(1).withName("Registration").withIcon(R.drawable.ic_pen_grey600_24dp);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(1).withName("Settings").withIcon(R.drawable.ic_settings_grey600_24dp);
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(1).withName("Rate Us !").withIcon(R.drawable.ic_bullhorn_grey600_24dp);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(1).withName("Feedback").withIcon(R.drawable.ic_comment_text_grey600_24dp);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        new DividerDrawerItem(),
                        item5,
                        item6,
                        item7
                )
                .withAccountHeader(headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (position == 1) {
                            // User chose the "tabdownload" action open modal or something

                            Intent j = new Intent(MainActivity.this, ProfileActivity.class);
                            startActivity(j);
                            //overridePendingTransition(R.anim.Animation_3, android.R.anim.fade_out);
                        } else if (position == 2) {

                        } else if (position == 3) {

                        } else if (position == 4) {

                        } else if (position == 5) {

                        } else if (position == 6) {
                            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                            startActivity(i);
                            //overridePendingTransition(R.anim.Animation_3, android.R.anim.fade_out);
                        } else if (position == 7) {
                            // getPackageName() from Context or Activity object
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.bu.innovate.bustudentportal")));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "com.bu.innovate.bustudentportal")));
                            }
                        } else if (position == 8) {
                            /*Intent i = new Intent(MainActivity.this, FeedBackActivity.class);
                            startActivity(i);*/

                            new MaterialDialog.Builder(MainActivity.this)
                                    .title("")
                                    .customView(R.layout.feedback_dialog_content, true)
                                    .positiveText("Send Feedback")
                                    .show();
                        } else if (position == 9) {

                        } else if (position == 10) {

                        }
                        return true;
                    }
                }).withActionBarDrawerToggleAnimated(true).withSelectedItem(-1).withDelayOnDrawerClose(-1)
                .withSliderBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.googlebackground))
                .withDelayDrawerClickEvent(400)
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

       /* logoutImageView = (ImageView) findViewById(R.id.logout);
        logoutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                /*Toast.makeText(this, "Settings clicked !", Toast.LENGTH_SHORT).show();*/
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                //overridePendingTransition(R.anim.Animation_3, android.R.anim.fade_out);
                return true;


            case R.id.overflow:
                // User chose the "tabdownload" action open modal or something
                //Toast.makeText(this, "overflow c clicked !", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.refresh:
                // User chose the "tabdownload" action open modal or something
                Toast.makeText(this, "refresh clicked !", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void setupTabIcons() {

        try {
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_account_check_white_24dp);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_calendar_clock_white_24dp);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_format_list_bulleted_type_white_24dp);
        } catch (NullPointerException x) {
            Log.d("Fuck", x.getMessage());
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment3(), "ONE");
        adapter.addFragment(new Fragment2(), "TWO");
        adapter.addFragment(new Fragment1(), "THREE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void ItemClicked(View view, int position, Object object) {
        if (position == 1) {
            // User chose the "tabdownload" action open modal or something
            Intent j = new Intent(this, ProfileActivity.class);
            startActivity(j);
            overridePendingTransition(R.anim.animation_3, android.R.anim.fade_out);
        } else if (position == 6) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.animation_3, android.R.anim.fade_out);
        }
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }
}
