package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DetailPageTopBindingImpl extends DetailPageTopBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rbAverage, 6);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DetailPageTopBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private DetailPageTopBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[1]
            , (android.support.v7.widget.AppCompatRatingBar) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.ivPoster.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.tvAverage.setTag(null);
        this.tvGenre.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.genres) {
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
        else if (fieldId == BR.firstAirDate) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.overview) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        java.lang.String resultOverview = null;
        java.lang.String stringValueOfResultVoteAverage = null;
        java.util.List<java.lang.Integer> resultGenres = null;
        float resultVoteAverage = 0f;
        boolean resultReleaseDateJavaLangObjectNull = false;
        java.lang.String stringValueOfResultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate = null;
        java.lang.String resultFirstAirDate = null;
        java.lang.String resultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate = null;
        com.movie.maotrailer.data.remote.item.Results result = mResult;
        java.lang.String resultPosterPath = null;
        java.lang.String resultReleaseDate = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (result != null) {
                        // read result.overview
                        resultOverview = result.getOverview();
                    }
            }
            if ((dirtyFlags & 0x85L) != 0) {

                    if (result != null) {
                        // read result.genres
                        resultGenres = result.getGenres();
                    }
            }
            if ((dirtyFlags & 0x89L) != 0) {

                    if (result != null) {
                        // read result.voteAverage
                        resultVoteAverage = result.getVoteAverage();
                    }


                    // read String.valueOf(result.voteAverage)
                    stringValueOfResultVoteAverage = java.lang.String.valueOf(resultVoteAverage);
            }
            if ((dirtyFlags & 0x83L) != 0) {

                    if (result != null) {
                        // read result.posterPath
                        resultPosterPath = result.getPosterPath();
                    }
            }
            if ((dirtyFlags & 0xb1L) != 0) {

                    if (result != null) {
                        // read result.releaseDate
                        resultReleaseDate = result.getReleaseDate();
                    }


                    // read result.releaseDate == null
                    resultReleaseDateJavaLangObjectNull = (resultReleaseDate) == (null);
                if((dirtyFlags & 0xb1L) != 0) {
                    if(resultReleaseDateJavaLangObjectNull) {
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                    }
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x200L) != 0) {

                if (result != null) {
                    // read result.firstAirDate
                    resultFirstAirDate = result.getFirstAirDate();
                }
        }

        if ((dirtyFlags & 0xb1L) != 0) {

                // read result.releaseDate == null ? result.firstAirDate : result.releaseDate
                resultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate = ((resultReleaseDateJavaLangObjectNull) ? (resultFirstAirDate) : (resultReleaseDate));


                // read String.valueOf(result.releaseDate == null ? result.firstAirDate : result.releaseDate)
                stringValueOfResultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate = java.lang.String.valueOf(resultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate);
        }
        // batch finished
        if ((dirtyFlags & 0x83L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ImageBindingAdapter.bindImage(this.ivPoster, resultPosterPath);
        }
        if ((dirtyFlags & 0xb1L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, stringValueOfResultReleaseDateJavaLangObjectNullResultFirstAirDateResultReleaseDate);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.OverviewBindingAdapter.bindOverview(this.mboundView5, resultOverview);
        }
        if ((dirtyFlags & 0x89L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvAverage, stringValueOfResultVoteAverage);
        }
        if ((dirtyFlags & 0x85L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.GenreBindingAdapter.bindGenre(this.tvGenre, resultGenres);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): result
        flag 1 (0x2L): result.posterPath
        flag 2 (0x3L): result.genres
        flag 3 (0x4L): result.voteAverage
        flag 4 (0x5L): result.releaseDate
        flag 5 (0x6L): result.firstAirDate
        flag 6 (0x7L): result.overview
        flag 7 (0x8L): null
        flag 8 (0x9L): result.releaseDate == null ? result.firstAirDate : result.releaseDate
        flag 9 (0xaL): result.releaseDate == null ? result.firstAirDate : result.releaseDate
    flag mapping end*/
    //end
}