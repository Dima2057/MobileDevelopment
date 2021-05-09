package ua.kpi.comsys.IO8326.services;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.IO8326.interfaces.IPortraitService;

public class ImageService implements IPortraitService {
    private static final int INITIAL_CAPACITY = 10;
    private final List<Uri> images;

    public ImageService(){
        images = new ArrayList<>(INITIAL_CAPACITY);
    }

    @Override
    public void add(Uri image){
        images.add(image);
    }

    @Override
    public int size(){
        return images.size();
    }

    @Override
    public Uri getIndex(int index) {
        return index < images.size() ? images.get(index) : null;
    }
}
