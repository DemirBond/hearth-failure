package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomEditText;

public class MinutesSecondsCell extends LinearLayout implements CellItem {
    private CustomEditText minutesEditText;
    private CustomEditText secondsEditText;

    public MinutesSecondsCell(Context context) {
        super(context);
        inflate(context);
    }

    public MinutesSecondsCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public MinutesSecondsCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public MinutesSecondsCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.minutes_seconds_cell, this);
        initView();
    }

    private void initView() {
        minutesEditText = (CustomEditText) findViewById(R.id.minutes_edit_text);
        minutesEditText.addTextChangedListener(new InnerTextWatcher(minutesEditText));

        secondsEditText = (CustomEditText) findViewById(R.id.seconds_edit_text);
        secondsEditText.addTextChangedListener(new InnerTextWatcher(secondsEditText));
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String hint) {
    }

    @Override
    public void setLabelText(String text) {
    }

    public int getMinutes() {
        return Integer.valueOf(minutesEditText.getText().toString());
    }

    public void setMinutes(Integer minutes) {
        minutesEditText.setText(String.valueOf(minutes));
    }

    public int getSeconds() {
        return Integer.valueOf(secondsEditText.getText().toString());
    }

    public void setSeconds(Integer seconds) {
        secondsEditText.setText(String.valueOf(seconds));
    }

    public void addOnMinutesChangeListener(TextWatcher textWatcher) {
        minutesEditText.addTextChangedListener(textWatcher);
    }

    public void addOnSecondsChangeListener(TextWatcher textWatcher) {
        secondsEditText.addTextChangedListener(textWatcher);
    }

    class InnerTextWatcher implements TextWatcher {
        EditText referEditText;

        InnerTextWatcher(EditText referEditText) {
            this.referEditText = referEditText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().isEmpty()) {
                int value = Integer.valueOf(s.toString());
                if (value > 60) {
                    referEditText.setText(String.valueOf(value % 60));
                }
            }
        }
    }
}