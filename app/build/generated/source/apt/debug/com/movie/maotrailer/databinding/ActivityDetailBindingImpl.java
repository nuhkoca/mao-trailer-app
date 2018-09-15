package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDetailBindingImpl extends ActivityDetailBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(3, 
            new String[] {"detail_page_top"},
            new int[] {4},
            new int[] {R.layout.detail_page_top});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.aplDetail, 5);
        sViewsWithIds.put(R.id.ibPlay, 6);
        sViewsWithIds.put(R.id.toolbarDetail, 7);
        sViewsWithIds.put(R.id.nsvDetail, 8);
        sViewsWithIds.put(R.id.tvCastCrewHeader, 9);
        sViewsWithIds.put(R.id.cvCastCrew, 10);
        sViewsWithIds.put(R.id.rvCast, 11);
        sViewsWithIds.put(R.id.pbCastCrew, 12);
    }
    // views
    @NonNull
    private final android.widget.ImageView mboundView2;
    @NonNull
    private final android.support.v7.widget.CardView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDetailBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityDetailBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.support.design.widget.AppBarLayout) bindings[5]
            , (android.support.design.widget.CoordinatorLayout) bindings[0]
            , (android.support.design.widget.CollapsingToolbarLayout) bindings[1]
            , (android.support.v7.widget.CardView) bindings[10]
            , (android.widget.ImageButton) bindings[6]
            , (com.movie.maotrailer.databinding.DetailPageTopBinding) bindings[4]
            , (android.support.v4.widget.NestedScrollView) bindings[8]
            , (android.widget.ProgressBar) bindings[12]
            , (android.support.v7.widget.RecyclerView) bindings[11]
            , (android.support.v7.widget.Toolbar) bindings[7]
            , (android.widget.TextView) bindings[9]
            );
        this.clDetail.setTag(null);
        this.ctlDetail.setTag(null);
        this.mboundView2 = (android.widget.ImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.support.v7.widget.CardView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        lDetailPageTop.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (lDetailPageTop.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.result == variableId) {
            setResult((com.movie.maotrailer.data.remote.item.Results) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResult(@Nullable com.movie.maotrailer.data.remote.item.Results Result) {
        updateRegistration(1, Result);
        this.mResult = Result;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.result);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        lDetailPageTop.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLDetailPageTop((com.movie.maotrailer.databinding.DetailPageTopBinding) object, fieldId);
            case 1 :
                return onChangeResult((com.movie.maotrailer.data.remote.item.Results) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLDetailPageTop(com.movie.maotrailer.databinding.DetailPageTopBinding LDetailPageTop, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResult(com.movie.maotrailer.data.remote.item.Results Result, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.title) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.backdropPath) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
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
        boolean resultTitleJavaLangObjectNull = false;
        java.lang.String resultTitle = null;
        java.lang.String resultTitleJavaLangObjectNullResultNameResultTitle = null;
        java.lang.String resultBackdropPath = null;
        com.movie.maotrailer.data.remote.item.Results result = mResult;
        java.lang.String resultName = null;

        if ((dirtyFlags & 0x3eL) != 0) {


            if ((dirtyFlags & 0x2eL) != 0) {

                    if (result != null) {
                        // read result.title
                        resultTitle = result.getTitle();
                    }


                    // read result.title == null
                    resultTitleJavaLangObjectNull = (resultTitle) == (null);
                if((dirtyFlags & 0x2eL) != 0) {
                    if(resultTitleJavaLangObjectNull) {
                            dirtyFlags |= 0x80L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                    }
                }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (result != null) {
                        // read result.backdropPath
                        resultBackdropPath = result.getBackdropPath();
                    }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x80L) != 0) {

                if (result != null) {
                    // read result.name
                    resultName = result.getName();
                }
        }

        if ((dirtyFlags & 0x2eL) != 0) {

                // read result.title == null ? result.name : result.title
                resultTitleJavaLangObjectNullResultNameResultTitle = ((resultTitleJavaLangObjectNull) ? (resultName) : (resultTitle));
        }
        // batch finished
        if ((dirtyFlags & 0x2eL) != 0) {
            // api target 1

            this.ctlDetail.setTitle(resultTitleJavaLangObjectNullResultNameResultTitle);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ImageBindingAdapter.bindImage(this.mboundView2, resultBackdropPath);
        }
        executeBindingsOn(lDetailPageTop);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): lDetailPageTop
        flag 1 (0x2L): result
        flag 2 (0x3L): result.title
        flag 3 (0x4L): result.name
        flag 4 (0x5L): result.backdropPath
        flag 5 (0x6L): null
        flag 6 (0x7L): result.title == null ? result.name : result.title
        flag 7 (0x8L): result.title == null ? result.name : result.title
    flag mapping end*/
    //end
}