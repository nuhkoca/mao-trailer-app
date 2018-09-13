package com.movie.maotrailer.helper;

public final class Constants {

    public static final int RETRY_COUNT = 3;
    public static final int VIEW_PAGER_OFFSET_LIMIT = 3;
    public static final int INITIAL_LOAD_SIZE_HINT = 20;
    public static final int PREFETCH_DISTANCE = 20;
    public static final int PAGE_SIZE = 20;
    public static final int EXECUTOR_THREAD_POOL_OFFSET = 5;
    public static final int DEFAULT_COLUMN_WIDTH = 500;
    public static final String MAO_PREFEENCE_NAME = "mao-preference";
    public static final String PARCELABLE_RESULTS = "parcelable-results";
    public static final String TYPE_EXTRA = "type-extra";
    public static final String SHARED_ELEMENT_TRANSITION_KEY = "item-poster";
    public static final String DIRECTOR_PREFIX = "Director";
    public static final String SHARED_ELEMENT_TRANSITION_INTENT_KEY = "shared-element-transition-intent-key";
    public static final int DB_START_VERSION = 2;
    public static final int DB_END_VERSION = 3;
    public static final String MAO_DATABASE_NAME = "mao.db";

    public Constants() {
        throw new AssertionError();
    }
}
