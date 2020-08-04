package com.sample.jetpack.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import org.greenrobot.eventbus.EventBus;

/**
 * @author shuxq
 * @date 2020/5/21.
 * description:
 */
public class EventBusLifecycle implements DefaultLifecycleObserver {

    private static final EventBusLifecycle BUS_LIFECYCLE = new EventBusLifecycle();

    public static EventBusLifecycle getInstance() {
        return BUS_LIFECYCLE;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        EventBus.getDefault().register(owner);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        if (EventBus.getDefault().isRegistered(owner)) {
            EventBus.getDefault().unregister(owner);
        }
    }
}
