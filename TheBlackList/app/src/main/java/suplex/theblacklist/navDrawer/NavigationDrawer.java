package suplex.theblacklist.navDrawer;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import suplex.theblacklist.R;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;


public class NavigationDrawer {
    Activity activity;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;

    public NavigationDrawer() {

    }

    public NavigationDrawer(Activity activity) {

        this.activity = activity;
        mDrawerLayout = activity.findViewById(R.id.drawer_layout);
        navigationView = activity.findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });

    }

    public void selectDrawerItem(MenuItem menuItem) {
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
