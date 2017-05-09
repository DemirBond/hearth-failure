package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class HeartPartnerCell extends LinearLayout implements CellItem {
    private CustomTextView departmentName;
    private CustomTextView description;
    private CustomTextView hours;
    private ImageView contextMenuButton;
    private View viewMoreSpecialistsButton;

    public HeartPartnerCell(Context context) {
        super(context);
        inflate(context);
    }

    public HeartPartnerCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public HeartPartnerCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public HeartPartnerCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    private void inflate(Context context) {
        inflate(context, R.layout.heart_partner_cell, this);
        initView();
    }

    private void initView() {
        departmentName = (CustomTextView) findViewById(R.id.department_name);
        description = (CustomTextView) findViewById(R.id.description);
        hours = (CustomTextView) findViewById(R.id.hours);
        contextMenuButton = (ImageView) findViewById(R.id.context_menu_button);
        viewMoreSpecialistsButton = findViewById(R.id.view_more_specialists_button);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {

    }

    @Override
    public void setLabelText(String text) {

    }

    public void setDepartmentName(String text) {
        departmentName.setText(text);
    }

    public void setDescription(String text) {
        description.setText(text);
    }

    public void setHours(String text) {
        hours.setText(text);
    }
}
