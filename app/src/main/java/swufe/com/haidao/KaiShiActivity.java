package swufe.com.haidao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
public class KaiShiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openOne(View btn){
        Log.i("open","openOne:");
        Intent KaiShi = new Intent(this, DengLuActivity.class);
        startActivity(KaiShi);

    }
}
