package in.bright.avnish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

public class NotesStream extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_stream);

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



        findViewById(R.id.mba).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),NotesMyear.class);
                i.putExtra("S",1);
                startActivity(i);
            }
        });

        findViewById(R.id.btech).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),NotesByear.class);
                i.putExtra("S",2);
                startActivity(i);
            }
        });


    }
}
