package kr.co.mash_up.debate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends AppCompatActivity implements MaterialTabListener {

    MaterialTabHost tabhost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this,Writing.class);
                startActivity(intent);

            }
        });

        fab.hide();

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

        switch (item.getItemId()) {

            case R.id.action_search:


                return true;

            case R.id.my_page:

                Intent intent = new Intent(MainActivity.this,MyPage.class);
                startActivity(intent);

                return true;

            case R.id.action_add:

                Intent intent2 = new Intent(MainActivity.this,Writing.class);
                startActivity(intent2);

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }





    }

    @Override
    public void onTabSelected(MaterialTab tab) {

        pager.setCurrentItem(tab.getPosition());

        if(tab.getPosition()!=2){
            fab.hide();
        }else{
            fab.show();
        }


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
}
