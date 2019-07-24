/**
 * Copyright (c) 2016-present, lovebing.org.
 * <p>
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package org.lovebing.reactnative.baidumap;

import android.os.Looper;
import android.support.annotation.MainThread;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import org.lovebing.reactnative.baidumap.module.GeolocationModule;
import org.lovebing.reactnative.baidumap.module.MapAppModule;
import org.lovebing.reactnative.baidumap.uimanager.MapViewManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayArcManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayCircleManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayMarkerManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayOverlayInfoWindowManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayPolygonManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayPolylineManager;
import org.lovebing.reactnative.baidumap.uimanager.OverlayTextManager;

import java.util.Arrays;
import java.util.List;


/**
 * Created by lovebing on 4/17/16.
 * 修改某个bug，你猜猜是哪一个
 */
public class BaiduMapPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.asList(
                new GeolocationModule(reactContext),
                new MapAppModule(reactContext)
        );
    }

    @Override
    public List<ViewManager> createViewManagers(
            ReactApplicationContext reactContext) {
        init(reactContext);
        return Arrays.asList(
                new MapViewManager(),
                new OverlayMarkerManager(),
                new OverlayOverlayInfoWindowManager(),
                new OverlayArcManager(),
                new OverlayCircleManager(),
                new OverlayPolygonManager(),
                new OverlayPolylineManager(),
                new OverlayTextManager()
        );
    }

    @MainThread
    protected void init(ReactApplicationContext reactContext) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        SDKInitializer.initialize(reactContext.getApplicationContext());
    }
}
