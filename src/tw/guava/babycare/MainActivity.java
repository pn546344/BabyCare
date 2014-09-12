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
        sp = getSharedPreferences("BabyName", Context.MODE_PRIVATE);	//Ū�����઺�W�l
        String data = sp.getString("name", "null");
        //�p�G�L�kŪ�����઺�W�l�ɴN�|�N�e������ܳЫ����઺�e��
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
		babyView.barLayout = (LinearLayout)findViewById(R.id.LinearLayout3);
		babyView.topLayout.setVisibility(View.GONE);	//����topLayout
		babyView.bottomLayout.setVisibility(View.GONE);	//����bottomLayout
		
		//�]�w�e�������s
        ImageView imgview1=(ImageView)findViewById(R.id.imageView1);
        ImageView imgview2=(ImageView)findViewById(R.id.imageView2);
        ImageView imgview3=(ImageView)findViewById(R.id.imageView3);
        ImageView imgview4=(ImageView)findViewById(R.id.imageView4);
        ImageView imgview5=(ImageView)findViewById(R.id.imageView5);
        ImageView imgview6=(ImageView)findViewById(R.id.imageView6);
        imgview1.setOnClickListener(this);
        imgview2.setOnClickListener(this);
        imgview3.setOnClickListener(this);
        imgview4.setOnClickListener(this);
        imgview5.setOnClickListener(this);
        imgview6.setOnClickListener(this);
        
        Intent intent = new Intent(this,GameTimeService.class);
        startService(intent);
        
        
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
		babyView.topLayout.setVisibility(View.GONE);
		babyView.bottomLayout.setVisibility(View.GONE);
		babyView.barLayout.setVisibility(View.VISIBLE); //���barLayout
		//�P�_���s�A�i������ʧ@
		babyView.feeding();
		switch (v.getId()) {
		case R.id.imageView1:	//imageView1�Q���U�K����t�襤�{��
			babyView.game.setHealth(5);		//�W�[���d��5���
			babyView.game.setFeel(2); 		//�W�[�߲z���A2���
			babyView.game.setHungry(30); 	//�W�[������30���
			break;
		case R.id.imageView2:	//imageView2�Q���U�ɸ���e����Food����(�ƭ��~)
			intent = new Intent(this,FoodList.class);
            startActivity(intent);
			break;
		case R.id.imageView3:	//imageView3
			babyView.game.setFeel(100);
			break;
		case R.id.imageView4:	//imageView4
			babyView.game.setFeel(100);
			break;
		case R.id.imageView5:	//imageView5�Q���U�ɸ���e����Nursery����
			intent = new Intent(this,Nursery.class);
            startActivity(intent);
			break;
		case R.id.imageView6:	//imageView6�Q���U�ɸ���e����NurseryCenter����
			intent = new Intent(this,NurseryCenter.class);
            startActivity(intent);
			break;
		}
		
	}
}
