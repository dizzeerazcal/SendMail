package com.example.utils;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class IntentUtils {
	/** Check whether intent can be filed **/
	public static boolean isIntentSupported(Context context, Intent intent) {
		PackageManager packageManager = context.getPackageManager();
		// Get a list of activities that support the queried intent
		List<ResolveInfo> activities = packageManager.queryIntentActivities(
				intent, PackageManager.MATCH_DEFAULT_ONLY);
		// If list contains elements, return true
		return activities.size() > 0;
	}
}
