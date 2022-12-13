package com.example.emptyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


        public DatabaseHelper(Context context) {
            super(context, "trash", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }


//
//        public ArrayList<Point> getAllDate(){
//            ArrayList<Point> arrayList = new ArrayList<>();
//            SQLiteDatabase db = this.getReadableDatabase();
////            Cursor
//        }


















}
