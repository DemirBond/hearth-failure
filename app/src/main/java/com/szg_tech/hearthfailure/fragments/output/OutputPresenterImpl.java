package com.szg_tech.hearthfailure.fragments.output;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.evaluation.EvaluationActivity;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.core.OutputRecyclerViewAdapter;
import com.szg_tech.hearthfailure.core.views.modal.AlertModalManager;
import com.szg_tech.hearthfailure.core.views.modal.ProgressModalManager;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.HeartPartnerEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.ICOCellEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TextEvaluationItem;
import com.szg_tech.hearthfailure.rest.api.RestClientProvider;
import com.szg_tech.hearthfailure.rest.requests.EvaluationRequest;
import com.szg_tech.hearthfailure.rest.responses.EvaluationGroup;
import com.szg_tech.hearthfailure.rest.responses.EvaluationResponse;
import com.szg_tech.hearthfailure.rest.responses.Field;
import com.szg_tech.hearthfailure.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class OutputPresenterImpl extends AbstractPresenter<OutputView> implements OutputPresenter {
    private int status;

    OutputPresenterImpl(OutputView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        status = new Random().nextInt(3);
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            recyclerView.setAdapter(new OutputRecyclerViewAdapter(activity, new ArrayList<EvaluationItem>()));
            computeAndShowEvaluations(activity, recyclerView);
        }
    }

    private void showSnackbarBottomButtonGenericError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_unexpected_error_in_compute_evaluation, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonUnAuthorizedError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_session_expire_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    public void computeAndShowEvaluations(Activity activity, RecyclerView recyclerView) {

        ProgressDialog progressDialog = ProgressModalManager.createAndShowComputeEvaluationProgressDialog(getActivity());
        HashMap<String, Object> evaluationValueMap = EvaluationDAO.getInstance().loadValues();

        EvaluationRequest request = new EvaluationRequest(evaluationValueMap, true);
        System.out.println(request.toMap());
        Map map = request.toMap();
        map.put("forHF",true);
        RestClientProvider.get().getApi().computeEvaluation(map).enqueue(new Callback<EvaluationResponse>() {
            @Override
            public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {

                if(response.isSuccessful()) {
                    if(response.body().isSuccessful()) {
                        List<EvaluationItem> evaluationItems = createEvaluationList(activity, response.body());
                        recyclerView.setAdapter(new OutputRecyclerViewAdapter(activity, evaluationItems));
                    } else {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                } else {
                    if(response.code() == 401) {
                        showSnackbarBottomButtonUnAuthorizedError(activity);

                        if(activity instanceof EvaluationActivity) {
                            ((EvaluationActivity)activity).onSessionExpired();
                        }

                    } else {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                showSnackbarBottomButtonGenericError(activity);
            }
        });
    }

    @Override
    public void onReturnToEvaluationButtonClick() {
        popBackStack();
    }

    @Override
    public void onCompleteEvaluationButtonClick() {
        Activity activity = getActivity();
        if (activity != null) {
            AlertModalManager.createAndShowSaveEvaluationAlertDialog(getActivity(), v -> {
                HashMap<String, Object> evaluationValueMap = EvaluationDAO.getInstance().loadValues();
                evaluationValueMap.put("forHF", true);
                final EvaluationRequest request = new EvaluationRequest(evaluationValueMap, true);

                RestClientProvider.get().getApi().computeEvaluation(request.toMap()).enqueue(new Callback<EvaluationResponse>() {
                    @Override
                    public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                        //
                    }
                    @Override
                    public void onFailure(Call<EvaluationResponse> call, Throwable t) {

                    }
                });

                RestClientProvider.get().getApi().saveEvaluation(request.toMap()).enqueue(new Callback<EvaluationResponse>() {
                    @Override
                    public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                        //HERE
                    }
                    @Override
                    public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                    }
                });


                EvaluationDAO.getInstance().clearEvaluation();
                activity.finish();
            }, v -> {
                EvaluationDAO.getInstance().clearEvaluation();
                activity.finish();
            });
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.output);
            }
//            setActionBarColorDependingOnOutputStatus((AppCompatActivity) activity);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                popBackStack();
                break;
        }
        return true;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.home).setVisible(false);
    }

    private void setActionBarColorDependingOnOutputStatus(AppCompatActivity activity) {
        int actionBarColor;
        int statusBarColor;
//        switch (status) {
//            case 0: //BAD
//                actionBarColor = ContextCompat.getColor(activity, R.color.salmon);
//                statusBarColor = ContextCompat.getColor(activity, R.color.grapefruit);
//                break;
//            case 1: //MIDDLE
//                actionBarColor = ContextCompat.getColor(activity, R.color.dark_cream);
//                statusBarColor = ContextCompat.getColor(activity, R.color.light_gold);
//                break;
//            case 2: //GOOD
//            default:
//                actionBarColor = ContextCompat.getColor(activity, R.color.hospital_green);
//                statusBarColor = ContextCompat.getColor(activity, R.color.hospital_green_status);
//                break;
//        }

        actionBarColor = ContextCompat.getColor(activity, R.color.pale_lavender_dark);
        statusBarColor = ContextCompat.getColor(activity, R.color.pale_lavender);

        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.setStatusBarColor(statusBarColor);
        }
    }

    /**
     * TODO use special item displays e.g. HeartPartnerEvaluationItem
     *
     * @param activity
     * @param response
     * @return List of Evaluation Items to be displayed in ListView
     */
    public List<EvaluationItem> createEvaluationList(Activity activity, EvaluationResponse response) {

        List<EvaluationItem> evaluationItems = new ArrayList<>();

        for (EvaluationGroup group : response.getOutputs()) {

            evaluationItems.add(new BoldEvaluationItem(activity, ConfigurationParams.OVERVIEW, group.getGroupname(), false));
            if (group.getFields() != null) {
                for (Field f : group.getFields()) {
                    evaluationItems.add(new TextEvaluationItem(activity, f.getPar(), f.getVal(), false));
                }
            }
        }
        return evaluationItems;
    }

    public ArrayList<EvaluationItem> getSampleEvaluationList(Activity activity) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BoldEvaluationItem(activity, ConfigurationParams.OVERVIEW, activity.getString(R.string.overview), false));
                add(new TextEvaluationItem(activity, "temp", "This is a placeholder for a description of what the output/results may be. This can also be omitted altogether. The background color for the output will serve as a severity of the prognosis.", false));

                if (status != 2) {
                    add(new HeartPartnerEvaluationItem(activity, "heart_partner", "Emory Healthcare",
                            "Backed by more than a century of experience, Emory Healthcare with its team of physicians is an established leader in heart care and…",
                            "12:00 PM - 11:30 PM", new ArrayList<EvaluationItem>() {
                        {

                        }
                    }));
                }

                add(new BoldEvaluationItem(activity, ConfigurationParams.DIAGNOSTICS, activity.getString(R.string.diagnostics), false));
                add(new TextEvaluationItem(activity, "temp", "This is a placeholder for a description of what the output/results may be. This can also be omitted altogether. The background color for the output will serve as a severity of the prognosis.", false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.THERAPEUTICS, activity.getString(R.string.therapeutics), false));
                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.ICD_10, activity.getString(R.string.icd_10), false));

                if (status == 0) {
                    add(new ICOCellEvaluationItem(activity, "i50.9", "I50.9", "Heart failure, unspecified", "ICD-10", "Billable"));
                }

                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.REFERENCES, activity.getString(R.string.references), false));
                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
            }
        };
    }
}
