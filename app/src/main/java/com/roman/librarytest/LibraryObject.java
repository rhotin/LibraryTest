package com.roman.librarytest;

import android.os.Parcel;
import android.os.Parcelable;


public class LibraryObject implements Parcelable {
    String teacherInTheLibrary;
    String zip;
    String hoursOfOperation;
    String website;
    String address;
    String city;
    String phone;
    String latitude;
    String longitude;
    String state;
    String cybernavigator;
    String name;

    LibraryObject(String mTeacherInTheLibrary, String mZip, String mHoursOfOperation,
                  String mWebsite, String mAddress, String mCity, String mPhone,
                  String mLatitude, String mLongitude, String mState,
                  String mCybernavigator, String mName) {
        this.teacherInTheLibrary = mTeacherInTheLibrary;
        this.zip = mZip;
        this.hoursOfOperation = mHoursOfOperation;
        this.website = mWebsite;
        this.address = mAddress;
        this.city = mCity;
        this.phone = mPhone;
        this.latitude = mLatitude;
        this.longitude = mLongitude;
        this.state = mState;
        this.cybernavigator = mCybernavigator;
        this.name = mName;
    }


    protected LibraryObject(Parcel in) {
        teacherInTheLibrary = in.readString();
        zip = in.readString();
        hoursOfOperation = in.readString();
        website = in.readString();
        address = in.readString();
        city = in.readString();
        phone = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        state = in.readString();
        cybernavigator = in.readString();
        name = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(teacherInTheLibrary);
        parcel.writeString(zip);
        parcel.writeString(hoursOfOperation);
        parcel.writeString(website);
        parcel.writeString(address);
        parcel.writeString(city);
        parcel.writeString(phone);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        parcel.writeString(state);
        parcel.writeString(cybernavigator);
        parcel.writeString(name);
    }

    public static final Creator<LibraryObject> CREATOR = new Creator<LibraryObject>() {
        @Override
        public LibraryObject createFromParcel(Parcel in) {
            return new LibraryObject(in);
        }

        @Override
        public LibraryObject[] newArray(int size) {
            return new LibraryObject[size];
        }
    };
}
