package com.szg_tech.hearthfailure.core.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;

public class ButtonWithChevron extends LinearLayout {
    private CustomTextView textView;
    private ImageView chevronImageView;

    public ButtonWithChevron(Context context) {
        super(context);
        inflate(null);
    }

    public ButtonWithChevron(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(attrs);
    }

    public ButtonWithChevron(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(attrs);
    }

    public ButtonWithChevron(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(attrs);

    }

    private void inflate(AttributeSet attrs) {
        inflate(getContext(), R.layout.bottom_button_with_chevron, this);
        String textColor = null;
        int color = -1;
        Drawable chevronDrawable = null;
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ButtonWithChevron);
            textColor = (String) a.getText(R.styleable.ButtonWithChevron_text);
            color = a.getColor(R.styleable.ButtonWithChevron_text_color, -1);
            chevronDrawable = a.getDrawable(R.styleable.ButtonWithChevron_chevron_img);
            a.recycle();
        }
        setUpView(textColor, color, chevronDrawable);
    }

    private void setUpView(String text, int textColor, Drawable chevronDrawable) {
        textView = (CustomTextView) findViewById(R.id.section_name);
        chevronImageView = (ImageView) findViewById(R.id.chevron_fwd);
        if (text != null) {
            textView.setText(text);
        }
        if (textColor != -1) {
            textView.setTextColor(textColor);
        }
        if (chevronDrawable != null) {
            chevronImageView.setImageDrawable(chevronDrawable);
        }
    }

    public CustomTextView getTextView() {
        return textView;
    }

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }

    public String getText() {
        return textView.getText().toString();
    }

    public void setText(String text) {
        textView.setText(text);
    }
}