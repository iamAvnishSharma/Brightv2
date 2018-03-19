package in.bright.avnish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class NotesByear extends AppCompatActivity {
VideoView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_byear);

        findViewById(R.id.first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NotesBranch.class));
            }
        });

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NotesBranch.class));
            }
        });

        findViewById(R.id.third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NotesBranch.class));
            }
        });

        findViewById(R.id.fourth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NotesBranch.class));
            }
        });
        v1=(VideoView)findViewById(R.id.videoViewbyear);
        Uri u= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg);
        v1.setVideoURI(u);
        v1.start();
        v1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });




    }
}
