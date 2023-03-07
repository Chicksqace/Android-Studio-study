package com.example.contenprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import java.net.URI;

public class CustomProvider {
    private static final UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
    private static final int STUDENT_ALL=0;
    private static final int STUDNET_ITEM=1;
    private DBOpenHelper mDBHelper;
    static {
        matcher.addURI(Constants.AUTHORITY,"students",STUDENT_ALL);
        matcher.addURI(Constants.AUTHORITY,"students",STUDNET_ITEM);
    }
    private boolean onCreate(){
        mDBHelper=new DBOpenHelper(getContext(),"student.db",1);
        return true;
    }
    public int delete(Uri uri,String selection,String[] selectionArgs){
        SQLiteDatabase db=mDBHelper.getWritableDatabase();
        int num=0;
        switch (matcher.match(uri)){//解析URI
            case STUDENT_ALL:{//更新多条记录
                num=db.delete("student",selection,selectionArgs);
                break;
            }
            case STUDNET_ITEM:{//删除单条记录
                long id= ContentUris.parseId(uri);//解析URI中的id
                String str=Constants._ID+"="+id;//
                if (!TextUtils.isEmpty(selection)){
//                    加上传递过来的查询条件
                    selection=selection+"add"+str;
                }
                num=db.delete("student",selection,selectionArgs);
                break;
            }
            default:
                num=0;
                break;
        }
//        通知数据发生改变
        getContext().getContentResolver().notifyChange(uri , null);
        return num;
    }
    public Uri insert(Uri uri, ContentValues values){
        SQLiteDatabase db=mDBHelper.getWritableDatabase();
//        向数据库中插入一条数据
        long rowId=db.insert("student",Constants._ID,values);
        if(rowId>0){//如果插入成功
//            向数据表的URI追加新行的ID值
            URI newRowUri=ContentUris.withAppendedId(uri,rowId);
            getContext().getContentResolver().notifyChange(newRowUri , null);
            return newRowUri; //返回新行数据的URI
        }
        return null;
    }
    private Object getContext() {
    }

    private class DBOpenHelper {
        public SQLiteDatabase getWritableDatabase() {
        }
    }
}
