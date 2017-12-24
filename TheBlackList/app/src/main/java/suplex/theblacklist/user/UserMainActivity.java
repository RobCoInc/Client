package suplex.theblacklist.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.objects.User;

public class UserMainActivity extends UserActivity {

    // private User currentUser;

    private Bundle extras;

    private DatabaseHelper db;

    private TextView mFirstNameView;
    private TextView mLastNameView;
    private TextView mEmailView;
    private TextView mPasswordView;

    private Button mMyShiftsButton;
    private Button mMyArrestsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        mFirstNameView = (TextView) findViewById(R.id.user_main_first_name);
        mLastNameView = (TextView) findViewById(R.id.user_main_last_name);
        mEmailView = (TextView) findViewById(R.id.user_main_email);
        mPasswordView = (TextView) findViewById(R.id.user_main_password);

        mMyShiftsButton = (Button) findViewById(R.id.my_shifts_button);
        mMyArrestsButton = (Button) findViewById(R.id.my_arrests_button);

        db = new DatabaseHelper();
        extras = this.getIntent().getExtras();

        if(extras != null) {
            currentUser = (User) getIntent().getSerializableExtra("CURRENT");

            mFirstNameView.setText(currentUser.getFirstName());
            mLastNameView.setText(currentUser.getLastName());
            mEmailView.setText(currentUser.getEmail());
            mPasswordView.setText(currentUser.getPassword());
        }

        mMyShiftsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myShiftsIntent = new Intent(getBaseContext(), MyShiftsActivity.class);
                startActivity(myShiftsIntent);
            }
        });

        mMyArrestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myArrestsIntent = new Intent(getBaseContext(), MyArrestsActivity.class);
                startActivity(myArrestsIntent);
            }
        });
    }
}
