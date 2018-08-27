package cn.com.chinwe.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.dedian_of_two_sorted_arrays)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dedian_of_two_sorted_arrays:
                //两个排序数组中位数

                break;
        }
    }
}
