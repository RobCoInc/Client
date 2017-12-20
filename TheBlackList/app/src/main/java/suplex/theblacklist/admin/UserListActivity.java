package suplex.theblacklist.admin;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import suplex.theblacklist.R;
import suplex.theblacklist.database.HttpHandler;

public class UserListActivity extends AdminActivity {

    private String TAG = UserListActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://api.androidhive.info/contacts/";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.user_list);

        class GetContacts extends AsyncTask<Void, Void, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog
                pDialog = new ProgressDialog(UserListActivity.this);
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);
                pDialog.show();

            }

            @Override
            protected Void doInBackground(Void... arg0) {
                HttpHandler sh = new HttpHandler();

                // Making a request to url and getting response
                String jsonStr = sh.makeServiceCall(url);

                Log.e(TAG, "Response from url: " + jsonStr);

                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);

                        // Getting JSON Array node
                        JSONArray contacts = jsonObj.getJSONArray("contacts");

                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);

                            String id = c.getString("_id");
                            String firstName = c.getString("first_name");
                            String lastName = c.getString("last_name");
                            String email = c.getString("email");

                            String companyId = c.getString("company_id");
                            String gender = c.getString("gender");

                            // Phone node is JSON Object
                            JSONObject phone = c.getJSONObject("phone");
                            String mobile = phone.getString("mobile");
                            String home = phone.getString("home");
                            String office = phone.getString("office");

                            // tmp hash map for single contact
                            HashMap<String, String> contact = new HashMap<>();

                            // adding each child node to HashMap key => value
                            contact.put("_id", id);
                            contact.put("last_name", lastName);
                            contact.put("email", email);
                            contact.put("mobile", mobile);

                            // adding contact to contact list
                            contactList.add(contact);
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }
                } else {
                    Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();
                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        UserListActivity.this, contactList,
                        R.layout.list_user_item, new String[]{"name", "email",
                        "mobile"}, new int[]{R.id.user_last_name,
                        R.id.user_email, R.id.user_mobile});

                lv.setAdapter(adapter);
            }

        }
    }
}
