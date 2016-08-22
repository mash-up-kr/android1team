package kr.co.mash_up.debate;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class Home extends Fragment {






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.home_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment

        List<Home_RV_Item> home_items = new ArrayList<>();
        Home_RV_Item[] home_item = new Home_RV_Item[4];
        home_item[0]= new Home_RV_Item("절친이 보증서달라고 하면? 가능? 불가능?","15","20");
        home_item[1]= new Home_RV_Item("돈을 사랑으로 살 수 있다? 없다?","15", "20");
        home_item[2]= new Home_RV_Item("돈을 사랑으로 살 수 있다? 없다?", "30","40");
        home_item[3]= new Home_RV_Item("돈을 사랑으로 살 수 있다? 없다?","12","24");

        for(int i=0; i<4;i++)  home_items.add( home_item[i]);


        HomeAdapter myadapter = new HomeAdapter(getActivity(), home_items);
        recyclerView.setAdapter(myadapter);

        ViewPager viewpager = (ViewPager) rootView.findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        viewpager.setAdapter(new mPageAdapter(home_items));
        viewpager.setBackgroundColor(Color.parseColor("#303030"));

        indicator.setViewPager(viewpager);




        return rootView;
    }



    public class mPageAdapter extends PagerAdapter {


        List<Home_RV_Item> items;

        public mPageAdapter(List<Home_RV_Item> items) {
            this.items = items;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Home_RV_Item data = items.get(position);

            Home_View_Issue view = new Home_View_Issue(getContext());
            view.setData(data);
            container.addView(view);



            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View)object);

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


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
            final View itemView = LayoutInflater.from(context).inflate(R.layout.viewholder_home,parent,false);
            return new Home_VH(itemView);
        }

        @Override
        public void onBindViewHolder(Home_VH holder, int position) {
            final Home_RV_Item item = items.get(position);
            holder.content.setText(item.getContent());
            holder.agree_no.setText(item.getAgree_no());
            holder.degree_no.setText(item.getDegree_no());





        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }
    }





}




