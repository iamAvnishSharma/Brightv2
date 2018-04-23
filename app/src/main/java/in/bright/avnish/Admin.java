package in.bright.avnish;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


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
                            Toast.makeText(getApplicationContext(), "THIS IS ADMIN LOGIN ", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        if (id == R.id.nav_notes) {
                            Toast.makeText(getApplicationContext(), "THIS IS ADMIN LOGIN ", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        if (id == R.id.nav_event) {
                            Toast.makeText(getApplicationContext(), "THIS IS ADMIN LOGIN ", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        if (id == R.id.nav_chap) {
                            Toast.makeText(getApplicationContext(), "THIS IS ADMIN LOGIN ", Toast.LENGTH_SHORT).show();
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



        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }


        findViewById(R.id.addchap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //           finish();
                startActivity(new Intent(getApplicationContext(), AddChap.class));
            }
        });

        findViewById(R.id.addevent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //           finish();
                startActivity(new Intent(getApplicationContext(), AddChap.class));
            }
        });

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     //           finish();
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });


        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });




    }
}
