package com.zhuhao.hframe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhuhao.hframe.ResponseEntity.LoginEntity;

import cn.henryzhuhao.mainframe.frame.base.BaseActivity;
import cn.henryzhuhao.mainframe.net.ApiFactory;
import cn.henryzhuhao.mainframe.net.BaseResponse;
import cn.henryzhuhao.mainframe.net.RxHelper;
import cn.henryzhuhao.mainframe.net.RxSubscriber;

public class MainActivity extends BaseActivity {
    private EditText userName;
    private EditText password;
    private Button commit;

    @Override
    public void initView() {
        userName= (EditText) findViewById(R.id.test_username);
        password= (EditText) findViewById(R.id.test_password);
        commit= (Button) findViewById(R.id.test_commit);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameText=userName.getText().toString();
                String passwordText=password.getText().toString();
                login(userNameText,passwordText);
            }
        });
    }

    public void login(String userName, String passowrd){
        ShanbayApi api=ApiFactory.newInstance().createApi(ShanbayApi.class);
        api.login(userName,passowrd)
                .compose(RxHelper.<BaseResponse<LoginEntity>>io_main())
                .subscribe(new RxSubscriber<LoginEntity>() {
                    @Override
                    public void onSuccess(LoginEntity Data) {
                        Toast.makeText(getApplicationContext(),"userId"+Data.getUserId(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(String msg) {

                    }

                    @Override
                    public void onError(LoginEntity EData) {

                    }
                });
    }

    @Override
    public void showLoadingContentView() {

    }

    @Override
    public void removeLoadingContentView() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

}
