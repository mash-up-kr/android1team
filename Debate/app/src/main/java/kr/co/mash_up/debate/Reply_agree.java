package kr.co.mash_up.debate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Reply_agree extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_reply_agree, container, false);

        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.reply_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment

        List<Reply_RV_Item> reply_items = new ArrayList<>();
        Reply_RV_Item[] reply_item = new Reply_RV_Item[4];

        for(int i=0; i<4; i++) {
            reply_item[i] = new Reply_RV_Item("발제자 ID", "YYYY.MM.DD", "대테러방지법은 실행되어야 합니다. " +
                    "왜냐하면 우리나라는 북한이나 IS의 테러로부터 결코 안전한 국가가 아니므로 " +
                    "신속하게 대책을 마련해야함에도 불구하고 아직까지 테러에 대한 정확한 개념이 없고 " +
                    "대응 체계가 다른 나라에 비해 현저히 부족하다는 생각입니다.", "75", "13", "45");

        }

        for(int i=0; i<4;i++)  reply_items.add( reply_item[i]);


        ReplyAdapter myadapter = new ReplyAdapter(getActivity(), reply_items);
        recyclerView.setAdapter(myadapter);


        return rootView;
    }

    public class ReplyAdapter extends RecyclerView.Adapter<Reply_VH>{

        private final Context context;
        private final List<Reply_RV_Item> items;

        public ReplyAdapter(Context context, List<Reply_RV_Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public Reply_VH onCreateViewHolder(ViewGroup parent, int viewType) {
            final View itemView = LayoutInflater.from(context).inflate(R.layout.viewholder_reply,parent,false);
            return new Reply_VH(itemView);
        }

        @Override
        public void onBindViewHolder(Reply_VH holder, int position) {
            final Reply_RV_Item item = items.get(position);
            holder.writer_id.setText(item.getWriter_id());
            holder.write_date.setText(item.getWrite_date());
            holder.content.setText(item.getContent());
            holder.agree_no.setText(item.getAgree_no());
            holder.degree_no.setText(item.getDegree_no());
            holder.reply_no.setText(item.getReply_no());



        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }
    }
}
