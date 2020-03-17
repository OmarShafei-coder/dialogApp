package com.omarshafei.dialogapp;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements MyCustomDialog.OnInputListener {

    private Button mOpenDialog;
    private TextView mInputDisplay;

    private static final String TAG = "MainFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mOpenDialog = view.findViewById(R.id.open_dialog);
        mInputDisplay = view.findViewById(R.id.input_display);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening the dialog");
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.setTargetFragment(MainFragment.this, 1); // in case of fragment to activity communication we do not need this line. But must write this i case of fragment to fragment communication
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });

        return view;
    }

    @Override
    public void sendInput(CharSequence input) {
        mInputDisplay.setText(input);
    }
}