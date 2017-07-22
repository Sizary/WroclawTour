package com.example.android.wroclawtour;

/**
 * Created by Cezary on 19.07.2017.
 */

/**
 * {@link Location} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a header translation, and an image for that word.
 */
public class Location {

    /**
     * Name of the the place
     */
    private String mHeaderText;

    /**
     * Description of the place
     */
    private String mDescriptionOfHeader;

    /**
     * Audio resource ID for the place
     */
    private String mPositionOnMap;

    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this place
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Location object.
     * @param HeaderText          is the Name of the places and monuments
     * @param imageResourceId     is the drawable resource ID for the image associated with the Header
     * @param DescriptionOfHeader is Description of the place or monuments
     * @param positionOnMap       is the map position associated with the place
     */
    public Location(String DescriptionOfHeader, String HeaderText, int imageResourceId, String positionOnMap) {
        mHeaderText = HeaderText;
        mDescriptionOfHeader = DescriptionOfHeader;
        mImageResourceId = imageResourceId;
        mPositionOnMap = positionOnMap;
    }

    /**
     * Create a new object.
     */
    public Location(String HeaderText, String DescriptionOfHeader, String positionOnMap, int imageResourceId) {
        mHeaderText = HeaderText;
        mDescriptionOfHeader = DescriptionOfHeader;
        mImageResourceId = imageResourceId;
        mPositionOnMap = positionOnMap;
    }

    /**
     * Get the name of the place
     */
    public String getHeaderText() {
        return mHeaderText;
    }

    /**
     * Get the description of the palce.
     */
    public String getDescriptionOfHeader() {
        return mDescriptionOfHeader;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the geo position of the place.
     */
    public String getPositionOnMap() {
        return mPositionOnMap;
    }
}