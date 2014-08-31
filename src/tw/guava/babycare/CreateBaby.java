package tw.guava.babycare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBaby extends Activity implements OnClickListener {

	SharedPreferences sp , sp1;
	String level=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_baby);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		sp=getSharedPreferences("BabyName", MODE_PRIVATE);
		sp1 = getSharedPreferences("GameLevel", MODE_PRIVATE);
		Button btn = (Button)findViewById(R.id.button1);
		Button	btn1 = (Button)findViewById(R.id.button2);
		Button	btn2 = (Button)findViewById(R.id.button3);
		Button	btn3 = (Button)findViewById(R.id.button4);
		btn.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Button btn = (Button)findViewById(R.id.button1);
		switch (arg0.getId()) {
		case R.id.button1:
			EditText ed = (EditText)findViewById(R.id.editText1);
			if(ed.getText()+"" != "" && level != null)
			{
			String name = ed.getText()+"";
			Editor editor = sp.edit();
			Editor editor1 = sp1.edit();
			editor.putString("name", name);	//�x�s����W�l�����
			editor.commit();
			editor1.putString("level", level);	//�x�s�C�����ת����
			editor1.commit();
			Log.i("ttt", "sp="+sp.getString("name", "no name"));
			finish();
			}
			else
			{
				Toast.makeText(this, "�п�J�W�l", Toast.LENGTH_SHORT).show();
				//��ܴ����лy
			}
			
			break;
		case R.id.button2:
			level = "²��";	//�N���I��²��
			btn.setEnabled(true);	//�ϽT�{���s�i�H�Q���U
			break;
		case R.id.button3:
			level = "����";	//�N���I�襤��
			btn.setEnabled(true);	//�ϽT�{���s�i�H�Q���U
			break;
		case R.id.button4:
			level = "�x��";	//�N���I��x��
			btn.setEnabled(true);	//�ϽT�{���s�i�H�Q���U
			break;
		}
		
		
		
		
		
		
		
	}

	

	
}
