package suplex.theblacklist.navDrawer;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import suplex.theblacklist.R;
import suplex.theblacklist.objects.User;

public abstract class DrawerBaseActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {

    private FrameLayout view_stub;
    private NavigationView navigation_view;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    Toolbar mToolbar;
    static TextView mUserNameHeader;
    static TextView mTimeOfDay;
    static View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_base);
        view_stub = findViewById(R.id.view_stub);
        navigation_view = findViewById(R.id.navigation);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        Menu drawerMenu = navigation_view.getMenu();
        header = navigation_view.getHeaderView(0);


//        setupHeader();
        setupToolbar();
        populateAdminMenu(navigation_view.getMenu());
        for (int i = 0; i < drawerMenu.size(); i++) {
            drawerMenu.getItem(i).setOnMenuItemClickListener(this);
        }

    }

    public static void setupHeader(User currentUser) {

        mUserNameHeader = header.findViewById(R.id.nav_header_user_name);
        mTimeOfDay = header.findViewById(R.id.nav_header_time_of_day);

        mUserNameHeader.setText(currentUser.getFirstName());

        Calendar calender = Calendar.getInstance();
        if (6 < calender.get(Calendar.HOUR_OF_DAY) && calender.get(Calendar.HOUR_OF_DAY) < 12) {
            mTimeOfDay.setText(R.string.good_morning_text);
        } else if (12 <= calender.get(Calendar.HOUR_OF_DAY) && calender.get(Calendar.HOUR_OF_DAY) < 17) {
            mTimeOfDay.setText(R.string.good_afternoon_text);
        } else {
            mTimeOfDay.setText(R.string.good_evening_text);
        }
    }

    public void setupToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("SPLX");
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (view_stub != null) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            View stubView = inflater.inflate(layoutResID, view_stub, false);
            view_stub.addView(stubView, lp);
        }
    }

    @Override
    public void setContentView(View view) {
        if (view_stub != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            view_stub.addView(view, lp);
        }
    }

    private void populateAdminMenu(Menu menu) {
        menu.add(0, R.id.nav_admin_new_location, Menu.NONE, R.string.new_location).setIcon(R.drawable.ic_add_location_black_24dp);
        menu.add(0, R.id.nav_admin_add_shift, Menu.NONE, R.string.add_shift).setIcon(R.drawable.ic_add_circle_outline_black_24dp);
        menu.add(0, R.id.nav_admin_assign_shift, Menu.NONE, R.string.assign_shifts).setIcon(R.drawable.ic_person_pin_circle_black_24dp);


        menu.add(0, R.id.nav_user_view_shift, Menu.NONE, R.string.view_shifts).setIcon(R.drawable.ic_timer_black_24dp);
        menu.add(0, R.id.nav_user_make_arrest, Menu.NONE, R.string.new_arrest).setIcon(R.drawable.ic_person_add_black_24dp);
        menu.add(0, R.id.nav_user_search_arrest, Menu.NONE, R.string.search_arrests).setIcon(R.drawable.ic_search_black_24dp);

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (view_stub != null) {
            view_stub.addView(view, params);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_user_view_shift:
                Toast.makeText(this, "View Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_user_make_arrest:
                Toast.makeText(this, "Make Arrest", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_user_search_arrest:
                Toast.makeText(this, "Search Arrest", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_add_shift:
                Toast.makeText(this, "Add Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_assign_shift:
                Toast.makeText(this, "Assign Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_new_location:
                Toast.makeText(this, "New Location", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

}
