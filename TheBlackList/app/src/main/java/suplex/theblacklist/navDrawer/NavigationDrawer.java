package suplex.theblacklist.navDrawer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import suplex.theblacklist.R;


public class NavigationDrawer {
    Activity activity;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;

    public NavigationDrawer(Activity activity) {

        this.activity = activity;
        mDrawerLayout = activity.findViewById(R.id.drawer_layout);
        navigationView = activity.findViewById(R.id.navigation);
        populateAdminMenu(navigationView.getMenu());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });

    }

    private void populateAdminMenu(Menu menu) {
        menu.add(0, R.id.nav_admin_new_location, Menu.NONE, R.string.new_location).setIcon(R.drawable.ic_add_location_black_24dp);
        menu.add(0, R.id.nav_admin_add_shift, Menu.NONE, R.string.add_shift).setIcon(R.drawable.ic_add_circle_outline_black_24dp);
        menu.add(0, R.id.nav_admin_assign_shift, Menu.NONE, R.string.assign_shifts).setIcon(R.drawable.ic_person_pin_circle_black_24dp);
        menu.add(0, R.id.nav_user_view_shift, Menu.NONE, R.string.view_shifts).setIcon(R.drawable.ic_timer_black_24dp);
        menu.add(0, R.id.nav_user_make_arrest, Menu.NONE, R.string.make_arrest).setIcon(R.drawable.ic_person_add_black_24dp);
        menu.add(0, R.id.nav_user_search_arrest, Menu.NONE, R.string.search_arrests).setIcon(R.drawable.ic_search_black_24dp);


    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_user_view_shift:
                Toast.makeText(this.activity.getApplicationContext(), "View Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_user_make_arrest:
                Toast.makeText(this.activity.getApplicationContext(), "Make Arrest", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_user_search_arrest:
                Toast.makeText(this.activity.getApplicationContext(), "Search Arrest", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_add_shift:
                Toast.makeText(this.activity.getApplicationContext(), "Add Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_assign_shift:
                Toast.makeText(this.activity.getApplicationContext(), "Assign Shift", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_admin_new_location:
                Toast.makeText(this.activity.getApplicationContext(), "New Location", Toast.LENGTH_SHORT).show();
                break;
            default:

        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Close the navigation drawer
        mDrawerLayout.closeDrawers();

//        startActivity(intent);
    }
}
