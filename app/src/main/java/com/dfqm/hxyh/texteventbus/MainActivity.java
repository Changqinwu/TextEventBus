package com.dfqm.hxyh.texteventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
    }


    public void btnEventbus(View view) {
        EventBus.getDefault().post(new MessageEvent("订阅成功"));
        EventBus.getDefault().post(new MessageEvent("Hello World"));
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        String message = event.getMessage();
        if (message.equals("订阅成功")) {
            tv.setText(message);
        }else if (message.equals("Hello World")) {
            tv2.setText(message);
        }

    }

}
