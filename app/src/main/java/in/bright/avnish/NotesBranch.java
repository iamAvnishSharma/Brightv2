package in.bright.avnish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class NotesBranch extends AppCompatActivity {

    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_branch);


        Intent i=getIntent();
        s = (int) i.getExtras().get("S");

        findViewById(R.id.comp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s==1)
                {
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://drive.google.com/drive/u/0/folders/1lB690ewfWW5gcscv3b8cVxqQGbOkLj0W"));
                    startActivity(browserIntent);
                }
                else if(s==2)
                {
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://drive.google.com/drive/u/0/folders/0B-V3wT1S5beASlNuenBKN1NfczA"));
                    startActivity(browserIntent);

                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), Notes.class));
                }

            }
        });

        findViewById(R.id.it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s==1)
                {
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://drive.google.com/drive/u/0/folders/1lB690ewfWW5gcscv3b8cVxqQGbOkLj0W"));
                    startActivity(browserIntent);
                }
                else if(s==2)
                {
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://drive.google.com/drive/u/0/folders/0B-V3wT1S5beASlNuenBKN1NfczA"));
                    startActivity(browserIntent);

                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), Notes.class));
                }
            }
        });

        findViewById(R.id.mech).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

        findViewById(R.id.extc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

        findViewById(R.id.chem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

        findViewById(R.id.civil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s==1)
                {
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://drive.google.com/drive/u/0/folders/1uO2A525TF5jQc-RFgkmD2chAV7mBj2V2"));
                    startActivity(browserIntent);

                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), Notes.class));
                }

            }
        });



    }
}
