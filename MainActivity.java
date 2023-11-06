package co.kr.mmu;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), login_loading.class);
                EditText editText1 = findViewById(R.id.textView01);
                EditText editText2 = findViewById(R.id.textView02);
                intent1.putExtra("editText1",editText1.getText().toString());
                intent1.putExtra("editText2",editText2.getText().toString());
                setResult(RESULT_OK, intent1);
                startActivity(intent1);
                launcher.launch(intent1);
            }
        });
        launcher = registerForActivityResult(new ActivityResultContracts.
                StartActivityForResult(), null);
    }
}
