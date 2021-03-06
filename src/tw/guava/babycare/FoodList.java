package tw.guava.babycare;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FoodList extends Activity implements OnItemClickListener {
	String [] date , data;
	int[] pic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_list);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		ArrayList<HashMap<String,Object>>list = new ArrayList<HashMap<String, Object>>();
		date = new String[]{"米糊","肉泥","嬰兒餅乾","白飯"};
		data = new String[]{"適合4~6個月大時餵食","適合7個月大後餵食","適合8個月大後餵食","適合一歲後餵食"};
		pic = new int[]{R.drawable.rice_water,R.drawable.meat,R.drawable.cookie,R.drawable.rice};
		for(int i=0;i<date.length;i++)
		{
			HashMap<String, Object>item = new HashMap<String, Object>();
			item.put("date", date[i]);
			item.put("data", data[i]);
			item.put("pic", pic[i]);
			list.add(item);
		}
		ListView lv = (ListView)findViewById(R.id.listView1);
		SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.cus_list, new String[]{"pic", "date","data"},new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food_list, menu);
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		String itencode="0";
		if(arg3 == 0)
			itencode = "1";
			//Log.i("ttt", "米胡");
		else if(arg3 == 1)
			itencode = "2";
			//Log.i("ttt", "肉泥");
		else if (arg3 == 2)
			itencode = "3";
			//Log.i("ttt", "餅該");
		else 
			itencode = "4";
			//Log.i("ttt", "白飯");
			
		intent.putExtra("result", itencode);
		setResult(RESULT_OK,intent);
		finish();
		
	}

		
	
}
