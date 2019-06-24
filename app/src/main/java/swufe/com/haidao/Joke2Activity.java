package swufe.com.haidao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Joke2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke2);
        Intent intent = getIntent();
        int now_jinbishu2 = intent.getIntExtra("now_jinbishu_key", 0);
        int now_jifenshu2 = intent.getIntExtra("now_jifenshu_key", 0);
        Log.i("", "当前金币数为：" + now_jinbishu2);
        Log.i("", "当前积分数为：" + now_jifenshu2);
        if (now_jinbishu2 < 3 || now_jifenshu2 < 200) {
            Toast.makeText(this, "游戏结束了！", Toast.LENGTH_SHORT);
            Intent denglu = new Intent(this, DengLuActivity.class);
            startActivity(denglu);
        } else if (now_jinbishu2 < 3 || now_jifenshu2 > 200) {
            Toast.makeText(this, "金币不足，该轮将损失200积分", Toast.LENGTH_SHORT);
        } else if (now_jifenshu2 < 200 || now_jinbishu2 > 3) {
            Toast.makeText(this, "积分不足，该轮将损失3个金币", Toast.LENGTH_SHORT);
        }

    }
    public void btnJinbi(View btn){
        Intent intent = getIntent();
        int now_jinbishu2 = intent.getIntExtra("now_jinbishu_key", 0);
        int now_jifenshu2 = intent.getIntExtra("now_jifenshu_key", 0);
        Intent youxi = new Intent(this, YouXiActivity.class);
        youxi.putExtra("now_jinbishu2_key", now_jinbishu2);
        youxi.putExtra("now_jifenshu_key", now_jifenshu2);
        startActivity(youxi);

    }
    public void btnJifen(View btn){
        Intent intent = getIntent();
        int now_jinbishu2 = intent.getIntExtra("now_jinbishu_key", 0);
        int now_jifenshu2 = intent.getIntExtra("now_jifenshu_key", 0);
        Intent youxi = new Intent(this, YouXiActivity.class);
        youxi.putExtra("now_jinbishu2_key", now_jinbishu2);
        youxi.putExtra("now_jifenshu_key", now_jifenshu2);
        startActivity(youxi);
    }
}
