package com.leesc.voicetimer.data.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "alarm")
public class Alarm {

    @Expose
    @PrimaryKey
    public Long id;
}
