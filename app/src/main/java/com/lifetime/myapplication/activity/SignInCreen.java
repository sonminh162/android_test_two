package com.lifetime.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lifetime.myapplication.R;

import static com.lifetime.myapplication.constant.Constant.EMAIL;
import static com.lifetime.myapplication.constant.Constant.PASSWORD;

public class SignInCreen extends AppCompatActivity {

    TextView forgotButton;
    SharedPreferences sharedPreferences;
    TextView email;
    TextView password;
    TextView signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.am_containter);

        signInButton = findViewById(R.id.button_sign_in);
        email = findViewById(R.id.email_address_value_sign_in);
        password = findViewById(R.id.password_input);
        sharedPreferences = getSharedPreferences("dataSignUp",MODE_PRIVATE);
        email.setText(sharedPreferences.getString(EMAIL,""));
        password.setText(sharedPreferences.getString(PASSWORD,""));

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean emailValid = email.getText().toString().equals(sharedPreferences.getString(EMAIL, ""));
                boolean passwordValid = password.getText().toString().equals(sharedPreferences.getString(PASSWORD,""));
                if (emailValid && passwordValid){
                    Intent intent = new Intent(SignInCreen.this,NewFeedActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignInCreen.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        forgotButton = findViewById(R.id.forgot_password);
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

    }

    private void customActionBar() {
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
