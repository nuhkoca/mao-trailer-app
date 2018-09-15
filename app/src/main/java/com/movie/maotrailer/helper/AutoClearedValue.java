package com.movie.maotrailer.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.android.support.DaggerFragment;

/**
 * A value holder that automatically clears the reference if the Fragment's view is destroyed.
 * @param <T>
 */

public class AutoClearedValue<T> {
    private T value;
    public AutoClearedValue(DaggerFragment fragment, T value) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.registerFragmentLifecycleCallbacks(
                    new FragmentManager.FragmentLifecycleCallbacks() {
                        @Override
                        public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
                            if (f == fragment) {
                                AutoClearedValue.this.value = null;
                                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                            }
                        }
                    }, false);
        }

        this.value = value;
    }

    public T get() {
        return value;
    }
}
