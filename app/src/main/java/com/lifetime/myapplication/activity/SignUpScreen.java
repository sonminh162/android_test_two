package com.lifetime.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lifetime.myapplication.R;

import static com.lifetime.myapplication.constant.Constant.EMAIL;
import static com.lifetime.myapplication.constant.Constant.PASSWORD;
import static com.lifetime.myapplication.constant.Constant.USER_NAME;

public class SignUpScreen extends AppCompatActivity {

    TextView signUpButton;
    TextView signIn;
    TextView userName;
    TextView password;
    TextView emailAddress;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.am2_containter);

        signIn = findViewById(R.id.sign_in_text);
        signUpButton = findViewById(R.id.button_sign_up);
        userName = findViewById(R.id.full_name_value);
        password = findViewById(R.id.password_value_am2);
        emailAddress = findViewById(R.id.email_address_value_sign_in);

        sharedPreferences = getSharedPreferences("dataSignUp",MODE_PRIVATE);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveDataToSharedPreferences();
               openDialogShowResult();
            }
        });
    }

    private void saveDataToSharedPreferences(){
        String getUserName = userName.getText().toString().trim();
        String getPassword = password.getText().toString().trim();
        String getEmail = emailAddress.getText().toString().trim();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, getUserName);
        editor.putString(EMAIL,getEmail);
        editor.putString(PASSWORD,getPassword);
        editor.apply();

    }

    private void openDialogShowResult(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(R.string.title_dialog);
        alertDialog.setMessage(getResources().getString(R.string.message_dialog));

        alertDialog.setButton(getResources().getString(R.string.next_activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SignUpScreen.this, SignInCreen.class);
                startActivity(intent);
            }
        });
        alertDialog.show();
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
