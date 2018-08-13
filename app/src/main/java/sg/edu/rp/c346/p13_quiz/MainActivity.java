package sg.edu.rp.c346.p13_quiz;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new wallPaperBroadcast();
    RadioButton rbGood;
    RadioButton rbBad;
    RadioGroup rg;
    //String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbGood = findViewById(R.id.radioButtonGood);
        rbBad = findViewById(R.id.radioButtonBad);
        rg = findViewById(R.id.radioGroup);
        onPause();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br,filter);
    }


    @Override
    protected void onPause() {
        super.onPause();

        String text = "";
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        int check = rg.getCheckedRadioButtonId();
        if(check == rbGood.getId()){
            text = rbGood.getText().toString();
        }
        else{
            text = rbBad.getText().toString();
        }

        prefEdit.putString("msg",text);
        prefEdit.commit();

    }

}
