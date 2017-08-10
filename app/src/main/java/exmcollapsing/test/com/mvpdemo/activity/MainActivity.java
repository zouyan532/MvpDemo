package exmcollapsing.test.com.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import exmcollapsing.test.com.mvpdemo.MVP.day.contract.DayContract;
import exmcollapsing.test.com.mvpdemo.MVP.day.presenter.DayPresenter;
import exmcollapsing.test.com.mvpdemo.R;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;

public class MainActivity extends AppCompatActivity implements DayContract.View, View.OnClickListener {
    @BindView(R.id.tv_holiday)
    TextView tv_holiday;
    @BindView(R.id.tv_lunarYear)
    TextView tv_lunarYear;
    @BindView(R.id.tv_animalsyear)
    TextView tv_animalsyear;
    @BindView(R.id.tv_suit)
    TextView tv_suit;
    @BindView(R.id.btn_getDayInfo)
    Button btn_getDayInfo;
    private DayPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new DayPresenter(this);
        presenter.attachView(this);
        btn_getDayInfo.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }




    @Override
    public void showError(int errorCode) {

    }

    @Override
    public void showEmpty(String msg) {

    }

    @Override
    public void setDayInfo(DayResponse.ResultBean.DataBean dayInfo) {
        tv_animalsyear.setText(dayInfo.getAnimalsYear());
        tv_holiday.setText(dayInfo.getHoliday());
        tv_lunarYear.setText(dayInfo.getLunarYear());
        tv_suit.setText(dayInfo.getSuit());
    }

    @Override
    public void onClick(View view) {
        presenter.getDayInfo("2017-8-10");
    }
}
