package com.tyagiabhinav.mvprxapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.tyagiabhinav.mvprxapp.model.DataSource;
import com.tyagiabhinav.mvprxapp.model.LoaderProvider;
import com.tyagiabhinav.mvprxapp.model.MockCursorProvider;
import com.tyagiabhinav.mvprxapp.model.RestaurantSource;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainContract;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.MainPresenter;
import com.tyagiabhinav.mvprxapp.view.ui.MainScreen.SortOrder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RestaurantListUnitTest {

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor
    private ArgumentCaptor<Cursor> mShowRestaurantsArgumentCaptor;

    @Mock
    private LoaderProvider mLoaderProvider;

    @Mock
    private MainContract.View mRestaurantView;

    @Mock
    private RestaurantSource mRestaurantSource;

    @Mock
    private LoaderManager mLoaderManager;

    @Mock
    private DataSource.GetRestaurantList mGetRestaurantListCallback;

    @Mock
    private Bundle mBundle;


    private MockCursorProvider.RestaurantMockCursor mRestaurantCursor;
    private MainPresenter mMainPresenter;

    @Captor
    private ArgumentCaptor<DataSource.GetRestaurantList> getRestaurantsListCallbackArgumentCaptor;

    @Before
    public void setupTasksPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        when(mBundle.getSerializable(MainPresenter.SORT_KEY)).thenReturn(SortOrder.DEFAULT);


        // Get mock cursor
        mRestaurantCursor = MockCursorProvider.createRestaurantsCursor();

        // Get a reference to the class under test
        mMainPresenter = new MainPresenter(mRestaurantView, mLoaderProvider, mLoaderManager, mRestaurantSource);

    }

    @Test
    public void loadRestaurantsFromRepositoryAndShowOnView() {

        // When the loader finishes with tasks and filter is set to all
        when(mBundle.getSerializable(MainPresenter.SORT_KEY)).thenReturn(SortOrder.DEFAULT);

        mMainPresenter.onLoadFinished(mock(Loader.class), mRestaurantCursor);

        verify(mRestaurantView).updateView(mRestaurantCursor);
    }
}