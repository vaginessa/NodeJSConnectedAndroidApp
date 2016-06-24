package redefiningproductions.com.nodejsandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Michael on 4/5/2016.
 */
public class signup extends Activity {

    public Button submit;
    public EditText username_field;
    public EditText password_field;
    public EditText email_field;
    public NetworkHelper networkHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        networkHelper = new NetworkHelper();
        submit = (Button) findViewById(R.id.signup);
        username_field = (EditText) findViewById(R.id.sign_up_username);
        password_field = (EditText) findViewById(R.id.sign_up_password);
        email_field = (EditText) findViewById(R.id.sign_up_email);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String username = username_field.getText().toString();
                String password = password_field.getText().toString();
                String email = email_field.getText().toString();


                String json = "{\"name\": \"" + username + "\", \"email\": \"\" + email + \"\", \"password\":\"" + password + "\"}";
                networkHelper.post("http://ubersitter.herokuapp.com/signup/", json, new Callback() {

                    @Override
                    public void onFailure(Request request, IOException e) {
                        Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onResponse(Response response) throws IOException {
                        String responseStr = response.body().string();
                        final String messageText = "Status code : " + response.code() +
                                "\n" +
                                "Response body : " + responseStr;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), messageText, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });



            }

        });



    }
}
