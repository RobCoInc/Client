package suplex.theblacklist.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.navDrawer.DrawerBaseActivity;
import suplex.theblacklist.user.UserMainActivity;
import suplex.theblacklist.validation.InputValidation;

public class LoginActivity extends DrawerBaseActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatButton appCompatButtonLogin;

    private AppCompatTextView textViewLinkRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper();

        // databaseHelper.seedAdmin();
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);

    }

    private void initListeners() {
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    private void initObjects() {
        // databaseHelper = new DBHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                VerifiyFromDatabase();
                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void VerifiyFromDatabase() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        String password = databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim());

        if (password.equals(textInputEditTextPassword.getText().toString().trim()))
        {
            Intent accountIntent = new Intent(activity, UserMainActivity.class);
            accountIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountIntent);
        }


//        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
//                , textInputEditTextPassword.getText().toString().trim())) {

//            if(databaseHelper.isAdmin(textInputEditTextEmail.getText().toString().trim()))
//            {
//                Intent adminIntent = new Intent(activity, AdminMainActivity.class);
//                adminIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
//                emptyInputEditText();
//                startActivity(adminIntent);
//            }
//            else
//            {
//                Intent accountIntent = new Intent(activity, UserMainActivity.class);
//                accountIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
//                emptyInputEditText();
//                startActivity(accountIntent);
//            }
//        } else {
//            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
//        }
    }

    private void emptyInputEditText() {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }


}