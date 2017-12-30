package suplex.theblacklist.user.newArrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import suplex.theblacklist.R;
import suplex.theblacklist.objects.Arrest;

public class BasicDescriptionActivity extends NewArrestTask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_description);

        newArrest = new Arrest();
    }
}
