package suplex.theblacklist.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import suplex.theblacklist.R;
import suplex.theblacklist.admin.AdminMainActivity;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.objects.User;
import suplex.theblacklist.user.UserMainActivity;

public class SuccessfulLoginActivity extends AppCompatActivity {
    private final AppCompatActivity activity = SuccessfulLoginActivity.this;

    private String email;
    private User currentUser;

    private Bundle extras;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);

        db = new DatabaseHelper();
        extras = getIntent().getExtras();

        email = extras.getString("EMAIL");

        currentUser = db.getUserByEmail(email);

        // Brief splash screen welcome user...

        extras.putSerializable("CURRENT", currentUser);

        if(currentUser.getIsAdmin())
        {
            Intent adminIntent = new Intent(activity, AdminMainActivity.class);
            adminIntent.putExtra("CURRENT", currentUser);
            startActivity(adminIntent);
        } else if(currentUser.getIsBasic()) {
//            Intent basicIntent = new Intent(activity, BasicMainActivity.class);
//            basicIntent.putExtra("CURRENT", currentUser);
//            startActivity(basicIntent);
        } else {
            Intent userIntent = new Intent(activity, UserMainActivity.class);
            userIntent.putExtra("CURRENT", currentUser);
            startActivity(userIntent);
        }
    }
}
