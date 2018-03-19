package in.bright.avnish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dash extends AppCompatActivity {


    Button addf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


        findViewById(R.id.buttonNotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NotesByear.class));
            }
        });

        findViewById(R.id.Events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Events.class));
            }
        });

        findViewById(R.id.comm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Comm.class));
            }
        });

        findViewById(R.id.buttonFeeds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Feeds.class));
            }
        });

        addf =findViewById(R.id.buttonAddFeeds);

                addf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), AddFeeds.class));
            }
        });


        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
        if(user.getLevel()==2)
        {
            addf.setVisibility(View.VISIBLE); //SHOW the button
        }



        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });


    }
}
