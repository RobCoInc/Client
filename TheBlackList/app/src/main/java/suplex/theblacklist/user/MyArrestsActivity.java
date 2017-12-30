package suplex.theblacklist.user;

import android.os.Bundle;

import suplex.theblacklist.R;
import suplex.theblacklist.navDrawer.DrawerBaseActivity;

public class MyArrestsActivity extends UserActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_arrests);

        DrawerBaseActivity.setupHeader(currentUser);
    }
}
