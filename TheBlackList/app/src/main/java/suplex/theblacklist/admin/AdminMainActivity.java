package suplex.theblacklist.admin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;

public class AdminMainActivity extends AdminActivity {

    DatabaseHelper db;

    long id;

    TextView mUserName;

    Button mLocations;
    Button mApplyForShift;
    Button mShifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        // db = new DatabaseHelper(this);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");

        // id = db.getUserIdByEmail(emailFromIntent);

        // String username = (db.getUsernameByEmail(emailFromIntent));
    }
}
