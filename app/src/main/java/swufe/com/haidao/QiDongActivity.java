package swufe.com.haidao;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class QiDongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_dong);


    }
    public void openOne4(View btn) {
        Log.i("open", "openOne:");
        Intent QiDong = new Intent(this, YouXiActivity.class);
        startActivity(QiDong);
    }
    public void showdialog(View view){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("确定要退出程序吗？");
        alertdialogbuilder.setPositiveButton("确定", click1);
        alertdialogbuilder.setNegativeButton("取消", click2);
        AlertDialog alertDialog1 = alertdialogbuilder.create();
        alertDialog1.show();
    }
    private DialogInterface.OnClickListener click1 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {
            finish();
        }
    };
    private DialogInterface.OnClickListener click2 = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface arg0, int arg1){
            arg0.cancel();
        }
    };
}
