package ua.kpi.comsys.IO8326.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.IO8326.services.ImageService;

public class Images {
    private static final int INITIAL_CAPACITY = 10;
    private final List<ImageService> images;

    public Images() {
        images = new ArrayList<>();
        images.add(new ImageService());
    }

    public List<ImageService> getImages() {
        return images;
    }

    public void addImages(Uri image) {
        int imageSize = images.size() - 1;
        if (images.get(imageSize).size() == INITIAL_CAPACITY) {
            images.add(new ImageService());
        }
        images.get(imageSize).add(image);
    }
}