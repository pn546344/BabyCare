package tw.guava.babycare;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

public class GameNumerical extends Activity implements Runnable{
	
	private double health;					//設定健康初始值
	private final double maxHealth = 1000;	//固定最高健康度
	private final double minHealth = 0;		//固定最低健康度
	private double feel;					//設定心情初始值
	private final double maxFeel = 1000;	//固定最高心情值
	private final double minFeel = 0;		//固定最低心情值
	private double hungry;					//設定飽食度初始值
	private final double maxHungry = 100;	//固定最高飽食度
	private final double minHungry = 0;		//固定最低飽食度
	String dataHealth;
	String dataFeel;
	String dataHungry;
	boolean stop = false;
	Thread t = new Thread(this);
	
	SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sp = getSharedPreferences("Game", Context.MODE_PRIVATE);
		//取得的遊戲參數
		dataHealth = sp.getString("health", "null");
		dataFeel = sp.getString("feel", "null");
		dataHungry	= sp.getString("hungry", "null");
		if(dataFeel.equals("null") || dataHealth.equals("null") || dataHealth.equals("null"))
		{
			//設定初始值
			health = 300;
			feel = 300;
			hungry	= 60;
		}
		else
		{
			//將儲存的資料參數讀取至遊戲中
			health = Integer.valueOf(dataHealth);
			feel   = Integer.valueOf(dataFeel);
			hungry = Integer.valueOf(dataHungry);
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//將遊戲進度儲存
		sp = getSharedPreferences("Game", MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("health", health+"");
		editor.putString("feel", feel+"");
		editor.putString("hungry", hungry+"");
		editor.commit();
		super.onDestroy();
	}
	
	@Override
	public void run() {
		while (!stop) {
			if(health <= minHealth || feel <=minFeel)
				stop = true;					//如果體力值變為0則停止迴圈
			else
			{
				health = health-0.001;			//健康度的平時消耗
				Log.i("ttt", "health="+health);
				feel = feel-0.001;				//心情度的平時消耗
			}
			
			
		}
	}
	public void setHealth(double health) {		//設定Health數值
		this.health += health;
	/*	if(stop == true)						//如果執行緒停止則重新喚醒(Debog用,正式版會移除)
		{
			stop = false;
			t.start();
		}*/
		
	}
	
	public void setFeel(double feel) {			//設定Feel數值
		this.feel += feel;
		if(stop == true)						//如果執行緒停止則重新喚醒(Debog用,正式版會移除)
		{
			stop = false;
			t.start();
		}
	}
	
	public void setHungry(double hungry) {		//設定Hungry數值
		this.hungry += hungry;
	}
	
	public double getHealth() {					//用來回傳Health的數值,血條的參考數值
		return health;
	}
	
	public double getFeel() {					//用來回傳Feel的數值,心情的參考數值
		return feel;
	}
}	
