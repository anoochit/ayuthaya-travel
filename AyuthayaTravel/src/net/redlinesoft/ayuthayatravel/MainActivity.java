package net.redlinesoft.ayuthayatravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// load string array
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter
				.createFromResource(this, R.array.place,
						android.R.layout.simple_list_item_1);

		//
		final ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(arrayAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(MainActivity.this,DetailActivity.class);
				intent.putExtra("id",String.valueOf(position));
				startActivity(intent);
				
				//Toast.makeText(getApplicationContext(),String.valueOf(position), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
