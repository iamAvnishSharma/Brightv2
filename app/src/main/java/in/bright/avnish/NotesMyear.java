package in.bright.avnish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class NotesMyear extends AppCompatActivity {

    int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_myear);

        Intent i=getIntent();
        s = (int) i.getExtras().get("S");

        findViewById(R.id.first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://drive.google.com/drive/u/0/folders/0B-V3wT1S5beAeGh4MFJ4YzdLUFE"));
                startActivity(browserIntent);
            }
        });

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),NotesBranch.class);
                i.putExtra("S",s);
                startActivity(i);
            }
        });

        findViewById(R.id.third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

        findViewById(R.id.fourth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

        findViewById(R.id.fifth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });

//        v1=(VideoView)findViewById(R.id.videoView_myear);
//        Uri u= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg);
//        v1.setVideoURI(u);
//        v1.start();
//        v1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setLooping(true);
//            }
//        });
//
    }
}
