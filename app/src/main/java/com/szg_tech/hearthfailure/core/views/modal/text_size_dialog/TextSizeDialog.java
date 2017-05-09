package com.szg_tech.hearthfailure.core.views.modal.text_size_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;

public class TextSizeDialog extends DialogFragment {
    private float scale;
    private ImageView underline12;
    private ImageView underline16;
    private ImageView underline20;
    private ImageView underline24;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scale = getActivity().getResources().getDisplayMetrics().density;
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_font_dialog, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Dialog dialog = getDialog();
        Window window = dialog.getWindow();
        if (window != null) {
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
            window.setAttributes(lp);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView fontSize12 = (TextView) view.findViewById(R.id.font_size_12);
        increaseTouchRegion(fontSize12);
        TextView fontSize16 = (TextView) view.findViewById(R.id.font_size_16);
        increaseTouchRegion(fontSize16);
        TextView fontSize20 = (TextView) view.findViewById(R.id.font_size_20);
        increaseTouchRegion(fontSize20);
        TextView fontSize24 = (TextView) view.findViewById(R.id.font_size_24);
        increaseTouchRegion(fontSize24);

        underline12 = (ImageView) view.findViewById(R.id.underline_12);
        underline16 = (ImageView) view.findViewById(R.id.underline_16);
        underline20 = (ImageView) view.findViewById(R.id.underline_20);
        underline24 = (ImageView) view.findViewById(R.id.underline_24);
        View spaceView = view.findViewById(R.id.space);
        Activity activity = getActivity();
        if (activity != null) {
            float textDelta = PreferenceHelper.getTextDelta(activity);
            underlineCurrent(textDelta);
            spaceView.setOnClickListener(v -> dismiss());
            fontSize12.setOnClickListener(v -> {
                        initBasicTextSize(activity, 12);
                        underlineCurrent(-4);
                    }
            );
            fontSize16.setOnClickListener(v -> {
                initBasicTextSize(activity, 16);
                underlineCurrent(0);
            });
            fontSize20.setOnClickListener(v -> {
                initBasicTextSize(activity, 20);
                underlineCurrent(4);
            });
            fontSize24.setOnClickListener(v -> {
                initBasicTextSize(activity, 24);
                underlineCurrent(8);
            });
        }
    }

    public void increaseTouchRegion(View view) {
        final View parent = (View) view.getParent();
        parent.post(() -> {
            final Rect r = new Rect();
            view.getHitRect(r);
            r.top -= view.getMinimumHeight() / 2;
            r.bottom += view.getMinimumHeight() / 2;
            r.left -= view.getMinimumWidth() / 2;
            r.right += view.getMinimumWidth() / 2;
            parent.setTouchDelegate(new TouchDelegate(r, view));
        });
    }

    public void underlineCurrent(float textDelta) {
        switch ((int) textDelta) {
            case -4:
                underline12.setVisibility(View.VISIBLE);
                underline16.setVisibility(View.GONE);
                underline20.setVisibility(View.GONE);
                underline24.setVisibility(View.GONE);
                break;
            case 4:
                underline12.setVisibility(View.GONE);
                underline16.setVisibility(View.GONE);
                underline20.setVisibility(View.VISIBLE);
                underline24.setVisibility(View.GONE);
                break;
            case 8:
                underline12.setVisibility(View.GONE);
                underline16.setVisibility(View.GONE);
                underline20.setVisibility(View.GONE);
                underline24.setVisibility(View.VISIBLE);
                break;
            case 0:
            default:
                underline12.setVisibility(View.GONE);
                underline16.setVisibility(View.VISIBLE);
                underline20.setVisibility(View.GONE);
                underline24.setVisibility(View.GONE);
                break;
        }
    }

    private static void initBasicTextSize(Activity activity, int i) {
        Intent intent = new Intent(ConfigurationParams.ACTION_CHANGE_SIZE);
        intent.putExtra(ConfigurationParams.SIZE, i);
        activity.sendBroadcast(intent);
    }
}
