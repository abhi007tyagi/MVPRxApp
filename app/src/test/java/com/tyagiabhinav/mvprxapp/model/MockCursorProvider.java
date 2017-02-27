package com.tyagiabhinav.mvprxapp.model;

import android.test.mock.MockCursor;

import com.tyagiabhinav.mvprxapp.model.db.DatabaseContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by abhinavtyagi on 27/02/17.
 */

public class MockCursorProvider {


    private static Map<Integer, Object> createRestaurantCursorEntry () {
        Map<Integer, Object> entry = new HashMap<>();
        entry.put(0, UUID.randomUUID().toString());
        entry.put(1, "TEST RESTAURANT");
        entry.put(2, "Test Address");
        entry.put(3, "23.00");
        entry.put(4, "77.00");
        entry.put(5, 2);
        entry.put(6, 3);
        entry.put(7, "Test Address");
        entry.put(8, "http://abc.url.com/img.png");
        entry.put(9, "http://abc.url.com/icon.png");
        entry.put(10, 1);
        entry.put(11, "http://abc.url.com");
        entry.put(12, "9876543210");
        entry.put(13, "Test Tips");
        entry.put(14, 1);
        entry.put(15, 0);
        entry.put(16, "");
        return entry;
    }

    public static RestaurantMockCursor createRestaurantsCursor() {
        List<Map<Integer, Object>> entryList = new ArrayList<>();
        entryList.add(createRestaurantCursorEntry());
        entryList.add(createRestaurantCursorEntry());
        entryList.add(createRestaurantCursorEntry());
        return new RestaurantMockCursor(entryList);
    }


    public static class RestaurantMockCursor extends MockCursor {
        Map<Integer, Object> entry;
        int cursorIndex;
        List<Map<Integer, Object>> entryList;
        Map<String, Integer> columnIndexes;

        {
            columnIndexes = new HashMap<>();
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_RESTAURANT_ID, 0);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_NAME, 1);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_ADDRESS, 2);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_LATITUDE, 3);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_LONGITUDE, 4);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_DISTANCE, 5);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_PRICE, 6);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_RATING, 7);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_IMG_URL, 8);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_ICON_URL, 9);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_IS_OPEN, 10);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_URL, 11);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_PHONE, 12);
            columnIndexes.put(DatabaseContract.TableRestaurants.COL_TIPS, 13);
            columnIndexes.put(DatabaseContract.TableRestaurantsVisited.COL_IS_CONSIDERED, 14);
            columnIndexes.put(DatabaseContract.TableRestaurantsVisited.COL_IS_VISITED, 15);
            columnIndexes.put(DatabaseContract.TableRestaurantsVisited.COL_COMMENTS, 16);
        }

        public RestaurantMockCursor(List<Map<Integer, Object>> entryList) {
            this.entryList = entryList;
        }

        @Override
        public int getCount() {
            return entryList.size();
        }

        @Override
        public String getString(int columnIndex) {
            return getValueString(columnIndex);
        }

        @Override
        public float getFloat(int columnIndex) {
            return Float.parseFloat(getValueString(columnIndex));
        }

        @Override
        public int getInt(int columnIndex) {
            return getValueInt(columnIndex);
        }

        private String getValueString(int columnIndex) {
            entry = entryList.get(cursorIndex);
            String value = (String) entry.get(columnIndex);
            return value;
        }

        private int getValueInt(int columnIndex) {
            entry = entryList.get(cursorIndex);
            int value = (int) entry.get(columnIndex);
            return value;
        }

        @Override
        public int getColumnIndex(String columnName) {
            return Integer.valueOf(columnIndexes.get(columnName));
        }

        @Override
        public int getColumnIndexOrThrow(String columnName) {
            return Integer.valueOf(columnIndexes.get(columnName));
        }

        @Override
        public boolean moveToFirst() {
            return entryList.size() > 0;
        }

        @Override
        public boolean moveToLast() {
            return cursorIndex < entryList.size();
        }

        @Override
        public boolean moveToNext() {
            cursorIndex++;
            return cursorIndex < entryList.size();
        }

        @Override
        public boolean isAfterLast() {
            return super.isAfterLast();
        }
    }
}
