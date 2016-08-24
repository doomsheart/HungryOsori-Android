package android.webcrawler.osori.hungryosori;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.webcrawler.osori.hungryosori.common.Constant;
import android.webcrawler.osori.hungryosori.common.Lib;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 고건주&정조형 on 2016-08-18.
 * 로그인 페이지 액티비티
 */



public class LoginActivity extends FragmentActivity {
    private static String email;
    private static String password;
    private EditText editText_mail, editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** 객체 설정 */
        editText_mail       = (EditText) findViewById(R.id.emailInputLogin);
        editText_password   = (EditText) findViewById(R.id.pwInputLogin);

        /** 폰트 설정 */
        Typeface fontArial = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
        editText_mail.setTypeface(fontArial);
        editText_password.setTypeface(fontArial);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginSubmitBtn:
                email = editText_mail.getText().toString().trim();
                password = editText_password.getText().toString().trim();

                /** 아이디가 올바른 이메일 형식인지 검사 */
                if (!Lib.isValidEmail(email)) {
                    Toast.makeText(this, "잘못된 email 형식입니다.", Toast.LENGTH_SHORT).show();
                    editText_mail.requestFocus();
                    break;
                }

                /** 패스워드가 최소 6자리를 넘었는지를 검사 */
               if (password.length() < Constant.PASSWORD_LENGTH_MIN) {
                    Toast.makeText(this, "패스워드는 6자리 이상 입력해주세요.", Toast.LENGTH_LONG).show();
                    editText_password.requestFocus();
                    break;
                }
                break;
            case R.id.login2JoinBtn:
                // Intent intent = new Intent(this,JoinActivity.class);
                // startActivity(intent);
                break;
        }
    }
}