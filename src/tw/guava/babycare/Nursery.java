package tw.guava.babycare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Nursery extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nursery);
		ActionBar actionBar = getActionBar();
		actionBar.hide();	//����ActionBar
		ImageView img1 = (ImageView)findViewById(R.id.imageView1);
		ImageView img2 = (ImageView)findViewById(R.id.imageView2);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nursery, menu);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (arg0.getId()) {
		case R.id.imageView1:
			intent = new Intent(this,NurseryPeople.class);
            startActivity(intent);
			break;
		case R.id.imageView2:
			intent = new Intent(this,NurseryCenter.class);
            startActivity(intent);
			break;
	
		}
	}
}
