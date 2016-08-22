package kr.co.mash_up.debate;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Issue_content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_content);



       ViewPager viewpager = (ViewPager)findViewById(R.id.issue_content_viewpager);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.issue_content_indicator);
        viewpager.setAdapter(new mPageAdapter(getApplicationContext()));
        indicator.setViewPager(viewpager);

    }

    public class mPageAdapter extends PagerAdapter {


       // List<Home_RV_Item> items;
        private LayoutInflater mInflater;


       public mPageAdapter(Context c) {
           mInflater = LayoutInflater.from(c);
        }



        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        /*    Home_RV_Item data = items.get(position);

            Home_View view = new Home_View(getBaseContext());
            view.setData(data);
            container.addView(view);



            return view;
            */
            View v = null;
            if(position==0){
                v = mInflater.inflate(R.layout.issue_content1, null);
                TextView topic =(TextView)v.findViewById(R.id.topic);
                topic.setText("브렉시트, 영국의 EU 탈퇴 당신은?");
                TextView start_date =(TextView)v.findViewById(R.id.start_date);
                start_date.setText("YYYY.MM.DD");
                TextView end_date =(TextView)v.findViewById(R.id.end_date);
                end_date.setText("YYYY.MM.DD");

            }
            else if(position==1){
                v = mInflater.inflate(R.layout.issue_content2, null);
                TextView name =(TextView)v.findViewById(R.id.name);
                name.setText("브렉시트(Brexit)");
                TextView small_name =(TextView)v.findViewById(R.id.small_name);
                small_name.setText("Britain + Exit");
                TextView context_explain =(TextView)v.findViewById(R.id.context_explain);
                context_explain.setText("영국의 EU의 탈퇴\n2016. 06. 24부로 영국에서 브렉시트 투표 결과 52%의 찬성으로 영국의 EU탈퇴가 현실화가 되었는데요");
            }else{
                v = mInflater.inflate(R.layout.issue_content3, null);
                TextView topic =(TextView)v.findViewById(R.id.topic);
                topic.setText("브렉시트, 영국의 EU 탈퇴 당신은?");
                TextView start_date =(TextView)v.findViewById(R.id.start_date);
                start_date.setText("YYYY.MM.DD");
                TextView end_date =(TextView)v.findViewById(R.id.end_date);
                end_date.setText("YYYY.MM.DD");
                Button issue_agree_btn =(Button)v.findViewById(R.id.issue_agree_btn);
                issue_agree_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                        intent.putExtra("tabposition",1);

                        startActivity(intent);


                    }
                });
                Button issue_degree_btn =(Button)v.findViewById(R.id.issue_degree_btn);
                issue_degree_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                        intent.putExtra("tabposition",2);

                        startActivity(intent);

                    }
                });
                Button write_reply_btn =(Button)v.findViewById(R.id.write_reply_btn);
                write_reply_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(), Writing_reply.class);


                        startActivity(intent);


                    }
                });

                Button search_reply_btn = (Button)v.findViewById(R.id.search_reply_btn);
                search_reply_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                        intent.putExtra("tabposition",0);

                        startActivity(intent);

                    }
                });
            }

            container.addView(v);


            return v;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View)object);

        }

        @Override
        public int getCount() {
           // return items.size();

            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


    }


}
