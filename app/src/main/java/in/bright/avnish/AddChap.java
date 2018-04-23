package in.bright.avnish;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AddChap extends AppCompatActivity {

    EditText editTextTitle,editTextDsc,editTextUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chap);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDsc = findViewById(R.id.editTextDsc);
        editTextUrl = findViewById(R.id.editTextUrl);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddC();
            }
        });
    }


    private void AddC() {
        final String title = editTextTitle.getText().toString();
        final String dsc = editTextDsc.getText().toString();
        final String url = editTextUrl.getText().toString();

        if (TextUtils.isEmpty(title)) {
            editTextTitle.setError("Please enter title");
            editTextTitle.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(dsc)) {
            editTextTitle.setError("Please enter Description");
            editTextTitle.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(url)) {
            editTextTitle.setError("Please enter logo link");
            editTextTitle.requestFocus();
            return;
        }
        class Chapput extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("title", title);
                params.put("dsc", dsc);
                params.put("url", url);

                //returing the response
                return requestHandler.sendPostRequest(URLs.CHAP_ADD, params);
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
                     //   startActivity(new Intent(getApplicationContext(), Admin.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        Chapput f = new Chapput();
        f.execute();

    }
}
