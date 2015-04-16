package kr.co.sangcomz.dynamicfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import github.chenupt.springindicator.SpringIndicator;


public class SubSubActivity extends ActionBarActivity {

    public static ViewPager mPager;					//뷰 페이저
    private FragmentAdapter adapter;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsub);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        day =  Integer.valueOf(b.getString("et"));


        mPager = (ViewPager)findViewById(R.id.pager);						//뷰 페이저
        adapter = new FragmentAdapter(getSupportFragmentManager());
        new FragmentAsyncTask().execute();
    }

    private class FragmentAdapter extends FragmentStatePagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            Fragment f = new TestFragment(); //생성
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            f.setArguments(bundle);
            return f;
        }
        @Override
        public int getCount() { return day; } //Fragment 수
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


