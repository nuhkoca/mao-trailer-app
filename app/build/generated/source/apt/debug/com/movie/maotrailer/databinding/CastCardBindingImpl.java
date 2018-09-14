package com.movie.maotrailer.databinding;
import com.movie.maotrailer.R;
import com.movie.maotrailer.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CastCardBindingImpl extends CastCardBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CastCardBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private CastCardBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.constraint.ConstraintLayout) bindings[0]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.clCastCrew.setTag(null);
        this.ivCastPoster.setTag(null);
        this.tvCastName.setTag(null);
        this.tvCrewJob.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.profileImage == variableId) {
            setProfileImage((java.lang.String) variable);
        }
        else if (BR.castName == variableId) {
            setCastName((java.lang.String) variable);
        }
        else if (BR.crewJob == variableId) {
            setCrewJob((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProfileImage(@Nullable java.lang.String ProfileImage) {
        this.mProfileImage = ProfileImage;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.profileImage);
        super.requestRebind();
    }
    public void setCastName(@Nullable java.lang.String CastName) {
        this.mCastName = CastName;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.castName);
        super.requestRebind();
    }
    public void setCrewJob(@Nullable java.lang.String CrewJob) {
        this.mCrewJob = CrewJob;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.crewJob);
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
        java.lang.String profileImage = mProfileImage;
        int castNameLength = 0;
        java.lang.String castName = mCastName;
        boolean castNameLengthInt0 = false;
        java.lang.String crewJob = mCrewJob;
        int castNameLengthInt0ViewGONEViewVISIBLE = 0;

        if ((dirtyFlags & 0x9L) != 0) {
        }
        if ((dirtyFlags & 0xaL) != 0) {



                if (castName != null) {
                    // read castName.length
                    castNameLength = castName.length();
                }


                // read castName.length == 0
                castNameLengthInt0 = (castNameLength) == (0);
            if((dirtyFlags & 0xaL) != 0) {
                if(castNameLengthInt0) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read castName.length == 0 ? View.GONE : View.VISIBLE
                castNameLengthInt0ViewGONEViewVISIBLE = ((castNameLengthInt0) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0xcL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.clCastCrew.setVisibility(castNameLengthInt0ViewGONEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCastName, castName);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.movie.maotrailer.binding.ImageBindingAdapter.bindImage(this.ivCastPoster, profileImage);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCrewJob, crewJob);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): profileImage
        flag 1 (0x2L): castName
        flag 2 (0x3L): crewJob
        flag 3 (0x4L): null
        flag 4 (0x5L): castName.length == 0 ? View.GONE : View.VISIBLE
        flag 5 (0x6L): castName.length == 0 ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}