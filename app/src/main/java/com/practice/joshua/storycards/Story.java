package com.practice.joshua.storycards;

import android.os.Parcel;
import android.os.Parcelable;

public class Story implements Parcelable {

    private String storyId;
    private String name;
    private String description;
    private int page;

    public Story() {
    }

    public Story(String storyId, String name, String description, int page) {
        this.storyId = storyId;
        this.name = name;
        this.description = description;
        this.page = page;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.storyId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.page);
    }

    protected Story(Parcel in) {
        this.storyId = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.page = in.readInt();
    }

    public static final Parcelable.Creator<Story> CREATOR = new Parcelable.Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel source) {
            return new Story(source);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
}
