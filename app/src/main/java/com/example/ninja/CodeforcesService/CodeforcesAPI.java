package com.example.ninja.CodeforcesService;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ninja.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CodeforcesAPI {
    public static final String Query_For_User_Info = "https://codeforces.com/api/user.info?handles=";
    Context context;
    String rank;
    public CodeforcesAPI(Context context) {
        this.context = context;
    }
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String rank);
    }
    public interface ReportResponseListener {
        void onError(String message);

         void onResponse(User userProfile);
    }


    public void getRank(String handle, VolleyResponseListener volleyResponseListener) {
        String url = Query_For_User_Info + handle;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        rank = "";
                        try {
                            rank = response.getJSONArray("result").getJSONObject(0).getString("rank");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Toast.makeText(context,rank,Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onResponse(rank);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onError("Error");
                    }
                });
        // Instantiate the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
    public void getUserProfile(String handle,ReportResponseListener reportResponseListener){
        String url=Query_For_User_Info+handle;
        List<User> report=new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        User firstProfile=new User();
                        try {
                            JSONObject userList=response.getJSONArray("result").getJSONObject(0);
                            firstProfile.setHandle(userList.getString("handle"));
                            firstProfile.setRank(userList.getString("rank"));
                            firstProfile.setMaxRank(userList.getString("maxRank"));
                            firstProfile.setRating(userList.getInt("rating"));
                            firstProfile.setMaxRating(userList.getInt("maxRating"));
                            reportResponseListener.onResponse(firstProfile);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        reportResponseListener.onError("Error");
                    }
                });
        // Instantiate the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
