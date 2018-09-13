package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.movie.maotrailer.DataBinderMapperImpl());
    addMapper(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
  }
}
