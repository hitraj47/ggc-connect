package edu.ggc.it.schedule;

import edu.ggc.it.R;
import edu.ggc.it.R.layout;
import edu.ggc.it.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.Spinner;

public class SchedulePreferenceActivity extends Activity {
	
	private Spinner spnReminderTime;
	
	public static final String SHARED_PREFERENCES_FILE = "schedule_reminder";
	public static final String KEY_REMINDER_STRING = "schedule_reminder_string";
	public static final String KEY_SPINNER_REMINDER_POS = "schedule_reminder_pos";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule_preference);
		
		spnReminderTime = (Spinner) findViewById(R.id.schedule_pref_spn_reminder);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences settings = getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
		spnReminderTime.setSelection(settings.getInt("schedule_reminder_pos", 0));
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences settings = getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_REMINDER_STRING, spnReminderTime.getSelectedItem().toString());
		editor.putInt(KEY_SPINNER_REMINDER_POS, spnReminderTime.getSelectedItemPosition());
		editor.commit();
	}
}
