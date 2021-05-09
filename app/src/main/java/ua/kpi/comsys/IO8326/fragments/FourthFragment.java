package ua.kpi.comsys.IO8326.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.adapters.AdapterStorage;
import ua.kpi.comsys.IO8326.adapters.ImageAdapter;

import static android.app.Activity.RESULT_OK;

public class FourthFragment extends Fragment {
    private ImageAdapter adapter;
    private static final int REQUEST_CODE = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fourth_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        RecyclerView images = activity.findViewById(R.id.listOfImages_id);
        ImageButton button = activity.findViewById(R.id.button_id);

        button.setOnClickListener(v ->
        {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE);
        });

        if (adapter != null) {
            adapter.setActivity(activity);
        }

        adapter = new ImageAdapter(getContext(), AdapterStorage.images, activity);
        images.setAdapter(adapter);
        images.invalidate();
    }

    @Override
    public void onActivityResult(int request, int result, Intent data) {
        super.onActivityResult(request, result, data);
        if (result == RESULT_OK) {
            if (request == REQUEST_CODE) {
                AdapterStorage.images.addImages(data.getData());
                adapter.notifyDataSetChanged();
            }
        }
    }
}