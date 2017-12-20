package suplex.theblacklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import suplex.theblacklist.login.LoginActivity;
import suplex.theblacklist.login.RegisterActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        startActivity(new Intent(this, RegisterActivity.class));

        //splash screen before login
    }
}
