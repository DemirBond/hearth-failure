package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class SectionCell extends LinearLayout implements CellItem {
    private CustomTextView textView;
    private ImageView chevronImage;
    private ImageView lockImage;
    private ImageView viewedImage;
    private ImageView filledImage;
    private View stateIconLayout;

    private boolean isLocked = true;
    private boolean isOpened = false;
    private boolean isViewed = false;
    private boolean isFilled = false;

    public SectionCell(Context context) {
        super(context);
        inflate(context);
    }

    public SectionCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public SectionCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public SectionCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.section_cell, this);
        initView();
    }

    private void initView() {
        stateIconLayout = findViewById(R.id.state_icon_layout);
        textView = (CustomTextView) findViewById(R.id.section_name);
        chevronImage = (ImageView) findViewById(R.id.chevron_fwd);
        lockImage = (ImageView) findViewById(R.id.lock);
        viewedImage = (ImageView) findViewById(R.id.viewed);
        filledImage = (ImageView) findViewById(R.id.filled);
        setUpView();
    }

    private void setUpView() {
        if (isLocked) {
            lockImage.setVisibility(VISIBLE);
            chevronImage.setVisibility(GONE);
            viewedImage.setVisibility(GONE);
            filledImage.setVisibility(GONE);
        } else if (isOpened) {
            lockImage.setVisibility(GONE);
            chevronImage.setVisibility(VISIBLE);
            viewedImage.setVisibility(GONE);
            filledImage.setVisibility(GONE);
        } else if (isViewed) {
            lockImage.setVisibility(GONE);
            chevronImage.setVisibility(VISIBLE);
            viewedImage.setVisibility(VISIBLE);
            filledImage.setVisibility(GONE);
        } else if (isFilled) {
            lockImage.setVisibility(GONE);
            chevronImage.setVisibility(VISIBLE);
            viewedImage.setVisibility(GONE);
            filledImage.setVisibility(VISIBLE);
        }
    }

    public CustomTextView getTextView() {
        return textView;
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    @Override
    public void setHintText(String text) {

    }

    public void setLocked() {
        isLocked = true;
        isOpened = false;
        isViewed = false;
        isFilled = false;
        setUpView();
    }

    public void setOpened() {
        isLocked = false;
        isOpened = true;
        isViewed = false;
        isFilled = false;
        setUpView();
    }

    public void setViewed() {
        isLocked = false;
        isOpened = false;
        isViewed = true;
        isFilled = false;

        setUpView();
    }

    public void setFilled() {
        isLocked = false;
        isOpened = false;
        isViewed = false;
        isFilled = true;
        setUpView();
    }

    public void setStateIconLayoutVisibility(boolean isVisible) {
        if (isVisible) {
            stateIconLayout.setVisibility(VISIBLE);
        } else {
            stateIconLayout.setVisibility(GONE);
        }
    }
}
