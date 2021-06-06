package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.laioffer.tinnews.database.TinNewsDatabase;

//single class for a app
public class TinNewsApplication extends Application {

    private static TinNewsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: new code here.
        //Gander.setGanderStorage(GanderIMDB.getInstance());
        database = Room.databaseBuilder(this, TinNewsDatabase.class, "tinnews_db").build();


    }


    public static TinNewsDatabase getDatabase() {
        return database;
    }

}
