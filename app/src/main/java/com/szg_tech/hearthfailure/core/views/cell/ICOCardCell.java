package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class ICOCardCell extends LinearLayout implements CellItem {
    private CustomTextView title;
    private CustomTextView subTitle;
    private CustomTextView blueTextView;
    private CustomTextView greenTextView;
    private ImageView contextMenuButton;
    private View viewMoreInformationButton;

    public ICOCardCell(Context context) {
        super(context);
        inflate(context);
    }

    public ICOCardCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public ICOCardCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public ICOCardCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    private void inflate(Context context) {
        inflate(context, R.layout.ico_card_cell, this);
        initView();
    }

    private void initView() {
        title = (CustomTextView) findViewById(R.id.ico_name);
        subTitle = (CustomTextView) findViewById(R.id.description);
        blueTextView = (CustomTextView) findViewById(R.id.blue_text_view);
        greenTextView = (CustomTextView) findViewById(R.id.green_text_view);
        contextMenuButton = (ImageView) findViewById(R.id.context_menu_button);
        viewMoreInformationButton = findViewById(R.id.view_more_information_button);
    }

    @Override
    public void setLabelText(String text) {
        title.setText(text);
    }

    @Override
    public void setHintText(String text) {
        subTitle.setText(text);
    }

    public void setBlueTextViewText(String text) {
        blueTextView.setText(text);
    }

    public void setGreenTextView(String text) {
        greenTextView.setText(text);
    }
}
