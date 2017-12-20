package suplex.theblacklist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import suplex.theblacklist.login.LoginActivity;
import suplex.theblacklist.login.RegisterActivity;
import suplex.theblacklist.navDrawer.DrawerBaseActivity;
import suplex.theblacklist.navDrawer.NavigationDrawer;

public class LandingActivity extends DrawerBaseActivity{

    Boolean admin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (admin) {
            setContentView(R.layout.activity_landing_admin);
        } else {
            setContentView(R.layout.activity_landing);
        }
//        startActivity(new Intent(this, LoginActivity.class));
//        NavigationDrawer mNavDrawer = new NavigationDrawer(this);

        //splash screen before login
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
