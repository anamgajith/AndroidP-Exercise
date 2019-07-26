package com.anamgajith.players;

public class playerlist {
    int imageId;
    String name;

    public playerlist(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
