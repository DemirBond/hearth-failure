package com.szg_tech.hearthfailure.core.views.modal;

import android.app.Activity;
import android.app.ProgressDialog;

import com.szg_tech.hearthfailure.R;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class ProgressModalManager {

    private static ProgressDialog createAndShowSimpleProgressDialog(Activity activity, String text) {
        final ProgressDialog progressDialog = new ProgressDialog(activity,
                R.style.AuthenticationProgressDialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(text);
        progressDialog.show();
        return progressDialog;
    }

    public static ProgressDialog createAndShowLoginProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.authenticating_progress_message));
    }

    public static ProgressDialog createAndShowRegisterProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.registering_progress_message));
    }

    public static ProgressDialog createAndShowComputeEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.compute_evaluation_progress_message));
    }

    public static ProgressDialog createAndShowRetrieveSavedEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_saved_evaluations));
    }

    public static ProgressDialog createAndShowRetrieveEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_the_evaluation));
    }
}
