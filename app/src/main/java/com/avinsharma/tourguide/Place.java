package com.avinsharma.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Avin on 06-09-2016.
 */
public class Place implements Parcelable {
    private String mName;
    private String mAddress;
    private String mDescription;
    private int mImageviewResource;
    private String mCuisine;

    //For initializing Attractions and Hotles
    public Place(String mName, int mImageviewResource, String mDescription, String mAddress) {
        this.mImageviewResource = mImageviewResource;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mName = mName;
        mCuisine = null;
    }

    //For initializing Food places
    public Place(String mName, int mImageviewResource, String mCuisine, String mDescription, String mAddress) {
        this.mImageviewResource = mImageviewResource;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mName = mName;
        this.mCuisine = mCuisine;
    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmImageviewResource() {
        return mImageviewResource;
    }

    public String getmCuisine() {
        return mCuisine;
    }

    @Override
    public String toString() {
        return "Place{" +
                "mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageviewResource=" + mImageviewResource +
                ", mCuisine='" + mCuisine + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mImageviewResource);
        parcel.writeString(mName);
        parcel.writeString(mAddress);
        parcel.writeString(mDescription);
        parcel.writeString(mCuisine);
    }
    public static Parcelable.Creator CREATOR = new Creator() {
        @Override
        public Place createFromParcel(Parcel parcel) {
            return new Place(parcel);
        }

        @Override
        public Place[] newArray(int i) {
            return new Place[i];
        }
    };

    public Place(Parcel parcel){
        mImageviewResource = parcel.readInt();
        mName = parcel.readString();
        mAddress = parcel.readString();
        mDescription = parcel.readString();
        mCuisine = parcel.readString();
    }
}

