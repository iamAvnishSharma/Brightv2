package in.bright.avnish;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static in.bright.avnish.URLs.EVE_DISP;

public class Events extends AppCompatActivity {

    List<Event> EventList;

    //the recyclerview
    RecyclerView recyclerView;

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


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

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        EventList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();
    }

    private void loadProducts() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.POST, EVE_DISP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject Event = array.getJSONObject(i);

                                //adding the product to product list
                                EventList.add(new Event(
                                        Event.getInt("id"),
                                        Event.getString("title"),
                                        Event.getString("dsc"),
                                        Event.getString("url")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            EventAdapter adapter = new EventAdapter(Events.this, EventList);
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

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
