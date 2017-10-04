package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {

    // Attributs
    private String departure;
    private String destination;
    private String date;

    // Constructor
    public SearchRequestModel(String departure, String destination, String date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    // Getters
    public String getDeparture() {
        return departure;
    }
    public String getDestination() {
        return destination;
    }
    public String getDate() {
        return date;
    }

    // Parcelable
    protected SearchRequestModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departure);
        dest.writeString(destination);
        dest.writeString(date);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }
        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };
}
