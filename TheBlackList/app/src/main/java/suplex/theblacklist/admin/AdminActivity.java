package suplex.theblacklist.admin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;
import suplex.theblacklist.navDrawer.DrawerBaseActivity;
import suplex.theblacklist.objects.User;

public class AdminActivity extends DrawerBaseActivity {

    protected User admin;

    private String user_email;

    private DatabaseHelper db;

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // db = new DatabaseHelper(this);
        extras = getIntent().getExtras();

        user_email = extras.getString("EMAIL");

        // long user_id = db.getUserIdByEmail(user_email);
        // admin = db.getUserById(user_id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_basic, menu);

        for(int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
            spanString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spanString.length(), 0); //fix the color to white
            item.setTitle(spanString);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_location:
                Intent iArrest = new Intent(this, NewLocationActivity.class);
                startActivity(iArrest);
                return super.onOptionsItemSelected(item);
            case R.id.action_location_list:
                Intent iLocation = new Intent(this, LocationListActivity.class);
                startActivity(iLocation);
                return super.onOptionsItemSelected(item);
            case R.id.action_user_list:
                Intent intent = new Intent(this, UserListActivity.class);
                intent.putExtra("EMAIL", user_email);
                startActivity(intent);
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
