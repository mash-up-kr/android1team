package kr.co.mash_up.debate;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MyPage extends AppCompatActivity implements MaterialTabListener{

    MaterialTabHost tabhost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;
    //CircleImageView
    ImageView user_image;
    TextView user_name;
    TextView user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        user_image = (ImageView)this.findViewById(R.id.user_image);
        user_name = (TextView)this.findViewById(R.id.user_name);
        user_email=(TextView)this.findViewById(R.id.user_email);
//putExtra로 넣어줄것.
        user_image.setImageResource(R.drawable.userimage);
        user_name.setText("Yang SoHyun");
        user_email.setText("didthgus1004@naver.com");

        tabhost = (MaterialTabHost) this.findViewById(R.id.tabhost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabhost.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabhost.setTextColor(Color.BLACK);
        tabhost.setPrimaryColor(Color.LTGRAY);
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            MaterialTab tab = tabhost.newTab();
            tab.setText(pagerAdapter.getPageTitle(i));
            tab.setTabListener(this);

            tabhost.addTab(tab);
        }


        tabhost.setSelectedNavigationItem(0);
    }

    @Override
    public void onTabSelected(MaterialTab tab) {

        pager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;
            if (position == 0) {
                frag = new MyDebate();
            } else if (position == 1) {
                frag = new MyReply();
            } else if (position == 2) {
                frag = new MyBookmark();
            }
            return frag;
        }


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "발제";
                case 1:
                    return "의견";
                case 2:
                    return "보관";
                default:
                    return null;
            }


        }
    }
}
