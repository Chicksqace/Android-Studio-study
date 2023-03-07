package com.example.contenprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class Constants implements BaseColumns {
    public static final String AUTHORITY="com.demo.student.provider";
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/students");
    public static final String DATA_TYPE="vnd.android.dir/vnd.com.demo.provider.student";
    public static final String DATA_TYPE_ITEM="vnd.android.item/vnd.com.demo.provider.student";
    public static final String _ID="id";
    public static final String SNO="sno";
    public static final String SNAME="sname";
    public static final String SAGE="sage";
}
