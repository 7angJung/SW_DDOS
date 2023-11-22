package co.kr.M_Git_Project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    private Post post; // post 객체
    private static final int CREATE_POST_REQUEST = 1;
    private static final int EDIT_POST_REQUEST = 2;
    private static final int DELETE_POST_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 화면 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);



        // Intent에서 데이터를 받아오는 작업
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("post")) {
            post = (Post) intent.getSerializableExtra("post"); // post 객체를 동기화함

            // Post 객체의 정보를 화면에 표시
            TextView titleTextView = findViewById(R.id.TitleText); // 제목
            TextView timeStampTextView = findViewById(R.id.timeStampText); // 작성시간
            TextView contentTextView = findViewById(R.id.ContentText); // 내용
            titleTextView.setText(post.getTitle());
            timeStampTextView.setText(post.getTimeStamp());
            contentTextView.setText(post.getContent());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                // 수정 버튼 클릭 시 처리
                // 수정할 데이터를 가지고 CreatePostActivity로 이동
                Intent editIntent = new Intent(PostActivity.this, CreatePostActivity.class);
                editIntent.putExtra("post", post);
                editIntent.putExtra("isEdit", true);
                startActivityForResult(editIntent, EDIT_POST_REQUEST);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("requestCode","Received requestCode: " + requestCode);

        if (requestCode == EDIT_POST_REQUEST && resultCode == RESULT_OK) {
            // 수정이 완료된 경우, 데이터 갱신
            post = (Post) data.getSerializableExtra("updatedPost");
            updatePostUI();
        }
    }


    private void updatePostUI() {
        // Post 객체의 정보를 화면에 표시
        TextView titleTextView = findViewById(R.id.TitleText); // 제목
        TextView timeStampTextView = findViewById(R.id.timeStampText); // 작성시간
        TextView contentTextView = findViewById(R.id.ContentText); // 내용
        titleTextView.setText(post.getTitle());
        timeStampTextView.setText(post.getTimeStamp());
        contentTextView.setText(post.getContent());
    }
}