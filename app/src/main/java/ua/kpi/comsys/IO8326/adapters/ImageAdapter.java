package ua.kpi.comsys.IO8326.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.services.ImageService;
import ua.kpi.comsys.IO8326.models.Images;

import static android.widget.LinearLayout.LayoutParams;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private Activity activity;
    private final Images images;
    private final Point point = new Point();

    public ImageAdapter(Context context, Images images, Activity activity) {
        inflater = LayoutInflater.from(context);
        this.images = images;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final static int IMAGE_AMOUNT = 10;
        final static int LINEAR_AMOUNT = 6;
        final LinearLayout[] linear;
        final ImageView[] imageViews;
        private final int[] layoutImages = {
                R.id.layout_image_0, R.id.layout_image_1, R.id.layout_image_2,
                R.id.layout_image_3, R.id.layout_image_4, R.id.layout_image_5,
                R.id.layout_image_6, R.id.layout_image_7, R.id.layout_image_8,
                R.id.layout_image_9
        };

        private final int[] linears = {
                R.id.linear_0, R.id.linear_1, R.id.linear_2,
                R.id.linear_3, R.id.linear_4, R.id.linear_5
        };

        ViewHolder(View view) {
            super(view);
            imageViews = new ImageView[IMAGE_AMOUNT];
            linear = new LinearLayout[LINEAR_AMOUNT];
            for (int i = 0; i < layoutImages.length; i++) {
                imageViews[i] = view.findViewById(layoutImages[i]);
            }
            for (int i = 0; i < linears.length; i++) {
                linear[i] = view.findViewById(linears[i]);
            }
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.images_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int[] horizontalSize;
        int[] dpiSize = new int[]{250, 250, 500, 250, 250, 500, 250, 250, 250, 250};
        ImageService item = images.getImages().get(position);
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        double bigPicture = point.x - point.x / 1.75;
        double smallPicture = point.x - point.x / 1.4;
        double[] widthSize = {smallPicture, smallPicture, bigPicture,
                smallPicture, smallPicture, bigPicture,
                smallPicture, smallPicture, smallPicture,
                smallPicture};
        horizontalSize = dpiSize;

        for (int i = 0; i < holder.imageViews.length; i++) {
            Uri uri;
            if ((uri = item.getIndex(i)) == null) {
                return;
            }
            Picasso.with(inflater.getContext()).load(uri).
                    resize((int) widthSize[i], horizontalSize[i]).
                    centerInside().into(holder.imageViews[i]);
            holder.imageViews[i].setBackgroundColor(Color.GRAY);
            LayoutParams layout = new LayoutParams((int) widthSize[i], horizontalSize[i]);
            layout.setMargins(1, 1, 1, 1);
            holder.imageViews[i].setLayoutParams(layout);
        }
    }

    @Override
    public int getItemCount() {
        return images.getImages().size();
    }
}
