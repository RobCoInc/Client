package suplex.theblacklist.database;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import suplex.theblacklist.objects.User;

/**
 * Created by Morgan on 18/12/2017.
 */

public class DatabaseHelper {

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String result;
            String inputLine;

            HttpHandler httpHandler = new HttpHandler();
            result = httpHandler.makeServiceCall(stringUrl);
            return result;
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }

    private User formUserObj(String jsonString)
    {
        User temp = new User();
        JSONObject jsonObj;

        try {
            jsonObj = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public String checkUser(String email) {
        HttpGetRequest checkUser = new HttpGetRequest();
        String result = "{}";
        String passwordStr = "";

        try {
            result = checkUser.execute("http://159.203.30.147/api/users/getUserByEmail/" + email).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            JSONArray arr = new JSONArray(result);
            JSONObject jObj = arr.getJSONObject(0);
            passwordStr = jObj.getString("password");
            return passwordStr;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return passwordStr;
    }

    public User getUserByEmail(String email)
    {
        HttpGetRequest getUser = new HttpGetRequest();
        String result = "{}";
        User user = new User();

        try {
            result = getUser.execute("http://159.203.30.147/api/users/getUserByEmail/" + email).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONArray arr = new JSONArray(result);
            JSONObject jObj = arr.getJSONObject(0);

            user.setId(jObj.getLong("_id"));
            user.setPassword(jObj.getString("password"));
            user.setEmail(jObj.getString("email"));
            user.setFirstName(jObj.getString("firstName"));
            user.setLastName(jObj.getString("lastName"));
            user.setCompanyId(jObj.getLong("companyId"));
            user.setCellNo(jObj.getString("cellNumber"));

            if (jObj.getInt("isAdmin") == 1)
            {
                user.setIsAdmin(true);
            }
            else
            {
                user.setIsAdmin(false);
            }

            if (jObj.getInt("isBasic") == 1)
            {
                user.setIsBasic(true);
            }
            else
            {
                user.setIsBasic(false);
            }

            return user;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}

