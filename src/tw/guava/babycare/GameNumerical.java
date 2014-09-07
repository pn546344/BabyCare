package tw.guava.babycare;

import android.util.Log;

public class GameNumerical extends Thread{
	
	private double health = 300 ;			//�]�w���d��l��
	private final double maxHealth = 1000;	//�T�w�̰����d��
	private final double minHealth = 0;		//�T�w�̧C���d��
	private double feel = 300;				//�]�w�߱���l��
	private final double maxFeel = 1000;	//�T�w�̰��߱���
	private final double minFeel = 0;		//�T�w�̧C�߱���
	private double hungry = 60;				//�]�w�����ת�l��
	private final double maxHungry = 100;	//�T�w�̰�������
	private final double minHungry = 0;		//�T�w�̧C������
	
	boolean stop = false;

	@Override
	public void run() {
		while (!stop) {
			health = health-0.001;			//���d�ת����ɮ���
			Log.i("ttt", "health="+health);
			feel = feel-0.001;				//�߱��ת����ɮ���
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
