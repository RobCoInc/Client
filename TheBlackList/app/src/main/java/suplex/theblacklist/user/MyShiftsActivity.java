package suplex.theblacklist.user;

import android.os.Bundle;
import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;

public class MyShiftsActivity extends UserActivity {

    //private User currentUser;
    private Bundle extras;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shifts);

        db = new DatabaseHelper();
//        extras = this.getIntent().getExtras();
//
//        if(extras != null) {
//            currentUser = (User) getIntent().getSerializableExtra("CURRENT");
//        }


    }
}
