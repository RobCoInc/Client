package suplex.theblacklist;

import android.os.Bundle;

import suplex.theblacklist.navDrawer.DrawerBaseActivity;

public class LandingActivity extends DrawerBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

//        startActivity(new Intent(this, LoginActivity.class));
        //splash screen before login
    }
}
