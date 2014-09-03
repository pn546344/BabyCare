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
        sp = getSharedPreferences("BabyName", Context.MODE_PRIVATE);	//讀取嬰兒的名子
        String data = sp.getString("name", "null");
        Log.i("ttt", data+"");
        //如果無法讀取嬰兒的名子時就會將畫面跳轉至創建嬰兒的畫面
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
		babyView.bottomLayout=(LinearLayout)findViewById(R.id.linearLayout2);
		babyView.bottomLayout.setVisibility(View.GONE);
		
		//設定畫面的按鈕
        ImageView imgview1=(ImageView)findViewById(R.id.imageView1);
        ImageView imgview2=(ImageView)findViewById(R.id.imageView2);
        ImageView imgview3=(ImageView)findViewById(R.id.imageView3);
        imgview1.setOnClickListener(this);
        imgview2.setOnClickListener(this);
        imgview3.setOnClickListener(this);
        
        
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
		Intent intent;
		babyView.bottomLayout.setVisibility(View.GONE);
		//判斷按鈕，進行動應動作
		babyView.feeding();
		switch (v.getId()) {

		case R.id.imageView1:	//imageView1被按下時跳轉畫面到Food頁面
			intent = new Intent(this,Food.class);
            startActivity(intent);
			break;
		case R.id.imageView2:	//imageView2被按下時跳轉畫面到Interactive頁面
			intent = new Intent(this,Interactive.class);
            startActivity(intent);
			break;
		case R.id.imageView3:	//imageView3被按下時跳轉畫面到Food頁面
			intent = new Intent(this,Nursery.class);
            startActivity(intent);
			break;
		}
		
	}
}
