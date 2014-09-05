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

	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_baby);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		sp=getSharedPreferences("BabyName", MODE_PRIVATE);
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

			EditText ed = (EditText)findViewById(R.id.editText1);
			if(ed.getText()+"" != "")
			{
			String name = ed.getText()+"";
			Editor editor = sp.edit();
			editor.putString("name", name);	//儲存嬰兒名子的資料
			editor.commit();
			Log.i("ttt", "sp="+sp.getString("name", "no name"));
			finish();
			}
			else
			{
				Toast.makeText(this, "請輸入名子", Toast.LENGTH_SHORT).show();
				//顯示提醒標語
			}
		

		}
		
	
}
