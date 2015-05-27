package c03.ppl.hidupsehat.Achievement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import c03.ppl.hidupsehat.MainActivity;
import c03.ppl.hidupsehat.Menu.AchievementMenu;
import c03.ppl.hidupsehat.R;

/**
 * Created by Irwan on 27/05/2015.
 */
public class Kalori extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perhitungan_kalori);


        ImageButton next = (ImageButton) findViewById(R.id.next);
        ImageButton cancel = (ImageButton) findViewById(R.id.cancel);
        ImageButton submit = (ImageButton) findViewById(R.id.submit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Kalori.class);
                Log.e(Kalori.class.getName(), "Ke Perhitungan Kalori Selanjutnya");
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Log.e(MainActivity.class.getName(), "Kembali Ke Menu Utama");
                startActivity(intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Log.e(MainActivity.class.getName(), "Kembali Ke Menu Utama");
                startActivity(intent);
                finish();
            }
        });
    }
}
