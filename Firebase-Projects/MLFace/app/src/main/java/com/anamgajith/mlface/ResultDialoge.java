package com.anamgajith.mlface;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialoge extends DialogFragment {

    private static Button button;
    private static TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_window,container,false);
        button = view.findViewById(R.id.result_ok_button);
        textView = view.findViewById(R.id.result_text_view);
        String resultText = "";
        Bundle bundle = getArguments();
        resultText = bundle.getString(MyFaceDetector.RESULT_TEXT);
        textView.setText(resultText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}
