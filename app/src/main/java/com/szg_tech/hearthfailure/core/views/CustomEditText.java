package com.szg_tech.hearthfailure.core.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    private static final String ROBOTO_BOLD_FILE_PATH = "fonts/Roboto-Bold.ttf";
    private static final String ROBOTO_MEDIUM_FILE_PATH = "fonts/Roboto-Medium.ttf";
    private String fontPath;
    private int currentStyleId = -1;
    private static Float textDelta;
    private final float scale = getContext().getResources().getDisplayMetrics().density;
    private List<TextWatcher> textWatcherList = new ArrayList<>();

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttributes(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttributes(context, attrs);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            textDelta = (float) (intent.getIntExtra(ConfigurationParams.SIZE, 16) - 16);
            PreferenceHelper.putTextDelta(context, textDelta);
            setCorrectTextSize();
        }
    };

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().registerReceiver(broadcastReceiver, new IntentFilter(ConfigurationParams.ACTION_CHANGE_SIZE));
        textDelta = PreferenceHelper.getTextDelta(getContext());
        setCorrectTextSize();
    }

    @Override
    protected void onDetachedFromWindow() {
        getContext().unregisterReceiver(broadcastReceiver);
        super.onDetachedFromWindow();
    }

    private void setCorrectTextSize() {
        if (currentStyleId != -1) {
            int[] attrs = new int[]{android.R.attr.textSize};
            TypedArray ta = getContext().obtainStyledAttributes(currentStyleId, attrs);
            float textSize = ta.getDimensionPixelSize(0, -1) / scale;
            setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize + textDelta);
            ta.recycle();
        }
    }

    public void readAttributes(Context context, AttributeSet attrs) {
        if (textDelta == null) {
            textDelta = PreferenceHelper.getTextDelta(context);
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        int type = typedArray.getInt(R.styleable.CustomTextView_type, -1);
        if (type != -1) {
            CustomEditText.CustomTextViewType customTextViewType = CustomEditText.CustomTextViewType.fromInt(type);
            switch (customTextViewType) {
                case TITLE_CENTER:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Titlecenter;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Titlecenter);
                    } else {
                        setTextAppearance(context, R.style.Titlecenter);
                    }
                    break;
                case TITLE_LEFT:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.TitleLeft;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.TitleLeft);
                    } else {
                        setTextAppearance(context, R.style.TitleLeft);
                    }
                    break;
                case SUBHEADING_SECTION:
                    fontPath = ROBOTO_BOLD_FILE_PATH;
                    currentStyleId = R.style.Subheadingsection;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Subheadingsection);
                    } else {
                        setTextAppearance(context, R.style.Subheadingsection);
                    }
                    break;
                case SUBHEADING:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Subheading;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Subheading);
                    } else {
                        setTextAppearance(context, R.style.Subheading);
                    }
                    break;
                case SUBHEADING_LEFT:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Subheadingleft;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Subheadingleft);
                    } else {
                        setTextAppearance(context, R.style.Subheadingleft);
                    }
                    break;
                case BUTTON_DARK:
                    fontPath = ROBOTO_BOLD_FILE_PATH;
                    currentStyleId = R.style.Buttondark;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Buttondark);
                    } else {
                        setTextAppearance(context, R.style.Buttondark);
                    }
                    break;
                case BODY_LINK:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Bodylink;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Bodylink);
                    } else {
                        setTextAppearance(context, R.style.Bodylink);
                    }
                    break;
                case BODY_PLACEHOLDER:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Bodyplaceholder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Bodyplaceholder);
                    } else {
                        setTextAppearance(context, R.style.Bodyplaceholder);
                    }
                    break;
                case TAG:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Tag;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Tag);
                    } else {
                        setTextAppearance(context, R.style.Tag);
                    }
                    break;
                case BODY2:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Body2;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Body2);
                    } else {
                        setTextAppearance(context, R.style.Body2);
                    }
                    break;
                case INPUT_RIGHT:
                    fontPath = ROBOTO_MEDIUM_FILE_PATH;
                    currentStyleId = R.style.Inputright;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setTextAppearance(R.style.Inputright);
                    } else {
                        setTextAppearance(context, R.style.Inputright);
                    }
                    break;
            }
            createAndSetTypeface();
        }
        typedArray.recycle();
    }

    public void createAndSetTypeface() {
        Context context = getContext();
        setTypeface(Typeface.createFromAsset(context.getAssets(), fontPath));
        int color = getCurrentTextColor();
        int hintColor = Color.argb(Color.alpha(Color.parseColor("#1a000000")), Color.red(color), Color.blue(color), Color.green(color));
        setHintTextColor(hintColor);
        setSingleLine();
        setImeOptions(EditorInfo.IME_ACTION_NEXT);
        setOnFocusChangeListener((v, hasFocus) -> {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (hasFocus) {
                imm.toggleSoftInputFromWindow(getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
            } else {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                v.clearFocus();
            }
            return false;
        });
    }

    @Override
    public void addTextChangedListener(TextWatcher watcher) {
        textWatcherList.add(watcher);
        super.addTextChangedListener(watcher);
    }

    @Override
    public void removeTextChangedListener(TextWatcher watcher) {
        textWatcherList.remove(watcher);
        super.removeTextChangedListener(watcher);
    }

    public void clearTextWatchers() {
        for (TextWatcher textWatcher : textWatcherList) {
            removeTextChangedListener(textWatcher);
        }
        textWatcherList.clear();
    }

    private enum CustomTextViewType {
        TITLE_CENTER, TITLE_LEFT, SUBHEADING_SECTION, SUBHEADING, SUBHEADING_LEFT, BUTTON_DARK, BODY_LINK, BODY_PLACEHOLDER, TAG, BODY2, INPUT_RIGHT;

        public static CustomEditText.CustomTextViewType fromInt(int value) {
            switch (value) {
                case 0:
                    return TITLE_CENTER;
                case 1:
                    return TITLE_LEFT;
                case 2:
                    return SUBHEADING_SECTION;
                case 3:
                    return SUBHEADING;
                case 4:
                    return SUBHEADING_LEFT;
                case 5:
                    return BUTTON_DARK;
                case 6:
                    return BODY_LINK;
                case 7:
                    return BODY_PLACEHOLDER;
                case 8:
                    return TAG;
                case 9:
                    return BODY2;
                case 10:
                default:
                    return INPUT_RIGHT;
            }
        }
    }
}
