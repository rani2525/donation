package com.example.donationapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Donation implements Parcelable {

    private String name;
    private String type;
    private int amount;
    //constructor as same name of class
    public Donation(String name, String type, int amount){
        this.name = name;
        this.type = type;
        this.amount = amount;


    }

    protected Donation(Parcel in) {
        name = in.readString();
        type = in.readString();
        amount = in.readInt();

    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeInt(amount);
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getAmount(){

        return amount;
    }

//    protected Donation(Parcel in) {
//
//
//    }
//
//    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
//        @Override
//        public Donation createFromParcel(Parcel in) {
//            return new Donation(in);
//        }
//
//        @Override
//        public Donation[] newArray(int size) {
//            return new Donation[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//    }
}
