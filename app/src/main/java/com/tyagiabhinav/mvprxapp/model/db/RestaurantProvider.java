package com.tyagiabhinav.mvprxapp.model.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by abhinavtyagi on 05/01/17.
 */

public class RestaurantProvider extends ContentProvider {
    private static final String LOG_TAG = RestaurantProvider.class.getSimpleName();

    private DatabaseHelper mOpenHelper;
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    static final int RESTAURANTS_LIST = 100;
    static final int RESTAURANT = 101;
    static final int RESTAURANTS_VISITED_LIST = 200;
    static final int RESTAURANT_VISITED = 201;

//    private static final SQLiteQueryBuilder sUserQueryBuilder, sInvitationQueryBuilder;

//    static {
//        sUserQueryBuilder = new SQLiteQueryBuilder();
//
//        /// JOIN query for favorite movies...
//        // SELECT * FROM user INNER JOIN invite ON invite.invitee = user.email;
//        sUserQueryBuilder.setTables(
//                DBContract.UserEntry.TABLE_NAME + " INNER JOIN " +
//                        DBContract.InviteEntry.TABLE_NAME +
//                        " ON " + DBContract.UserEntry.TABLE_NAME +
//                        "." + DBContract.UserEntry.COL_USER_EMAIL +
//                        " = " + DBContract.InviteEntry.TABLE_NAME +
//                        "." + DBContract.InviteEntry.COL_INVITEE);
//    }
//
//    static {
//        sInvitationQueryBuilder = new SQLiteQueryBuilder();
//
//        /// JOIN query for favorite movies...
//        // SELECT * FROM invite, user WHERE invite.invitee = user.email;
//        sUserQueryBuilder.setTables(
//                DBContract.UserEntry.TABLE_NAME + " INNER JOIN " +
//                        DBContract.InviteEntry.TABLE_NAME +
//                        " ON " + DBContract.UserEntry.TABLE_NAME +
//                        "." + DBContract.UserEntry.COL_USER_EMAIL +
//                        " = " + DBContract.InviteEntry.TABLE_NAME +
//                        "." + DBContract.InviteEntry.COL_INVITEE);
//    }

