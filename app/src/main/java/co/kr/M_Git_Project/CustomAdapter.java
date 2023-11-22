package co.kr.M_Git_Project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    // RecyclerView와 함께 사용하기 위한 Adapter 클래스
    // RecyclerView에 데이터를 연결하고 아이템의 뷰를 생성하는 역할을 함

    private ArrayList<Post> localDataSet;
    private Context context;

    //===== Click 이벤트 구현을 위해 추가된 코드 ==========================
    // OnItemClickListener 인터페이스 선언
    public interface OnItemClickListener {
        void onItemClicked(int position, Post post);
    }

    // OnItemClickListener 참조 변수 선언
    private OnItemClickListener itemClickListener;

    // 생성자를 통해서 데이터를 전달받도록 함
    public CustomAdapter(Context context, ArrayList<Post> dataSet) {
        this.context = context;
        localDataSet = dataSet;
    }
    //---------------------------------------------------------------------

    // OnItemClickListener 전달 메소드
    public void setOnItemClickListener (OnItemClickListener listener) {
        itemClickListener = listener;
    }
    //======================================================================


    //----- 뷰홀더 클래스 ---------------------------------------------------
    //  각 아이템을 보유하고 있는 뷰로, ViewHolder 클래스는 아이템의 뷰 요소들을 저장함
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(Post post, OnItemClickListener listener) {
            textView.setText(post.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClicked(position, post);
                    }
                }
            });
        }
    }
    //---------------------------------------------------------------------

    //----- RecyclerView Adapter 필수 구현 항목 ----------------------------
    @NonNull
    @Override   // ViewHolder 객체를 생성하여 리턴한다.
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // onBindViewHolder() 메서드 수정
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = localDataSet.get(position);
        holder.bind(post, itemClickListener);
    } // 뷰 요소 설정

    @Override   // 전체 데이터의 갯수를 리턴한다.
    public int getItemCount() {
        return localDataSet.size();
    }
    //-----------------------------------------------------------------------
}