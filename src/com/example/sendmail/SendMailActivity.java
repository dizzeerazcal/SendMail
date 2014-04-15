package com.example.sendmail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.utils.IntentUtils;

public class SendMailActivity extends ActionBarActivity implements
		OnClickListener {

	public Button sendMailButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_mail);

		sendMailButton = (Button) findViewById(R.id.send_mail_button);
		sendMailButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_mail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Intent mailIntent = new Intent(Intent.ACTION_SEND);
		mailIntent.putExtra(Intent.EXTRA_EMAIL, R.string.extra_email_text);
		mailIntent.putExtra(Intent.EXTRA_TITLE, R.string.extra_title_text);
		mailIntent.putExtra(Intent.EXTRA_TEXT, R.string.extra_body_text);
		mailIntent.putExtra(Intent.EXTRA_CC, R.string.extra_cc_text);
		
		// Check whether Intent is supported and file Intent
		if (IntentUtils.isIntentSupported(SendMailActivity.this, mailIntent)) {
			startActivity(mailIntent);
		} else {
			Toast.makeText(this, R.string.error_text, Toast.LENGTH_SHORT)
					.show();
		}
	}

}
