package cn.henryzhuhao.mainframe.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Author : zhuhao
 * Date : 16/8/2017
 *
 * @Last Modified Time :16/8/2017
 * Description :
 */

public class RxHelper {
    public static <T> ObservableTransformer<T, T> io_main() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io());
            }
        };
    }

//    public static <T> ObservableTransformer<T,T> bindToLifecycler(){
//        return new ObservableTransformer<T, T>() {
//            @Override
//            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
//                return observable.compose(RxLifecycle.bindUntilEvent(this,))
//            }
//        };
//    }
}
