package suplex.theblacklist.database;

import android.os.AsyncTask;
import android.util.Log;

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

    public static class HttpGetRequest extends AsyncTask<String, Void, String> {
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

    public static class HttpPostRequest extends AsyncTask<String, String, String> {
        public static final String REQUEST_METHOD = "POST";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String stringJson = params[1];
            String result;
            String outputLine;

            HttpHandler httpHandler = new HttpHandler();
            result = httpHandler.postDataToServer(stringUrl, stringJson);
            return result;
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }

    public String addNewUser (User user)
    {
        HttpPostRequest postUser = new HttpPostRequest();
        String response = "{}";
        String json = formJSONUser(user);

        try {
            response = postUser.execute("http://159.203.30.147/api/users", json).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //handle response

        return "success";
    }

    private User formUserObj(String jsonString)
    {
        User user = new User();

        try {
            JSONArray arr = new JSONArray(jsonString);
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

    private String formJSONUser(User user)
    {
        JSONObject temp = new JSONObject();

        try
        {
            temp.put("password", user.getPassword());
            temp.put("email", user.getEmail());
            temp.put("firstName", user.getFirstName());
            temp.put("lastName", user.getLastName());
            temp.put("companyId", user.getCompanyId());
            temp.put("cellNumber", user.getCellNo());

            if (user.getIsAdmin()) {
                temp.put("isAdmin", 1);
            }
            else
            {
                temp.put("isAdmin", 0);
            }

            temp.put("isBasic", 0);

            return temp.toString();
        }
        catch (JSONException e1)
        {
            Log.d("JWP", "Can't Format JSON");
            e1.printStackTrace();
        }
        return null;
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
        User user;

        try {
            result = getUser.execute("http://159.203.30.147/api/users/getUserByEmail/" + email).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        user = formUserObj(result);

        if (user == null)
        {
            return null;
        }
        else
        {
            return user;
        }
    }
}

