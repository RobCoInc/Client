package suplex.theblacklist.user.newArrest;

import android.os.Bundle;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.objects.Arrest;
import suplex.theblacklist.objects.Description;
import suplex.theblacklist.user.UserActivity;

public class NewArrestTask extends UserActivity {

    protected static Arrest newArrest;
    protected static Description newDescription;

    protected DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_arrest_task);
    }
}
