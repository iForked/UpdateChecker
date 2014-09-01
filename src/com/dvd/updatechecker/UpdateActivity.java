package com.dvd.updatechecker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class UpdateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ((Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN
				| Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR1 | Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2)) {
			String ver = "JellyBean ";
			Toast.makeText(
					getApplicationContext(),
					getApplicationContext().getString(R.string.curr_ver) + "\n"
							+ "\n" + "Android " + ver + Build.VERSION.RELEASE
							+ "\n" + "              API:"
							+ Build.VERSION.SDK_INT, Utils.duration).show();
			openActivity();
		} else {
			if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
				String ver = "KitKat ";
				Toast.makeText(
						getApplicationContext(),
						getApplicationContext().getString(R.string.curr_ver)
								+ "\n" + "\n" + "Android " + ver
								+ Build.VERSION.RELEASE + "\n"
								+ "              API:" + Build.VERSION.SDK_INT,
						Utils.duration).show();
				openActivity();
			}
		}
	}

	private void openActivity() {
		try {
			startActivity(new Intent(Intent.ACTION_MAIN).setClassName(
					"com.google.android.gms",
					"com.google.android.gms.update.SystemUpdateActivity"));

		} catch (ActivityNotFoundException ex) {
			Toast.makeText(getApplicationContext(),
					"error! please update gsm!", Utils.duration).show();
		}
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		if (level == TRIM_MEMORY_UI_HIDDEN) {
			this.finish();
		}

	}
}