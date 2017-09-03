package cn.henryzhuhao.mainframe.net;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author : zhuhao
 * Date : 3/9/2017
 *
 * @Last Modified Time :3/9/2017
 * Description :
 */

public abstract class RxSubscriber<T> implements Observer<BaseResponse<T>> {
    static final int SUCCESS_CODE = 200;

    String msg;

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof UnknownHostException) {
            msg = "没有网络...";
        } else if (e instanceof SocketTimeoutException) {
            // 超时
            msg = "超时...";
        } else {
            msg = "请求失败，请稍后重试...";
        }
        onFailed(msg);
    }

    @Override
    public void onNext(BaseResponse<T> sBaseResponse) {
        if (sBaseResponse.getCode() == SUCCESS_CODE) {
            onSuccess(sBaseResponse.getData());
        } else {
            onError(sBaseResponse.getData());
        }
    }

    public abstract void onSuccess(T Data);

    /**
     * 服务器错误
     */
    public abstract void onFailed(String msg);

    /**
     * 正常错误
     *
     * @param EData
     */
    public abstract void onError(T EData);
}
