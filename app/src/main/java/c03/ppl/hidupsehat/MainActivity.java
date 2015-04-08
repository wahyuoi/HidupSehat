package c03.ppl.hidupsehat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import c03.ppl.hidupsehat.Auth.Login;
import c03.ppl.hidupsehat.database.DatabaseField;
import c03.ppl.hidupsehat.database.DatabaseInfo;


public class MainActivity extends ActionBarActivity {

    private ListView obj;
    private DatabaseInfo dbInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbInfo = new DatabaseInfo(this);

        if (!dbInfo.isLogin(DatabaseField.USER_TABLE, DatabaseField.USER_COLUMN_IS_LOGIN)){
            Intent loginScreen = new Intent(getApplicationContext(), Login.class);
            loginScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Log.e("Main", "redirect to login screen!");
            startActivity(loginScreen);
            dbInfo.close();
            finish();
        } else {


//        // retrieve
            ArrayList arrayList = dbInfo.getAllDataFromTable(DatabaseField.USER_TABLE, DatabaseField.USER_COLUMN_PASSWORD);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList );

            obj = (ListView) findViewById(R.id.listView1);
            obj.setAdapter(arrayAdapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }
}
