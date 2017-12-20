package suplex.theblacklist.admin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import suplex.theblacklist.R;
import suplex.theblacklist.database.DatabaseHelper;

import static android.widget.CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER;

public class LocationListActivity extends AppCompatActivity {
    private final String TAG = "LocationListActivity";

    DatabaseHelper db;

    ListView mLocationListView;

    ArrayAdapter adapter;
    SimpleCursorAdapter cAdapter;
    Cursor cursor;

    long user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        // db = new DatabaseHelper(this);

        Bundle extras = getIntent().getExtras();

        // user_id = extras.getLong("user_id");

        mLocationListView = (ListView) findViewById(R.id.locationListView);
        // adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, db.getAllLocations());

        // cursor = db.readAllLocations();
        cAdapter = new SimpleCursorAdapter(this, R.layout.support_simple_spinner_dropdown_item, cursor, new String[]{"location_name", "location_address"}, new int[]{android.R.id.text1, android.R.id.text2}, FLAG_REGISTER_CONTENT_OBSERVER);

        mLocationListView.setAdapter(cAdapter);
        mLocationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + l);
                Intent intent = new Intent(getBaseContext(), LocationActivity.class);
                intent.putExtra("location_id", l);
                //intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        // cursor = db.readAllLocations();
        cAdapter = new SimpleCursorAdapter(this, R.layout.support_simple_spinner_dropdown_item, cursor, new String[]{"location_name", "location_address"}, new int[]{android.R.id.text1, android.R.id.text2}, FLAG_REGISTER_CONTENT_OBSERVER);
        mLocationListView.setAdapter(cAdapter);
        mLocationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + l);
                Intent intent = new Intent(getBaseContext(), LocationActivity.class);
                intent.putExtra("location_id", l);
                //intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });
    }
}
