package com.room.proharvesting.phvroomdb.Utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by proharvesting on 12/4/2017.
 */

public class TypeTransform {

//    @TypeConverter
//    public static Long fromDate(Date date) {
//        if (date==null) {
//            return(null);
//        }
//
//        return(date.getTime());
//    }
    @TypeConverter
    public static String fromDate(Date date) {
        if (date==null) {
            return(null);
        }
        return(DateTools.toStringV1(date));
    }



    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch==null) {
            return(null);
        }

        return(new Date(millisSinceEpoch));
    }

}
