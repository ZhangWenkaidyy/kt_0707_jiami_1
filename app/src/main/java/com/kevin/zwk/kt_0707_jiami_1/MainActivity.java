package com.kevin.zwk.kt_0707_jiami_1;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.textInputEditText)
    TextInputEditText textInputEditText;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.btn_Md5)
    Button btnMd5;
    @InjectView(R.id.btn_rsaEncrypt)
    Button btnRsaEncrypt;
    @InjectView(R.id.btn_rsaDecrypt)
    Button btnRsaDecrypt;
    @InjectView(R.id.btn_base64Encrypt)
    Button btnBase64Encrypt;
    @InjectView(R.id.btn_base64Decrypt)
    Button btnBase64Decrypt;
    @InjectView(R.id.btn_desDecrypt)
    Button btnDesDecrypt;
    @InjectView(R.id.btn_desEncrypt)
    Button btnDesEncrypt;
    @InjectView(R.id.editText)
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }


    @OnClick({R.id.btn_Md5, R.id.btn_rsaEncrypt, R.id.btn_rsaDecrypt, R.id.btn_base64Encrypt, R.id.btn_base64Decrypt, R.id.btn_desDecrypt, R.id.btn_desEncrypt})
    public void onClick(View view) {
        String str = textInputEditText.getText().toString();
        String s = null;
        String key = editText.getText()+"";
        switch (view.getId()) {
            case R.id.btn_Md5:
                s = EncryptUtils.md5(str);
                break;
            case R.id.btn_rsaEncrypt:
                s = EncryptUtils.rsaEncrypt(str);
                break;
            case R.id.btn_rsaDecrypt:
                s = EncryptUtils.rsaDecrypt(str);
                break;
            case R.id.btn_base64Encrypt:
                s = EncryptUtils.base64Encrypt(str);
                break;
            case R.id.btn_base64Decrypt:
                s = EncryptUtils.base64Decrypt(str);
                break;
            case R.id.btn_desDecrypt:
                s = EncryptUtils.desDecrypt(key, str);
                break;
            case R.id.btn_desEncrypt:
                s = EncryptUtils.desEncrypt(key, str);
                break;


        }
        textView.setText(s);
    }
}
