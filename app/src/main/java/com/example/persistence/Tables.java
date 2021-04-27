package com.example.persistence;

public class Tables {
    static class Lake {

        static final String TABLE_NAME = "lake";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_SIZE = "size";
        static final String COLUMN_NAME_DEPTH = "depth";

    }

    static final String SQL_CREATE_TABLE_LAKE =
            // "CREATE TABLE lake (id INTEGER PRIMARY KEY, name TEXT, size INT)"
            "CREATE TABLE " + Lake.TABLE_NAME + " (" +
                    Lake.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Lake.COLUMN_NAME_NAME + " TEXT," +
                    Lake.COLUMN_NAME_SIZE + " INT," +
                    Lake.COLUMN_NAME_DEPTH + " INT)";

    static final String SQL_DELETE_TABLE_LAKE =
            // "DROP TABLE IF EXISTS lake"
            "DROP TABLE IF EXISTS " + Lake.TABLE_NAME;
}
