package in.bright.avnish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static in.bright.avnish.URLs.FEED_DISP;

public class Feeds extends AppCompatActivity {

    List<Feed> feedList;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        feedList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadFeeds();
    }

    private void loadFeeds() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, FEED_DISP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject feed = array.getJSONObject(i);

                                //adding the product to product list
                                feedList.add(new Feed(
                                        feed.getString("feed")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            FeedAdapter adapter = new FeedAdapter(Feeds.this, feedList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();

                Map<String, String>  params = new HashMap<>();
                params.put("cld",user.getCld());

                return params;
            }

        };
        queue.add(stringRequest);

  /*      StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DISPA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject feed = array.getJSONObject(i);

                                //adding the product to product list
                                feedList.add(new Feed(
                                        feed.getString("feed")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            FeedAdapter adapter = new FeedAdapter(Feeds.this, feedList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
*/
    }
}
