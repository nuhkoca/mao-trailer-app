package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FavoriteItemCardBindingImpl extends FavoriteItemCardBinding implements com.movie.maotrailer.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.vBg, 6);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FavoriteItemCardBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FavoriteItemCardBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.v7.widget.CardView) bindings[0]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.view.View) bindings[6]
            );
        this.cvMain.setTag(null);
        this.ivMore.setTag(null);
        this.ivPoster.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.tvDate.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.movie.maotrailer.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.favorite == variableId) {
            setFavorite((com.movie.maotrailer.data.local.entity.FavoriteThings) variable);
        }
        else if (BR.popupClickListener == variableId) {
            setPopupClickListener((com.movie.maotrailer.callback.IPopupMenuItemClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFavorite(@Nullable com.movie.maotrailer.data.local.entity.FavoriteThings Favorite) {
        this.mFavorite = Favorite;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.favorite);
        super.requestRebind();
    }
    public void setPopupClickListener(@Nullable com.movie.maotrailer.callback.IPopupMenuItemClickListener PopupClickListener) {
        this.mPopupClickListener = PopupClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.popupClickListener);
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
        float favoriteVote = 0f;
        com.movie.maotrailer.data.local.entity.FavoriteThings favorite = mFavorite;
        java.lang.String favoriteYear = null;
        java.lang.String favoriteName = null;
        java.lang.String favoritePoster = null;
        com.movie.maotrailer.callback.IPopupMenuItemClickListener popupClickListener = mPopupClickListener;

        if ((dirtyFlags & 0x5L) != 0) {



                if (favorite != null) {
                    // read favorite.vote
                    favoriteVote = favorite.getVote();
                    // read favorite.year
                    favoriteYear = favorite.getYear();
                    // read favorite.name
                    favoriteName = favorite.getName();
                    // read favorite.poster
                    favoritePoster = favorite.getPoster();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivMore.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ImageBindingAdapter.bindImage(this.ivPoster, favoritePoster, cvMain);
            com.movie.maotrailer.binding.RatingBindingAdapter.bindRating(this.mboundView2, favoriteVote);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, favoriteName);
            com.movie.maotrailer.binding.ReleaseDateBindingAdapter.bindReleaseDate(this.tvDate, favoriteYear);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // popupClickListener != null
        boolean popupClickListenerJavaLangObjectNull = false;
        // favorite
        com.movie.maotrailer.data.local.entity.FavoriteThings favorite = mFavorite;
        // popupClickListener
        com.movie.maotrailer.callback.IPopupMenuItemClickListener popupClickListener = mPopupClickListener;



        popupClickListenerJavaLangObjectNull = (popupClickListener) != (null);
        if (popupClickListenerJavaLangObjectNull) {




            popupClickListener.onPopupMenuItemClick(favorite, ivMore);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): favorite
        flag 1 (0x2L): popupClickListener
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}