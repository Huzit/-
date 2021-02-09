package com.example.recyclerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.util.ArrayList;

//리사이클러 뷰의 어댑터를 상속받으면서 제네릭으로 뷰홀더 클래스를 넣어준다. inner클래스로 생성했기 때문에 이꼬라지
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CostomViewHolder>{
    //뷰홀더 클래스
    public class CostomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView img_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CostomViewHolder(@NonNull View itemView) {

            super(itemView);
            this.img_profile = (ImageView) itemView.findViewById(R.id.img_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        }
    }

    private ArrayList<MainData> arrayList;
    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    //뷰홀더를 새로 만들어야 할 때 마다 이 함수를 호출, 뷰홀더와 연결된 뷰를 생성하고 초기화 하지만 데이터를 채우지 않는다.
    @NonNull
    @Override
    public MainAdapter.CostomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //xml -> layout 객체로 반환해준다.
        //from = 부모의 컨텍스트를 가져와서, inflate = 변환해준다    경로 / 루트 / 부모와의 접근성?
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CostomViewHolder holder = new CostomViewHolder(view);

        return holder;
    }

    //생성된 뷰 홀더에 데이터를 바인딩 할 때 이 함수를 호출.
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CostomViewHolder holder, int position) {
        //데이터 리스트에서 뷰 홀더로 데이터 이전
        holder.img_profile.setImageResource(arrayList.get(position).getImg_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        //뷰홀더 = itemView
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getLayoutPosition());
                return true;
            }
        });
    }

    //데이터 갯수 반
    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    //삭제하는 함수
    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }
}
