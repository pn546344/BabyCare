package tw.guava.babycare;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GameTimeService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	class Timer implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
