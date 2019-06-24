package swufe.com.haidao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button btn_register;
    private EditText et_user_name, et_psw, et_psw_again;
    private String userName, psw,pswAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }
    private void init() {
        btn_register=findViewById(R.id.btn_register);
        et_user_name=findViewById(R.id.et_user_name);
        et_psw=findViewById(R.id.et_psw);
        et_psw_again=findViewById(R.id.et_psw_again);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getEditString();
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(pswAgain)){
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();

                }else if(!psw.equals(pswAgain)){
                    Toast.makeText(RegisterActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();

                }else if(isExistUserName(userName)){
                    Toast.makeText(RegisterActivity.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    saveRegisterInfo(userName, psw);
                    Intent data = new Intent();
                    data.putExtra("userName", userName);
                    setResult(RESULT_OK, data);
                    RegisterActivity.this.finish();
                }
            }
        });
    }
    private void getEditString(){
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }
    private boolean isExistUserName(String userName){
        boolean has_userName=false;
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        String spPsw=sp.getString(userName, "");
        if(!TextUtils.isEmpty(spPsw)) {
            has_userName=true;
        }
        return has_userName;
        }
    private void saveRegisterInfo(String userName,String psw){
        String md5Psw = MD5Utils.md5(psw);
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(userName, md5Psw);
        editor.commit();
    }
    }

