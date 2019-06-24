package swufe.com.haidao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class YouXiActivity extends AppCompatActivity {
    private TextView tv_buShu, jinbishu, jifenshu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_xi);
        tv_buShu = findViewById(R.id.tv_buShu);
        jinbishu = findViewById(R.id.jinbishu);
        jifenshu = findViewById(R.id.jifenshu);
    }
    public void btnAdd1(View btn){
        showBushu();
    }
    public void btnAdd2(View btn){
        Qianjin();
    }
    public void showBushu(){
        int Bushu = (int) (1+Math.random()*6);
        Log.i("","产生的随机数是：" + Bushu);
        tv_buShu.setText("" + Bushu);
        String old_pos = (String) tv_buShu.getText();
        int now_pos = Integer.parseInt(old_pos);
        Log.i("", "当前位置为：" + now_pos);
    }
    public void Qianjin(){
        String dianshu = (String) tv_buShu.getText();
        int qianjinbushu = Integer.parseInt(dianshu);
        Log.i("", "当前可前进的步数为：" +qianjinbushu);
        if(qianjinbushu ==1){
            String old_jinbishu = (String) jinbishu.getText();
            int now_jinbishu = Integer.parseInt(old_jinbishu);
            now_jinbishu = now_jinbishu+5;
            Log.i("", "当前金币数为：" + now_jinbishu);
            jinbishu.setText("" + now_jinbishu);
        }else if(qianjinbushu==2){
            String old_jifenshu = (String) jifenshu.getText();
            int now_jifenshu = Integer.parseInt(old_jifenshu);
            now_jifenshu = now_jifenshu + 100;
            Log.i("", "当前积分数为：" + now_jifenshu);
            jifenshu.setText("" + now_jifenshu);
        }else if(qianjinbushu==3){
            String old_jinbishu = (String) jinbishu.getText();
            int now_jinbishu = Integer.parseInt(old_jinbishu);
            String old_jifenshu = (String) jifenshu.getText();
            int now_jifenshu = Integer.parseInt(old_jifenshu);
            Intent joke = new Intent(this, Joke2Activity.class );
            joke.putExtra("now_jinbishu_key",now_jinbishu);
            joke.putExtra("now_jifenshu_key", now_jifenshu);
            if(now_jinbishu<3|| now_jifenshu>200){
                Toast.makeText(this, "你的金币不够支付，该轮将损失200积分", Toast.LENGTH_SHORT);
            }else if(now_jifenshu<200||now_jifenshu<3){
                Toast.makeText(this, "你的积分不足,请支付金币", Toast.LENGTH_SHORT);
            }else if(now_jinbishu<3||now_jifenshu<200){
                Toast.makeText(this, "游戏结束了", Toast.LENGTH_SHORT);
            }
            startActivity(joke);
        }else if(qianjinbushu==4){

        }else if(qianjinbushu==5){
            String old_jinbishu = (String) jinbishu.getText();
            int now_jinbishu = Integer.parseInt(old_jinbishu);
            now_jinbishu = now_jinbishu+5;
            Log.i("", "当前金币数为：" + now_jinbishu);
            jinbishu.setText("" + now_jinbishu);
        }else{

        }
    }
}
