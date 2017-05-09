package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class TextCell extends LinearLayout implements CellItem {
    private CustomTextView textView;

    public TextCell(Context context) {
        super(context);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.text_cell, this);
        initView();
    }

    private void initView() {
        textView = (CustomTextView) findViewById(R.id.text);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {

    }

    @Override
    public void setLabelText(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(text));
        }
    }

}