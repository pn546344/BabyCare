package tw.guava.babycare;

import android.util.Log;

public class GameNumerical extends Thread{
	
	private double health = 300 ;			//設定健康初始值
	private final double maxHealth = 1000;	//固定最高健康度
	private final double minHealth = 0;		//固定最低健康度
	private double feel = 300;				//設定心情初始值
	private final double maxFeel = 1000;	//固定最高心情值
	private final double minFeel = 0;		//固定最低心情值
	private double hungry = 60;				//設定飽食度初始值
	private final double maxHungry = 100;	//固定最高飽食度
	private final double minHungry = 0;		//固定最低飽食度
	
	boolean stop = false;

	@Override
	public void run() {
		while (!stop) {
			health = health-0.001;			//健康度的平時消耗
			Log.i("ttt", "health="+health);
			feel = feel-0.001;				//心情度的平時消耗
			if(health <= minHealth)
				stop = true;
		}
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getFeel() {
		return feel;
	}
}	
