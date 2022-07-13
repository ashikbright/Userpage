package com.ashik.userpage.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.ashik.userpage.Models.Order;
import com.google.firestore.v1.StructuredQuery;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "userOrderDB.db";
    private static final int DB_VERSION = 1;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

//
//    public List<Order> getCarts() {
//
//        SQLiteDatabase db = getReadableDatabase();
//        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
//
//        String[] sqlSelect = {
//                "orderID", "userName", "workerType", "totalWorkers", "totalDays", "address"
//        };
//        String sqlTable = "OrderDetails";
//
//        qb.setTables(sqlTable);
//        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
//
//        final List<Order> result = new ArrayList<>();
//        if(c.moveToFirst())
//        {
//            do {
//                result.add(new Order(
//                        c.getString(c.getColumnIndexOrThrow("oderId")),
//                        c.getString(c.getColumnIndexOrThrow("workerType")),
//                        c.getString(c.getColumnIndexOrThrow("totalWorkers")),
//                        c.getString(c.getColumnIndexOrThrow("totalDays")),
//                        c.getString(c.getColumnIndexOrThrow("address")),
//                        c.getString(c.getColumnIndexOrThrow("date"))
//                ));
//            }
//            while(c.moveToNext());
//        }
//        return result;
//    }
//
//    public void addToCart(Order order) {
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = String.format("INSERT INTO OrderDetails(orderID,workerType,totalWorkers,totalDays,address) " +
//                "VALUES('%s', '%s', '%s', '%s', '%s',  '%s');",
//                order.getOrderId(),
//                order.getWorkerType(),
//                order.getTotalWorkers(),
//                order.getTotalDays(),
//                order.getAddress(),
//                order.getDate()
//        );
//
//        db.execSQL(query);
//    }
//
//    public void cleanCart() {
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = String.format("DELETE FROM OrderDetails");
//
//        db.execSQL(query);
//    }

}
