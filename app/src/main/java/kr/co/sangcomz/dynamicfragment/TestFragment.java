package kr.co.sangcomz.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 석원 on 3/28/2015.
 */
public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_layout, container, false);
        Bundle extra = getArguments();
        int a = extra.getInt("position");
        TextView tv = (TextView)rootView.findViewById(R.id.tv);
        tv.setText(a + 1 + "번째 Fragment");
        return rootView;
    }
}
