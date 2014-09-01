package tw.guava.babycare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Cap;
import android.media.JetPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

public class myView extends SurfaceView implements Runnable{
	LinearLayout topLayout,bottomLayout;
	SurfaceHolder holder;
	Context context;
	boolean stop=false;
	int x,y,picIndex=0,direction=0;
	Thread t;
	int screenWidth=0,screenHeight=0,picWidth,picHeight;
	Bitmap babyImg[]=new Bitmap[2];
	boolean visible=false;
	Paint health = new Paint();
	Paint feel = new Paint();
	
	public myView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
		holder=getHolder();
		babyImg[0]=BitmapFactory.decodeResource(getResources(), R.drawable.baby1);
		babyImg[1]=BitmapFactory.decodeResource(getResources(), R.drawable.baby2);
		picWidth=babyImg[0].getWidth();
		picHeight=babyImg[0].getHeight();
		health.setColor(Color.RED);	//設定筆刷顏色
		health.setStrokeCap(Cap.ROUND);	//設定筆刷類型
		health.setStrokeWidth(10);   //設定筆刷粗細
		feel.setColor(Color.BLUE);
		feel.setStrokeCap(Cap.ROUND);
		feel.setStrokeWidth(10);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Rect rect=new Rect(x, y, x+picWidth, y+picHeight);
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_MOVE:
				
				break;
			case MotionEvent.ACTION_UP:
				if(	rect.contains((int)event.getRawX(), (int)event.getRawY()))
				{
					if(!visible)
					{
						topLayout.setVisibility(View.VISIBLE);
						bottomLayout.setVisibility(View.VISIBLE);
					}else
					{
						topLayout.setVisibility(View.GONE);
						bottomLayout.setVisibility(View.GONE);
					}
					visible=!visible;
				}
				break;
		}
		return true;

	}
	

	@Override
	public void run() {
		while(!stop)
		{
			if(!holder.getSurface().isValid())
				continue;
			Rect rect=holder.getSurfaceFrame();
			if(screenWidth==0&&screenHeight==0)
			{
				screenHeight=rect.height();
				screenWidth=rect.width();
				x=screenWidth/2-picWidth/2;
				y=screenHeight/2-picHeight/2;
			}
			Canvas canvas=holder.lockCanvas();
			canvas.drawARGB(255, 150, 150, 10);
			canvas.drawBitmap(babyImg[picIndex], x, y, null);
			canvas.drawLine(100, 50, 550, 50, health);	//畫線
			canvas.drawLine(100, 130, 550, 130, feel);
			holder.unlockCanvasAndPost(canvas);
			picIndex++;
			if(picIndex>=babyImg.length)
				picIndex=0;
			if(direction==0)
			{
				x+=10;
				if(x>=screenWidth-picWidth)
				{
					direction=1;
					x=screenWidth-picWidth;
				}
			}
			else if(direction==1){
				x-=10;
				if(x<=0)
				{
					direction=0;
					x=0;
				}
			}
			
		}

	}
	void feeding()
	{
		Log.i("mylog", "餵食");
	}
	void pause()
	{
		//要把一些資訊儲存起來
		stop=true;
		while(true)
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		t=null;
	}
	void resume()
	{
		stop=false;
		t=new Thread(this);
		t.start();
	}

}
