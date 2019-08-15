package com.lifetime.myapplication.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.myapplication.R;
import com.lifetime.myapplication.adapter.MessageAdapter;
import com.lifetime.myapplication.model.Message;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView =findViewById(R.id.message_recycler_view);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));
        messages.add(new Message(R.drawable.yo,getResources().getString(R.string.example7),getResources().getString(R.string.example8),getResources().getString(R.string.time_example)));

        MessageAdapter adapter = new MessageAdapter(messages,getApplicationContext());
        recyclerView.setAdapter(adapter);
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
