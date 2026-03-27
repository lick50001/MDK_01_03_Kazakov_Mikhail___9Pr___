package com.example.uicomponents.button;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.uicomponents.R;

public class TbCustom extends ConstraintLayout {

    public EditText editText;

    public enum TypeText {
        PRIMARY,
        ACTIVITY,
        ERROR
    }

    public TbCustom(@NonNull Context context) {
        super(context);
    }

    public TbCustom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TbCustom(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(Integer idLayout) {
        if (idLayout == null || editText != null) return;

        LayoutInflater.from(getContext()).inflate(idLayout, this, true);
        editText = findViewById(R.id.tb);
    }

    public void init(String value, TypeText type) {
        if (editText == null) return;

        editText.setText(value);

        switch (type) {
            case PRIMARY:
                editText.setBackgroundResource(R.drawable.tb_primary);
                editText.setTextColor(Color.parseColor("#7E7E9A"));
                break;

            case ACTIVITY:
                editText.setBackgroundResource(R.drawable.tb_activity);
                editText.setTextColor(Color.parseColor("#7E7E9A"));
                break;

            case ERROR:
                editText.setBackgroundResource(R.drawable.tb_error);
                editText.setTextColor(Color.parseColor("#7E7E9A"));
                break;
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (editText != null) {
            editText.setEnabled(enabled);
            editText.setAlpha(enabled ? 1f : 0.5f);
        }
    }
}