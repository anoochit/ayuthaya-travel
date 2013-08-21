package net.redlinesoft.ayuthayatravel;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		// resource for detail
		int[] placeDetail = { R.array.place1, R.array.place2 };

		// get from extra
		int id = 0;

		Bundle bundle = getIntent().getExtras();
		id = Integer.parseInt(bundle.getString("id"));

		final String[] placeDetailString = getResources().getStringArray(
				placeDetail[id]);

		TextView placeTitle = (TextView) findViewById(R.id.textView1);
		placeTitle.setText(placeDetailString[0]);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// intent to open mapp
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("geo:0,0?q=" + placeDetailString[1] + " ("
								+ placeDetailString[0] + ")"));
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
