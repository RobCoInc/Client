package suplex.theblacklist.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.objects.User;

public class UserMainActivity extends AppCompatActivity {

    private User currentUser;

    private Bundle extras;

    private DatabaseHelper db;

    private TextView firstNameView;
    private TextView lastNameView;
    private TextView emailView;
    private TextView passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        firstNameView = (TextView) findViewById(R.id.user_main_first_name);
        lastNameView = (TextView) findViewById(R.id.user_main_last_name);
        emailView = (TextView) findViewById(R.id.user_main_email);
        passwordView = (TextView) findViewById(R.id.user_main_password);

        db = new DatabaseHelper();
        extras = this.getIntent().getExtras();

        if(extras != null) {
            currentUser = (User) getIntent().getSerializableExtra("CURRENT");

            firstNameView.setText(currentUser.getFirstName());
            lastNameView.setText(currentUser.getLastName());
            emailView.setText(currentUser.getEmail());
            passwordView.setText(currentUser.getPassword());
        }
    }
}
