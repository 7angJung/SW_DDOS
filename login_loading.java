package co.kr.mmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class login_loading extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_loading);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){

                            Intent data = result.getData();
                            TextView textView1 = findViewById(R.id.textView001);
                            TextView textView2 = findViewById(R.id.textView002);
                            textView1.setText(data.getStringExtra("editText1"));
                            textView2.setText(data.getStringExtra("editText2"));
                        }
                    }
                }
        );

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run(){
                Intent intent = new Intent(getApplicationContext(), scheduleActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
