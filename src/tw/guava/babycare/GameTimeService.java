package tw.guava.babycare;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class GameTimeService extends Service{
	
	MyTimer myTimer = new MyTimer();
	Thread t = new Thread(myTimer);
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("ttt", "service onCreate");
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i("ttt", "service onStartCommand");
		
		t.start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("ttt", "service onDestory");
		myTimer.stop = true;
		super.onDestroy();
	}
	
	class MyTimer implements Runnable
	{
		Thread t = new Thread(this);
		Boolean stop = false;
		long[] vibrate = {0,100,200,300};
		
		
		@Override
		public void run() {
			Timer time = new Timer();
			//NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);;
			//NotificationCompat.Builder builder;
		
				while(!stop){
					try {
						Thread.sleep(1000*60);		//17分鐘會發生一次突發狀況
						Log.i("ttt", "Service jobs");
						/*builder = new NotificationCompat.Builder(this);
						builder.setAutoCancel(true);
						builder.setTicker("Baby is Care");
						builder.setContentTitle("Baby is Care");
						builder.setVibrate(vibrate);
						builder.setContentText("Baby is Care");
						builder.setSmallIcon(R.drawable.ic_launcher);
						notificationManager.notify(0, builder.build());
						Log.i("ttt", "notification is work");*/
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				}
				
					
				
			
		}
	}
		
}

