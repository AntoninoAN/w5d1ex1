package com.example.tony.w5d1ex01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private MyReceiver receiver;
    @BindView(R.id.et_input)
    EditText et_input_value;
    @BindView(R.id.tv_result)
    TextView tv_result_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(MyReceiver.ACTION_RESPOND);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver= new MyReceiver();
        registerReceiver(receiver,filter);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(receiver!=null) {
            unregisterReceiver(receiver);//you need to unregister also unbind something
            receiver = null;
        }
    }

    public class MyReceiver extends BroadcastReceiver {
        public static final String ACTION_RESPOND = "com.example.tony.w5d1ex01.ACTION_RESPOND";

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView resultTV = (TextView) findViewById(R.id.tv_result);
            String result = intent.getStringExtra(MyIntentService.RESULT_MESSAGE);
            resultTV.setText(result);
        }
    }
    @OnClick(R.id.btn_send_service)
    public void sendWorkToService(){
        String inputMsg= et_input_value.getText().toString();
        Intent intentServiceIntent= new Intent(this,MyIntentService.class);
        intentServiceIntent.putExtra(MyIntentService.INPUT_MESSAGE,inputMsg);
        startService(intentServiceIntent);
    }
}
