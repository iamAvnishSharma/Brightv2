package in.bright.avnish;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AddFeeds extends AppCompatActivity {

    EditText editTextFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feeds);

        editTextFeed = findViewById(R.id.editTextFeed);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFeed();
            }
        });
    }


    private void AddFeed() {
        final String feed = editTextFeed.getText().toString();

        if (TextUtils.isEmpty(feed)) {
            editTextFeed.setError("Please enter message");
            editTextFeed.requestFocus();
            return;
        }

        class Feedput extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("feed", feed);
                params.put("cld", user.getCld());

                //returing the response
                return requestHandler.sendPostRequest(URLs.FEED_ADD, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //displaying the progress bar while user registers on the server
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //hiding the progressbar after completion
                progressBar.setVisibility(View.GONE);

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();



                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), Dash.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        Feedput f = new Feedput();
        f.execute();

    }
}
