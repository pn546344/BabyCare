package tw.guava.babycare;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

public class GameNumerical extends Activity implements Runnable{
	
	private double health;					//�]�w���d��l��
	private final double maxHealth = 1000;	//�T�w�̰����d��
	private final double minHealth = 0;		//�T�w�̧C���d��
	private double feel;					//�]�w�߱���l��
	private final double maxFeel = 1000;	//�T�w�̰��߱���
	private final double minFeel = 0;		//�T�w�̧C�߱���
	private double hungry;					//�]�w�����ת�l��
	private final double maxHungry = 100;	//�T�w�̰�������
	private final double minHungry = 0;		//�T�w�̧C������
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
		//���o���C���Ѽ�
		dataHealth = sp.getString("health", "null");
		dataFeel = sp.getString("feel", "null");
		dataHungry	= sp.getString("hungry", "null");
		if(dataFeel.equals("null") || dataHealth.equals("null") || dataHealth.equals("null"))
		{
			//�]�w��l��
			health = 300;
			feel = 300;
			hungry	= 60;
		}
		else
		{
			//�N�x�s����ưѼ�Ū���ܹC����
			health = Integer.valueOf(dataHealth);
			feel   = Integer.valueOf(dataFeel);
			hungry = Integer.valueOf(dataHungry);
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//�N�C���i���x�s
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
				stop = true;					//�p�G��O���ܬ�0�h����j��
			else
			{
				health = health-0.001;			//���d�ת����ɮ���
				Log.i("ttt", "health="+health);
				feel = feel-0.001;				//�߱��ת����ɮ���
			}
			
			
		}
	}
	public void setHealth(double health) {		//�]�wHealth�ƭ�
		this.health += health;
	/*	if(stop == true)						//�p�G���������h���s���(Debog��,�������|����)
		{
			stop = false;
			t.start();
		}*/
		
	}
	
	public void setFeel(double feel) {			//�]�wFeel�ƭ�
		this.feel += feel;
		if(stop == true)						//�p�G���������h���s���(Debog��,�������|����)
		{
			stop = false;
			t.start();
		}
	}
	
	public void setHungry(double hungry) {		//�]�wHungry�ƭ�
		this.hungry += hungry;
	}
	
	public double getHealth() {					//�ΨӦ^��Health���ƭ�,������ѦҼƭ�
		return health;
	}
	
	public double getFeel() {					//�ΨӦ^��Feel���ƭ�,�߱����ѦҼƭ�
		return feel;
	}
}	
