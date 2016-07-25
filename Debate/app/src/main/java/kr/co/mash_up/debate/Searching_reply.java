package kr.co.mash_up.debate;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class Searching_reply extends AppCompatActivity implements MaterialTabListener{

    MaterialTabHost tabhost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;
    int start_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_reply);

        Intent intent = getIntent();
        start_position =intent.getIntExtra("tabposition",0);


        tabhost = (MaterialTabHost) this.findViewById(R.id.tabhost_reply);
        pager = (ViewPager) this.findViewById(R.id.pager_reply);
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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Writing_reply.class);
                startActivity(intent);

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


        tabhost.setSelectedNavigationItem(start_position);
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
                frag = new Reply_all();
            } else if (position == 1) {
                frag = new Reply_agree();
            } else if (position == 2) {
                frag = new Reply_degree();
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
                    return "전체";
                case 1:
                    return "찬성";
                case 2:
                    return "반대";
                default:
                    return null;
            }


        }
    }
}

/*
 MaterialTabHost tabhost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this,Writing.class);
                startActivity(intent);

            }
        });

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
                frag = new Home();
            } else if (position == 1) {
                frag = new Issue_debate();
            } else if (position == 2) {
                frag = new Debate_square();
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
                    return "홈";
                case 1:
                    return "이슈토론";
                case 2:
                    return "토론광장";
                default:
                    return null;
            }


        }
    }
 */