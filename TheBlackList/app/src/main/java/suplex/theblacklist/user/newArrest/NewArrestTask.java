package suplex.theblacklist.user.newArrest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import suplex.theblacklist.R;
import suplex.theblacklist.objects.Arrest;
import suplex.theblacklist.objects.Description;
import suplex.theblacklist.user.UserActivity;

public class NewArrestTask extends AppCompatActivity {

    protected Arrest newArrest;
    protected Description newDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_arrest_task);
    }
}