    static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DatabaseContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.
        matcher.addURI(authority, DatabaseContract.TABLE_RESTAURANTS, RESTAURANTS_LIST);
        matcher.addURI(authority, DatabaseContract.TABLE_RESTAURANTS + "/*", RESTAURANT);
        matcher.addURI(authority, DatabaseContract.TABLE_RESTAURANTS_VISITED, RESTAURANTS_VISITED_LIST);
        matcher.addURI(authority, DatabaseContract.TABLE_RESTAURANTS_VISITED + "/*", RESTAURANT_VISITED);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.d(LOG_TAG, "query -->" + uri);
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            // "restaurants/*"
            case RESTAURANT:
                Log.d(LOG_TAG, "...restaurants/*");
                String restaurantId = DatabaseContract.TableRestaurants.getRestaurantIdFromUri(uri);
                retCursor = mOpenHelper.getReadableDatabase().query(
                        DatabaseContract.TABLE_RESTAURANTS + ", " + DatabaseContract.TABLE_RESTAURANTS_VISITED,
                        projection,
                        selection,
                        new String[]{restaurantId},
                        null,
                        null,
                        sortOrder
                );
                break;
            // "restaurants"
            case RESTAURANTS_LIST:
                Log.d(LOG_TAG, "...restaurants");
                retCursor = mOpenHelper.getReadableDatabase().query(
                        DatabaseContract.TABLE_RESTAURANTS + ", " + DatabaseContract.TABLE_RESTAURANTS_VISITED,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.d(LOG_TAG, "getType -->" + uri);
        // Use the Uri Matcher to determine what kind of URI this is.
        final int match = sUriMatcher.match(uri);

        switch (match) {
            // Student: Uncomment and fill out these two cases
            case RESTAURANTS_LIST:
                return DatabaseContract.TableRestaurants.CONTENT_DIR_TYPE;
            case RESTAURANT:
                return DatabaseContract.TableRestaurants.CONTENT_ITEM_TYPE;
            case RESTAURANTS_VISITED_LIST:
                return DatabaseContract.TableRestaurantsVisited.CONTENT_DIR_TYPE;
            case RESTAURANT_VISITED:
                return DatabaseContract.TableRestaurantsVisited.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        int insertedRows = 0;

        Log.d(LOG_TAG, "bulk insert");
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case RESTAURANTS_LIST:
                for(ContentValues value : values){
                    try {
                        long _id = db.insertWithOnConflict(DatabaseContract.TABLE_RESTAURANTS, null, value, SQLiteDatabase.CONFLICT_IGNORE);
                        if (_id > 0) {
//                            Log.d(LOG_TAG, _id+" row inserted");
                            insertedRows++;
                        }
                        else {
//                            Log.d(LOG_TAG, "no row inserted");
                        }
                    } catch (SQLException e){
                        e.printStackTrace();
                        Log.d(LOG_TAG, "Exception-->"+e.getMessage());
                    }
                }
                break;
            case RESTAURANTS_VISITED_LIST:
                for(ContentValues value : values){
                    try {
                        long _id = db.insertWithOnConflict(DatabaseContract.TABLE_RESTAURANTS_VISITED, null, value, SQLiteDatabase.CONFLICT_IGNORE);
                        if (_id > 0) {
//                            Log.d(LOG_TAG, _id+" row inserted");
                            insertedRows++;
                        }
                        else {
//                            Log.d(LOG_TAG, "no row inserted");
                        }
                    }catch (SQLException e){
                        e.printStackTrace();
                        Log.d(LOG_TAG, "Exception-->" + e.getMessage());
                    }
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown insert uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return insertedRows;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(LOG_TAG, "insert");
//        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
//        final int match = sUriMatcher.match(uri);
//        Uri returnUri = null;
//
//        switch (match) {
//            case RESTAURANTS_LIST:
//                try {
//                    long _id = db.insertWithOnConflict(DatabaseContract.TABLE_RESTAURANTS, null, values, SQLiteDatabase.CONFLICT_IGNORE);
//                    if (_id > 0) {
////                        Log.d(LOG_TAG, _id+" Invite rows inserted");
//                        returnUri =DatabaseContract.TableRestaurants.buildRestaurantsUri();
//                    }
//                    else {
////                        Log.d(LOG_TAG, "no Invite row inserted");
//                        returnUri = null;
//                    }
//                } catch (SQLException e){
//                    e.printStackTrace();
//                    Log.d(LOG_TAG, "Exception-->"+e.getMessage());
//                }
//                break;
//            case RESTAURANTS_VISITED_LIST:
//                try {
//                    long _id = db.insertWithOnConflict(DatabaseContract.TABLE_RESTAURANTS_VISITED, null, values, SQLiteDatabase.CONFLICT_IGNORE);
//                    if (_id > 0) {
////                        Log.d(LOG_TAG, _id+" User rows inserted");
//                        returnUri = DatabaseContract.TableRestaurantsVisited.buildRestaurantsVisitedUri();
//                    }
//                    else {
//                        returnUri = null;
////                        Log.d(LOG_TAG, "no User row inserted");
//                    }
//                }catch (SQLException e){
//                    e.printStackTrace();
//                    Log.d(LOG_TAG, "Exception-->" + e.getMessage());
//                }
//                break;
//            default:
//                throw new UnsupportedOperationException("Unknown insert uri: " + uri);
//        }
//        getContext().getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(LOG_TAG, "delete");
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;
        // this makes delete all rows return the number of rows deleted
        if (null == selection) selection = "1";
        switch (match) {
            case RESTAURANTS_LIST:
                rowsDeleted = db.delete(DatabaseContract.TABLE_RESTAURANTS, selection, selectionArgs);
                break;
            case RESTAURANTS_VISITED_LIST:
                rowsDeleted = db.delete(DatabaseContract.TABLE_RESTAURANTS_VISITED, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        // Because a null deletes all rows
        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.d(LOG_TAG, "update");
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;
        switch (match) {
            case RESTAURANT_VISITED:
                rowsUpdated = db.update(DatabaseContract.TABLE_RESTAURANTS_VISITED, values, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown update uri: " + uri);
        }
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }
}
