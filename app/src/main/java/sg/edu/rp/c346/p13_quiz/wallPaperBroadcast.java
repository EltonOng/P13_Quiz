package sg.edu.rp.c346.p13_quiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by 16043971 on 13/8/2018.
 */

public class wallPaperBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        String m = prefs.getString("msg","wrong");
        Toast.makeText(context,m,Toast.LENGTH_LONG).show();
    }
}
