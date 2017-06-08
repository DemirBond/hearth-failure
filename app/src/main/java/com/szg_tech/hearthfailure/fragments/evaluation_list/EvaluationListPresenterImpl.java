package com.szg_tech.hearthfailure.fragments.evaluation_list;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.evaluation.EvaluationActivity;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.core.ListRecyclerViewAdapter;
import com.szg_tech.hearthfailure.core.views.modal.AlertModalManager;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TabEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_items.HeartSpecialistManagement;
import com.szg_tech.hearthfailure.fragments.output.OutputFragment;
import com.szg_tech.hearthfailure.fragments.tab_fragment.TabFragment;
import com.szg_tech.hearthfailure.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.Map;

class EvaluationListPresenterImpl extends AbstractPresenter<EvaluationListView> implements EvaluationListPresenter {
    private ArrayList<SectionEvaluationItem> nextSectionEvaluationItemArrayList;
    private String actionBarSubtitle;
    private ListRecyclerViewAdapter listRecyclerViewAdapter;
    private ArrayList<EvaluationItem> evaluationItems;
    private ArrayList<Object> valuesDump = new ArrayList<>();
    private EvaluationItem evaluationItem;

    EvaluationListPresenterImpl(EvaluationListView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            Bundle arguments = getView().getArguments();
            if (arguments != null) {
                onNewEvaluationList(recyclerView, activity, arguments);
            }
        }
    }

    private void onNewEvaluationList(RecyclerView recyclerView, Activity activity, Bundle arguments) {

        evaluationItem = (EvaluationItem) arguments.getSerializable(ConfigurationParams.NEXT_SECTION);
        evaluationItems = evaluationItem.getEvaluationItemList();
        listRecyclerViewAdapter = new ListRecyclerViewAdapter(activity, evaluationItems, createValuesDump());
        recyclerView.setAdapter(listRecyclerViewAdapter);
        String actionBarTitle = evaluationItem.getName();
        if (!activity.getResources().getString(R.string.evaluation).equals(actionBarTitle)) {
            listRecyclerViewAdapter.setParentTitle(actionBarTitle);
        }
        actionBarSubtitle = arguments.getString(ConfigurationParams.SUBTITLE);
        if (arguments.getBoolean(ConfigurationParams.SHOULD_SHOW_ALERT)) {
            AlertModalManager.createAndShowReferToHeartFailureSpecialistAlertDialog(activity, v -> {
                popBackStack();
                if (activity instanceof EvaluationActivity) {
                    HeartSpecialistManagement heartSpecialistManagement = ((EvaluationActivity) activity).getHeartSpecialistManagement();
                    EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                    Bundle bundle = new Bundle();

                    recursiveFillSection(heartSpecialistManagement, EvaluationDAO.getInstance().loadValues());

                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION, heartSpecialistManagement);
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, new ArrayList<SectionEvaluationItem>() {{
                        add(new SectionEvaluationItem(activity, ConfigurationParams.PAH_COMPUTE_EVALUATION, activity.getResources().getString(R.string.compute_evaluation), false, new ArrayList<>()));
                    }});

                    evaluationListFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, evaluationListFragment)
                            .addToBackStack(getSupportFragmentManager().getClass().getSimpleName() + heartSpecialistManagement.getName())
                            .commit();
                }
            }, v ->  {
                EvaluationDAO.getInstance().addToHashMap(ConfigurationParams.IS_PAH, false);
                popBackStack();
            });
        }

        nextSectionEvaluationItemArrayList = (ArrayList<SectionEvaluationItem>) arguments.getSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS);
        if ((nextSectionEvaluationItemArrayList != null && nextSectionEvaluationItemArrayList.size() >= 1)
                && !ConfigurationParams.PULMONARY_HYPERTENSION.equals(evaluationItem.getId())) {
            SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
            if (nextSectionEvaluationItem.getId().equals(ConfigurationParams.PULMONARY_HYPERTENSION)) {
                if (!ConfigurationParams.VALVULAR_HEART_DISEASE_SEC.equals(evaluationItem.getId())) {
                    nextSectionEvaluationItemArrayList.remove(0);
                }
            }
            getView().getBottomButton().setText(nextSectionEvaluationItemArrayList.get(0).getName());
            listRecyclerViewAdapter.addNextSectionEvaluationItems(nextSectionEvaluationItemArrayList);
        } else {
            getView().getBottomButton().setVisibility(View.GONE);
        }
    }

    private void recursiveFillSection(EvaluationItem tempEvaluationItem, Map<String, Object> valueHashMap) {
        ArrayList<EvaluationItem> evaluationItems = tempEvaluationItem.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                Object value = valueHashMap.get(evaluationItem.getId());
                if (value != null) {
                    evaluationItem.setValue(value);
                }
                recursiveFillSection(evaluationItem, valueHashMap);
            }
        }
    }

    private ArrayList<Object> createValuesDump() {
        for (int i = 0; i < evaluationItems.size(); i++) {
            valuesDump.add(evaluationItems.get(i).getValue());
        }
        return valuesDump;
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            if (activity instanceof EvaluationActivity) {
                ((EvaluationActivity) activity).setOnBackPressedListener(() -> {
                    if (listRecyclerViewAdapter.isScreenValid()) {
                        listRecyclerViewAdapter.saveAllValues();
                        popBackStack();
                    } else {
                        showAlertToClearInputs(activity);
                    }
                });
            }

            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(evaluationItem.getName());
                if (actionBarSubtitle == null) {
                    actionBar.setSubtitle("");
                } else {
                    actionBar.setSubtitle(actionBarSubtitle);
                }
            }

            if (ConfigurationParams.EVALUATION.equals(evaluationItem.getId())) {
                if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                    if (EvaluationDAO.getInstance().isEmpty()) {
                        showSaveSnackbar();
                    }
                    EvaluationDAO.getInstance().saveValues();
                }
            }
            setActionBarColor((AppCompatActivity) activity);
        }
    }

    private void setActionBarColor(AppCompatActivity activity) {
        int actionBarColor = ContextCompat.getColor(activity, R.color.pale_lavender);
        int statusBarColor = ContextCompat.getColor(activity, R.color.pale_lavender_dark);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.setStatusBarColor(statusBarColor);
        }
    }

    @Override
    public void onPause() {
        if (listRecyclerViewAdapter.isScreenValid()) {
            listRecyclerViewAdapter.saveAllValues();
        }
        if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
            if (EvaluationDAO.getInstance().isEmpty()) {
                showSaveSnackbar();
            }
            EvaluationDAO.getInstance().saveValues();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Activity activity = getActivity();
        switch (item.getItemId()) {
            case android.R.id.home:
                if (listRecyclerViewAdapter.isScreenValid()) {
                    listRecyclerViewAdapter.saveAllValues();
                    popBackStack();
                } else {
                    if (activity != null) {
                        showAlertToClearInputs(activity);
                    }
                }
                break;
            case R.id.home:
                if (listRecyclerViewAdapter.isScreenValid()) {
                    listRecyclerViewAdapter.saveAllValues();
                    if (activity instanceof EvaluationActivity) {
                        int pahPosition = PAHpositionInBackStack();
                        if(pahPosition > 0) {
                            popBackStack(pahPosition);
                        } else {
                            ((EvaluationActivity) activity).createHomeScreen(false);
                        }
                    }
                } else {
                    showSnackbarBottomButtonError(activity);
                }
                break;
            case R.id.reset_field:
                //TODO Implement reset fields
//                if (listRecyclerViewAdapter.isScreenValid()) {
//                    resetValuesForEvaluationItem();
//                }
                break;
        }
        return true;
    }


    private void resetValuesForEvaluationItem() {
        if(evaluationItems != null) {

            for (int i = 0; i < evaluationItems.size(); i++) {
                evaluationItems.get(i).setValue(valuesDump.get(i));
            }
            setListRecyclerViewAdapter();
        }
    }

    private void setListRecyclerViewAdapter() {
        Activity activity = getActivity();
        if (activity != null) {
            RecyclerView recyclerView = getView().getRecyclerView();
            if(recyclerView != null) {
                listRecyclerViewAdapter = new ListRecyclerViewAdapter(getActivity(), evaluationItems, createValuesDump());
                getView().getRecyclerView().setAdapter(listRecyclerViewAdapter);
            }
        }
    }


    private void showAlertToClearInputs(Activity activity) {
        AlertModalManager.createAndShowCancelScreenInputDialog(activity, v -> {
            for (int i = 0; i < evaluationItems.size(); i++) {
                evaluationItems.get(i).setValue(valuesDump.get(i));
            }
            popBackStack();
        });
    }

    private void showSnackbarBottomButtonError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonMinimumNotEnteredError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_error_minimum_not_entered, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    @Override
    public void onBottomButtonClick() {
        Activity activity = getActivity();
        if (listRecyclerViewAdapter.isScreenValid(false)) {
            listRecyclerViewAdapter.saveAllValues();
            if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                if (EvaluationDAO.getInstance().isEmpty()) {
                    showSaveSnackbar();
                }
                EvaluationDAO.getInstance().saveValues();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, new ArrayList<>(nextSectionEvaluationItemArrayList.subList(1, nextSectionEvaluationItemArrayList.size())));
                if (nextSectionEvaluationItemArrayList.size() >= 1 && nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().size() == 1 && nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0) instanceof TabEvaluationItem) {
                    TabFragment tabFragment = new TabFragment();
                    bundle.putSerializable(ConfigurationParams.TAB_SECTION_LIST, ((TabEvaluationItem) nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0)).getTabSectionList());
                    tabFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, tabFragment)
                            .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItemArrayList.get(0).getName())
                            .commit();
                    if (nextSectionEvaluationItemArrayList.get(0).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                        nextSectionEvaluationItemArrayList.get(0).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                    }
                } else if (nextSectionEvaluationItemArrayList.size() >= 1) {
                    Fragment nextFragment = new EvaluationListFragment();
                    SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
                    if (ConfigurationParams.COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId()) || ConfigurationParams.PAH_COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId())) {

                        if(EvaluationDAO.getInstance().isMinimumToSaveEntered()) {

                            if(ConfigurationParams.PAH_COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId())) {
                                EvaluationDAO.getInstance().addToHashMap(ConfigurationParams.IS_PAH, true);
                            } else {
                                EvaluationDAO.getInstance().addToHashMap(ConfigurationParams.IS_PAH, false);
                            }

                            fragmentManager.beginTransaction()
                                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                    .replace(R.id.container, new OutputFragment())
                                    .addToBackStack(OutputFragment.class.getSimpleName())
                                    .commit();
                        } else {
                            showSnackbarBottomButtonMinimumNotEnteredError(getActivity());
                        }
                    } else {
//                        if (nextSectionEvaluationItem.getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
//                            nextSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
//                        }
                        bundle.putSerializable(ConfigurationParams.NEXT_SECTION, nextSectionEvaluationItem);
                        nextFragment.setArguments(bundle);
                        if (nextSectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                            nextSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                        }
                        fragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                .replace(R.id.container, nextFragment)
                                .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItem.getName())
                                .commit();
                    }
                }
            }
        } else {
            if (activity != null) {
                showSnackbarBottomButtonError(activity);
            }
        }
    }

    private void showSaveSnackbar() {
        Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.saved, Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();
        ((SnackbarContentLayout) snackbarView.getChildAt(0)).setGravity(Gravity.CENTER);
        ((FrameLayout.LayoutParams) snackbarView.getChildAt(0).getLayoutParams()).gravity = Gravity.CENTER;
        snackbarView.getLayoutParams().height = getView().getBottomButton().getHeight();
        TextView snackBarTextView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackBarTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackBarTextView.setGravity(Gravity.CENTER);
        ((LinearLayout.LayoutParams) snackBarTextView.getLayoutParams()).gravity = Gravity.CENTER;
        Activity activity = getActivity();
        if (activity != null) {
            try {
                float textSizeDimension = activity.getResources().getDimension(R.dimen.snackbar_textsize);
                snackBarTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeDimension);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
        snackbar.show();
    }
}
