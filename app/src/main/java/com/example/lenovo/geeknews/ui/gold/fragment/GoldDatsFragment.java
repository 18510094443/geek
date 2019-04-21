package com.example.lenovo.geeknews.ui.gold.fragment;


import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.app.Constants;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldDatsFragment extends BaseFragment {


    @BindView(R.id.tv)
    TextView tv;
    Unbinder unbinder;

    public static GoldDatsFragment newInstance(String text) {
        GoldDatsFragment goldDetailsFragment = new GoldDatsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SyncStateContract.Constants.DATA, text);
        goldDetailsFragment.setArguments(bundle);
        return goldDetailsFragment;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        Bundle arguments = getArguments();
        String data = arguments.getString(Constants.DATA);
        tv.setText(data);
    }

    @Override
    protected BasePresenter createpresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_gold_dats;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
