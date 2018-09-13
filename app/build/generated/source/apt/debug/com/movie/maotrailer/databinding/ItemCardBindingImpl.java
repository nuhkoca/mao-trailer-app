package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCardBindingImpl extends ItemCardBinding implements com.movie.maotrailer.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView1;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCardBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemCardBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.support.v7.widget.CardView) bindings[0]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.cvMain.setTag(null);
        this.ivPoster.setTag(null);
        this.mboundView1 = (android.support.constraint.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.tvDate.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.movie.maotrailer.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
        if (BR.result == variableId) {
            setResult((com.movie.maotrailer.data.remote.item.Results) variable);
        }
        else if (BR.itemClickListener == variableId) {
            setItemClickListener((com.movie.maotrailer.callback.IItemClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResult(@Nullable com.movie.maotrailer.data.remote.item.Results Result) {
        updateRegistration(0, Result);
        this.mResult = Result;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.result);
        super.requestRebind();
    }
    public void setItemClickListener(@Nullable com.movie.maotrailer.callback.IItemClickListener ItemClickListener) {
        this.mItemClickListener = ItemClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.itemClickListener);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeResult((com.movie.maotrailer.data.remote.item.Results) object, fieldId);
        }
        return false;
    }
    private boolean onChangeResult(com.movie.maotrailer.data.remote.item.Results Result, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.posterPath) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.voteAverage) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.releaseDate) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.firstAirData) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.title) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
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
        float resultVoteAverage = 0f;
        java.lang.String resultTitle = null;
        boolean resultReleaseDateJavaLangObjectNull = false;
        java.lang.String resultFirstAirData = null;
        java.lang.String resultTitleJavaLangObjectNullResultNameResultTitle = null;
        java.lang.String resultReleaseDateJavaLangObjectNullResultFirstAirDataResultReleaseDate = null;
        com.movie.maotrailer.data.remote.item.Results result = mResult;
        java.lang.String resultName = null;
        java.lang.String resultPosterPath = null;
        java.lang.String resultReleaseDate = null;
        com.movie.maotrailer.callback.IItemClickListener itemClickListener = mItemClickListener;

        if ((dirtyFlags & 0x1fdL) != 0) {


            if ((dirtyFlags & 0x109L) != 0) {

                    if (result != null) {
                        // read result.voteAverage
                        resultVoteAverage = result.getVoteAverage();
                    }
            }
            if ((dirtyFlags & 0x1c1L) != 0) {

                    if (result != null) {
                        // read result.title
                        resultTitle = result.getTitle();
                    }


                    // read result.title == null
                    resultTitleJavaLangObjectNull = (resultTitle) == (null);
                if((dirtyFlags & 0x1c1L) != 0) {
                    if(resultTitleJavaLangObjectNull) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }
            }
            if ((dirtyFlags & 0x105L) != 0) {

                    if (result != null) {
                        // read result.posterPath
                        resultPosterPath = result.getPosterPath();
                    }
            }
            if ((dirtyFlags & 0x131L) != 0) {

                    if (result != null) {
                        // read result.releaseDate
                        resultReleaseDate = result.getReleaseDate();
                    }


                    // read result.releaseDate == null
                    resultReleaseDateJavaLangObjectNull = (resultReleaseDate) == (null);
                if((dirtyFlags & 0x131L) != 0) {
                    if(resultReleaseDateJavaLangObjectNull) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x1000L) != 0) {

                if (result != null) {
                    // read result.firstAirData
                    resultFirstAirData = result.getFirstAirData();
                }
        }
        if ((dirtyFlags & 0x400L) != 0) {

                if (result != null) {
                    // read result.name
                    resultName = result.getName();
                }
        }

        if ((dirtyFlags & 0x1c1L) != 0) {

                // read result.title == null ? result.name : result.title
                resultTitleJavaLangObjectNullResultNameResultTitle = ((resultTitleJavaLangObjectNull) ? (resultName) : (resultTitle));
        }
        if ((dirtyFlags & 0x131L) != 0) {

                // read result.releaseDate == null ? result.firstAirData : result.releaseDate
                resultReleaseDateJavaLangObjectNullResultFirstAirDataResultReleaseDate = ((resultReleaseDateJavaLangObjectNull) ? (resultFirstAirData) : (resultReleaseDate));
        }
        // batch finished
        if ((dirtyFlags & 0x105L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ImageBindingAdapter.bindImage(this.ivPoster, resultPosterPath, cvMain);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x109L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.RatingBindingAdapter.bindRating(this.mboundView3, resultVoteAverage);
        }
        if ((dirtyFlags & 0x1c1L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, resultTitleJavaLangObjectNullResultNameResultTitle);
        }
        if ((dirtyFlags & 0x131L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ReleaseDateBindingAdapter.bindReleaseDate(this.tvDate, resultReleaseDateJavaLangObjectNullResultFirstAirDataResultReleaseDate);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // result
        com.movie.maotrailer.data.remote.item.Results result = mResult;
        // itemClickListener
        com.movie.maotrailer.callback.IItemClickListener itemClickListener = mItemClickListener;
        // itemClickListener != null
        boolean itemClickListenerJavaLangObjectNull = false;



        itemClickListenerJavaLangObjectNull = (itemClickListener) != (null);
        if (itemClickListenerJavaLangObjectNull) {




            itemClickListener.onItemClick(result, ivPoster);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): result
        flag 1 (0x2L): itemClickListener
        flag 2 (0x3L): result.posterPath
        flag 3 (0x4L): result.voteAverage
        flag 4 (0x5L): result.releaseDate
        flag 5 (0x6L): result.firstAirData
        flag 6 (0x7L): result.title
        flag 7 (0x8L): result.name
        flag 8 (0x9L): null
        flag 9 (0xaL): result.title == null ? result.name : result.title
        flag 10 (0xbL): result.title == null ? result.name : result.title
        flag 11 (0xcL): result.releaseDate == null ? result.firstAirData : result.releaseDate
        flag 12 (0xdL): result.releaseDate == null ? result.firstAirData : result.releaseDate
    flag mapping end*/
    //end
}