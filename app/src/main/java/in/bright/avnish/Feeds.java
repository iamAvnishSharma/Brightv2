package in.bright.avnish;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);


        //  NAVIGATION DRAWER
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_feed) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Feeds.class));
                            return true;
                        }
                        if (id == R.id.nav_notes) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), NotesStream.class));
                            return true;
                        }
                        if (id == R.id.nav_event) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Events.class));
                            return true;
                        }
                        if (id == R.id.nav_chap) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Comm.class));
                            return true;
                        }

                        if (id == R.id.nav_out) {
                            finish();
                            SharedPrefManager.getInstance(getApplicationContext()).logout();
                        }


                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

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
