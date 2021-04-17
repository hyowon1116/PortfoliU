package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TimeTable")
public class User_timetable implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_lec")
    private String lec;
    @ColumnInfo(name = "user_prof")
    private String prof;
    @ColumnInfo(name = "user_des")
    private String des;

    public User_timetable(String lec, String prof, String des) {
        this.lec = lec;
        this.prof = prof;
        this.des = des;
    }

    protected User_timetable(Parcel in) {
        id = in.readInt();
        lec = in.readString();
        prof = in.readString();
        des = in.readString();
    }

    public static final Creator<User_timetable> CREATOR = new Creator<User_timetable>() {
        @Override
        public User_timetable createFromParcel(Parcel in) {
            return new User_timetable(in);
        }

        @Override
        public User_timetable[] newArray(int size) {
            return new User_timetable[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLec() {
        return lec;
    }

    public void setLec(String lec) {
        this.lec = lec;
    }
    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(lec);
        dest.writeString(prof);
        dest.writeString(des);
    }
}
