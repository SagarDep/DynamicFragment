package kr.co.sangcomz.dynamicfragment;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    Button btn;
    EditText et;
    Button btn2;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et_num);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubActivity.class);
                Bundle b = new Bundle();
                b.putString("test", "isTest");
                b.putString("et", et.getText().toString());
                i.putExtra("bundle", b);
                startActivity(i);
            }
        });

        et2 = (EditText)findViewById(R.id.et_num2);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubSubActivity.class);
                Bundle b = new Bundle();
                b.putString("test", "isTest");
                b.putString("et", et2.getText().toString());
                i.putExtra("bundle", b);
                startActivity(i);
            }
        });
    }

}
