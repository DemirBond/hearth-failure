package com.szg_tech.hearthfailure.core.views.modal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.modal.text_size_dialog.TextSizeDialog;

public class AlertModalManager {
    private static void createAndShowModalAlertDialog(Context context, int titleTextId, int descriptionTextId,
                                                      int ctaButtonTextId, View.OnClickListener onClickListener, boolean isButtonRed) {
        createAndShowModalAlertDialog(context, titleTextId, descriptionTextId, ctaButtonTextId, R.string.cancel, onClickListener, isButtonRed);
    }

    public static void createAndShowModalAlertDialog(Context context, int titleTextId, int descriptionTextId,
                                                     int ctaButtonTextId, View.OnClickListener onClickListener) {
        createAndShowModalAlertDialog(context, titleTextId, descriptionTextId, ctaButtonTextId, R.string.cancel, onClickListener, true);
    }


    private static void createAndShowModalAlertDialog(Context context, int titleTextId, int descriptionTextId,
                                                      int ctaButtonTextId, int cancelButtonTextId,
                                                      View.OnClickListener onCtaClickLister) {
        createAndShowModalAlertDialog(context, titleTextId, descriptionTextId, ctaButtonTextId, cancelButtonTextId, onCtaClickLister, true);
    }

    private static void createAndShowModalAlertDialog(Context context, int titleTextId, int descriptionTextId,
                                                      int ctaButtonTextId, int cancelButtonTextId,
                                                      View.OnClickListener onCtaClickLister, boolean isButtonRed) {
        createAndShowModalAlertDialog(context, titleTextId, descriptionTextId, ctaButtonTextId, cancelButtonTextId,
                onCtaClickLister, null, isButtonRed);
    }

    private static void createAndShowModalAlertDialog(Context context, int titleTextId, int descriptionTextId,
                                                      int ctaButtonTextId, int cancelButtonTextId,
                                                      View.OnClickListener onCtaClickLister,
                                                      View.OnClickListener onCancelClickListener, boolean isButtonRed) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.alert_modal, null, false);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(dialogView)
                .create();
        ((TextView) dialogView.findViewById(R.id.title)).setText(titleTextId);
        ((TextView) dialogView.findViewById(R.id.description)).setText(descriptionTextId);

        TextView ctaButton = ((TextView) dialogView.findViewById(R.id.cta_button));
        if (!isButtonRed) {
            ctaButton.setBackgroundResource(R.drawable.blue_button_selector);
        }
        ctaButton.setText(ctaButtonTextId);
        ctaButton.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (onCtaClickLister != null) {
                onCtaClickLister.onClick(v);
            }
        });

        TextView cancelButton = ((TextView) dialogView.findViewById(R.id.cancel_button));
        cancelButton.setText(cancelButtonTextId);
        cancelButton.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (onCancelClickListener != null) {
                onCancelClickListener.onClick(v);
            }
        });
        alertDialog.show();
    }

    public static void createAndShowCancelEvaluationAlertDialog(Context context, View.OnClickListener onClickListener) {
        createAndShowModalAlertDialog(context, R.string.cancel_evaluation_popup_title, R.string.cancel_evaluation_popup_description,
                R.string.yes_im_sure, onClickListener, false);
    }

    public static void createAndShowReferToHeartFailureSpecialistAlertDialog(Context context, View.OnClickListener onClickListener,
                                                                             View.OnClickListener onCancelClickListener) {
        createAndShowModalAlertDialog(context, R.string.warning, R.string.refer_to_heart_failure_spec,
                R.string.yes, R.string.not_now, onClickListener, onCancelClickListener, true);
    }

    public static void createAndShowSaveEvaluationAlertDialog(Context context, View.OnClickListener onClickListener,
                                                                             View.OnClickListener onCancelClickListener) {
        createAndShowModalAlertDialog(context, R.string.warning, R.string.ask_if_user_wants_to_saved_evaluation,
                R.string.yes, R.string.not_now, onClickListener, onCancelClickListener, true);
    }

    public static void createAndShowDependsOnSectionAlertDialog(Context context, String sectionName, View.OnClickListener onClickListener) {
        Resources resources = context.getResources();
        String title = String.format(resources.getString(R.string.section_required_title), sectionName);
        String description = String.format(resources.getString(R.string.section_required_description), sectionName);
        String ctaText = String.format(resources.getString(R.string.section_required_cta_text), sectionName);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.alert_modal, null, false);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(dialogView)
                .create();
        ((TextView) dialogView.findViewById(R.id.title)).setText(title);
        ((TextView) dialogView.findViewById(R.id.description)).setText(description);

        TextView ctaButton = ((TextView) dialogView.findViewById(R.id.cta_button));
        ctaButton.setBackgroundResource(R.drawable.blue_button_selector);
        ctaButton.setText(ctaText);
        ctaButton.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(v);
            }
        });

        TextView cancelButton = ((TextView) dialogView.findViewById(R.id.cancel_button));
        cancelButton.setText(R.string.cancel);
        cancelButton.setOnClickListener(v -> alertDialog.dismiss());
        alertDialog.show();
    }

    public static void createAndShowThreeButtonDependsOnDialog(Context context, View.OnClickListener onTopButtonClick, View.OnClickListener onMiddleButtonClick) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.three_button_alert_modal, null, false);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(dialogView)
                .create();
        ((TextView) dialogView.findViewById(R.id.title)).setText(R.string.warning);

        TextView topCtaButton = ((TextView) dialogView.findViewById(R.id.top_cta_button));
        topCtaButton.setBackgroundResource(R.drawable.blue_button_selector);
        topCtaButton.setText(R.string.three_button_alert_top_button_text);
        topCtaButton.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (onTopButtonClick != null) {
                onTopButtonClick.onClick(v);
            }
        });

        TextView middleCtaButton = ((TextView) dialogView.findViewById(R.id.middle_cta_button));
        middleCtaButton.setBackgroundResource(R.drawable.blue_button_selector);
        middleCtaButton.setText(R.string.three_button_alert_middle_button_text);
        middleCtaButton.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (onMiddleButtonClick != null) {
                onMiddleButtonClick.onClick(v);
            }
        });

        TextView cancelButton = ((TextView) dialogView.findViewById(R.id.cancel_button));
        cancelButton.setText(R.string.none);
        cancelButton.setOnClickListener(v -> alertDialog.dismiss());
        alertDialog.show();
    }

    public static void createAndShowCancelScreenInputDialog(Context context, View.OnClickListener onClickListener) {
        createAndShowModalAlertDialog(context, R.string.warning, R.string.cancel_screen_alert_message,
                R.string.cancel_screen_alert_cancel_all, R.string.cancel, onClickListener);
    }

    public static void createAndShowChangeFontDialog(Activity activity) {
        TextSizeDialog textSizeDialog = new TextSizeDialog();
        textSizeDialog.show(activity.getFragmentManager(), TextSizeDialog.class.getSimpleName());
    }

    public static void createAndShowNoInternetConnectionAlertDialog(Context context, View.OnClickListener onClickListener) {
        createAndShowModalAlertDialog(context, R.string.warning, R.string.cancel_evaluation_popup_description,
                R.string.exit_app, onClickListener, false);
    }
}
