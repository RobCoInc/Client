package suplex.theblacklist.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.navDrawer.DrawerBaseActivity;
import suplex.theblacklist.objects.User;

public class UserActivity extends DrawerBaseActivity {

    protected User currentUser;

    private String user_email;

    private DatabaseHelper db;

    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
}
