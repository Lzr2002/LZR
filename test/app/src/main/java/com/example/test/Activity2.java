package com.example.test;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    ///private Intent intent1;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_2);

        textView=findViewById(R.id.textView10);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity2.this,resultActivity.class);
                test.launch(intent);
            }
        });

        //Intent intent=getIntent();

    }

    public ActivityResultLauncher test= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==666){
                        Log.d("JOJO","onActivityResult 有返回值。。。");
                        //TextView textView=findViewById(R.id.textView10);
                        textView.setText(result.getData().getStringExtra("data"));
                        //textView2.setText(result.getData().getStringExtra("data"));
                    };
                }
            });


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("JOJO","activity2 is onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("JOJO","activity2 is onRestart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("JOJO","activity2 is onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("JOJO","activity2 is onDestroy...");
    }

    @Override
    public void finish(){
        super.finish();
        Log.d("JOJO","activity2 is finish...");
    }

    @Override
    public void finishActivity(int requestCode){
        super.finishActivity(requestCode);
        Log.d("JOJO","finishActivity2...");
    }
}
