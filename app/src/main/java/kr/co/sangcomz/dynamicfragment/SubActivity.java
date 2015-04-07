package kr.co.sangcomz.dynamicfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;


public class SubActivity extends ActionBarActivity {

    public static ViewPager mPager;					//뷰 페이저
//    private LinearLayout mPageMark;			//현재 몇 페이지 인지 나타내는 뷰
    private FragmentAdapter adapter;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        System.out.println("subActivity :::: " + b.getString("test"));
        System.out.println("MainActivity EditText :::: " + b.getString("et"));
        day =  Integer.valueOf(b.getString("et"));

        mPager = (ViewPager)findViewById(R.id.pager);						//뷰 페이저
        adapter = new FragmentAdapter(getSupportFragmentManager());

        new FragmentAsyncTask().execute();

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class FragmentAdapter extends FragmentStatePagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            f.setArguments(bundle);
            return f;

        }

        @Override
        public int getCount() { return day; }
    }
    //
    public class FragmentAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            mPager.setAdapter(adapter);
            return null;
        }
    }
}


