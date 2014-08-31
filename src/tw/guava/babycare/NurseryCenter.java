package tw.guava.babycare;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;

public class NurseryCenter extends Activity implements OnClickListener {

	NumberPicker np1,np2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nursery_center);
		ActionBar actionBar = getActionBar();
		actionBar.hide();	//¡Ù¬√ActionBar
		np1 = (NumberPicker)findViewById(R.id.numberPicker1);
		np2 = (NumberPicker)findViewById(R.id.numberPicker2);
		NumberPicker.Formatter Two_Digit = new NumberPicker.Formatter() {
			@Override
			public String format(int value) {
				// TODO Auto-generated method stub
				return String.format("%02d", value);
			}
		};
		np1.setMaxValue(7);
		np1.setMinValue(0);
		np1.setWrapSelectorWheel(true);
		np2.setMaxValue(59);
		np2.setMinValue(0);
		np2.setFormatter(Two_Digit);
		np2.setWrapSelectorWheel(true);
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nursery_center, menu);
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
		// TODO Auto-generated method stub
		
		
	}
}
