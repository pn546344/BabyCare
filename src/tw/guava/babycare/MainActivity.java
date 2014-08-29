package tw.guava.babycare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements OnClickListener {
	myView babyView;
	SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("BabyName", Context.MODE_PRIVATE);
        String data = sp.getString("name", "null");
        Log.i("ttt", data+"");
        if(data.equals("null"))
        {
        	Intent intent = new Intent(this,CreateBaby.class);
            startActivity(intent);
        }
        
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);       
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,                  
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		babyView=(myView)findViewById(R.id.myView1);
		babyView.topLayout=(LinearLayout)findViewById(R.id.linearLayout1);
		babyView.bottomLayout=(LinearLayout)findViewById(R.id.linearLayout2);
		babyView.topLayout.setVisibility(View.GONE);
		babyView.bottomLayout.setVisibility(View.GONE);
		
        ImageView imgview=(ImageView)findViewById(R.id.imageView1);
        imgview.setOnClickListener(this);
    }
    @Override
    protected void onPause() {
    	babyView.pause();
    	super.onPause();
    }
    @Override
    protected void onResume() {
    	babyView.resume();
    	super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
		babyView.topLayout.setVisibility(View.GONE);
		babyView.bottomLayout.setVisibility(View.GONE);
		//判斷按鈕，進行動應動作
		babyView.feeding();
		
	}
}
