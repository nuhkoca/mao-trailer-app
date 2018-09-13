package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NetworkStateItemBindingImpl extends NetworkStateItemBinding implements com.movie.maotrailer.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pbNetwork, 2);
        sViewsWithIds.put(R.id.tvNetworkErr, 3);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NetworkStateItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private NetworkStateItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.constraint.ConstraintLayout) bindings[0]
            , (android.widget.ProgressBar) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            );
        this.clNetwork.setTag(null);
        this.tvNetworkErrButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.movie.maotrailer.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.retryListener == variableId) {
            setRetryListener((com.movie.maotrailer.callback.IRetryListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRetryListener(@Nullable com.movie.maotrailer.callback.IRetryListener RetryListener) {
        this.mRetryListener = RetryListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.retryListener);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.movie.maotrailer.callback.IRetryListener retryListener = mRetryListener;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.tvNetworkErrButton.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // retryListener
        com.movie.maotrailer.callback.IRetryListener retryListener = mRetryListener;
        // retryListener != null
        boolean retryListenerJavaLangObjectNull = false;



        retryListenerJavaLangObjectNull = (retryListener) != (null);
        if (retryListenerJavaLangObjectNull) {


            retryListener.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): retryListener
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}