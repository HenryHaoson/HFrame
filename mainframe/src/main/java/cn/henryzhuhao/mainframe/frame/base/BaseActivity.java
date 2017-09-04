package cn.henryzhuhao.mainframe.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import cn.henryzhuhao.mainframe.frame.base.action.BaseAction;

/**
 * Created by HenryZhuhao on 2017/3/29.
 */

public abstract class BaseActivity extends RxAppCompatActivity implements BaseAction {
    public static int REQUEST_CODE_PERMISSION=2;
    //private int rootView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootViewId());
        init(savedInstanceState);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        initView();
        initData(savedInstanceState);
        initListener();
    }

}
