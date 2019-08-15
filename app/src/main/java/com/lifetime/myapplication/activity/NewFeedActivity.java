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
import com.lifetime.myapplication.adapter.NewFeedAdapter;
import com.lifetime.myapplication.model.Info;

import java.util.ArrayList;

public class NewFeedActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        customActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_feed);

        initView();
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

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_new_feed);
        recyclerView.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Info> arrayList = new ArrayList<>();
        arrayList.add(new Info(R.drawable.avatar_example1,getResources().getString(R.string.example1),getResources().getString(R.string.example2),getResources().getString(R.string.example3),R.drawable.rectangle_copy,getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1,getResources().getString(R.string.example1),getResources().getString(R.string.example2),getResources().getString(R.string.example3),R.drawable.rectangle_copy,getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1,getResources().getString(R.string.example1),getResources().getString(R.string.example2),getResources().getString(R.string.example3),R.drawable.rectangle_copy,getResources().getString(R.string.example5)));
        arrayList.add(new Info(R.drawable.avatar_example1,getResources().getString(R.string.example1),getResources().getString(R.string.example2),getResources().getString(R.string.example3),R.drawable.rectangle_copy,getResources().getString(R.string.example5)));
        NewFeedAdapter adapter = new NewFeedAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
