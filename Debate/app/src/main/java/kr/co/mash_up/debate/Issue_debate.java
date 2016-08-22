package kr.co.mash_up.debate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Issue_debate extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_issue_debate, container, false);

        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.home_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment

        List<Home_RV_Item> home_items = new ArrayList<>();
        Home_RV_Item[] home_item = new Home_RV_Item[4];
        home_item[0]= new Home_RV_Item("대태러방지법, 당신은 찬성?반대?","15","20");
        home_item[1]= new Home_RV_Item("브렉시트, 영국의 EU탈퇴 당신은?","15", "20");
        home_item[2]= new Home_RV_Item("대태러방지법, 당신은 찬성?반대?", "30","40");
        home_item[3]= new Home_RV_Item("대태러방지법, 당신은 찬성?반대?","12","24");

        for(int i=0; i<4;i++)  home_items.add( home_item[i]);


        HomeAdapter myadapter = new HomeAdapter(getActivity(), home_items);
        recyclerView.setAdapter(myadapter);


        return rootView;
    }

    public class HomeAdapter extends RecyclerView.Adapter<Home_VH>{

        private final Context context;
        private final List<Home_RV_Item> items;

        public HomeAdapter(Context context, List<Home_RV_Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public Home_VH onCreateViewHolder(ViewGroup parent, int viewType) {
            final View itemView = LayoutInflater.from(context).inflate(R.layout.viewholder_home_issue,parent,false);
            return new Home_VH(itemView);
        }

        @Override
        public void onBindViewHolder(Home_VH holder, int position) {
            final Home_RV_Item item = items.get(position);
            holder.content.setText(item.getContent());
            holder.agree_no.setText(item.getAgree_no());
            holder.degree_no.setText(item.getDegree_no());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Issue_content.class );

                    startActivity( intent );

                }
            });






        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }
    }


}
