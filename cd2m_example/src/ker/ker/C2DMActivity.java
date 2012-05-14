package ker.ker;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class C2DMActivity extends Activity {
    /** Called when the activity is first created. */
	
	public final static String AUTH = "authentication";

	// Example Activity to trigger a request for a registration ID to the Google
	// server
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void register(View view) {
		Log.w("C2DM", "start registration process");
		Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
		intent.putExtra("app",
				PendingIntent.getBroadcast(this, 0, new Intent(), 0));
		// Sender currently not used
		intent.putExtra("sender", "ideksolutions@gmail.com");
		startService(intent);
	}

	public void showRegistrationId(View view) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		String string = prefs.getString(AUTH, "n/a");
		Toast.makeText(this, string, Toast.LENGTH_LONG).show();
		Log.d("C2DM RegId", string);

	}
}