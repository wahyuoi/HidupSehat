package c03.ppl.hidupsehat.Makanan.Resep;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by wahyuoi on 20/05/15.
 */
public class DisplayResep extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(getIntent().getExtras().getInt("id"));
    }
}
