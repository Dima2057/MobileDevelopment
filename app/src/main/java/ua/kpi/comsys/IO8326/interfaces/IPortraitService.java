package ua.kpi.comsys.IO8326.interfaces;

import android.net.Uri;

public interface IPortraitService {
    void add(Uri image);
    int size();
    Uri getIndex(int index);
}
