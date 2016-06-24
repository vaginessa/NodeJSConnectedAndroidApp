package redefiningproductions.com.nodejsandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by Michael on 4/5/2016.
 */
public class about extends Activity {

    public Button backbutton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        backbutton = (Button) findViewById(R.id.back);



    }
}
