package com.szg_tech.hearthfailure.activities.evaluation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.core.views.modal.AlertModalManager;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_items.Evaluation;
import com.szg_tech.hearthfailure.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.hearthfailure.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;

class EvaluationActivityPresenterImpl extends AbstractPresenter<EvaluationActivityView> implements EvaluationActivityPresenter {
    private Evaluation evaluation;
    private HashMap<String, Object> valueHashMap;

    EvaluationActivityPresenterImpl(EvaluationActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        createHomeScreen(true);
        Activity activity = getActivity();
        if (activity != null) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void createHomeScreen(boolean isAdd) {
        Activity activity = getActivity();
        if (activity != null) {
            EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
            Bundle bundle = new Bundle();
            if (evaluation == null) {
                evaluation = new Evaluation(activity);
            }
            valueHashMap = EvaluationDAO.getInstance().loadValues();
            System.out.println(valueHashMap);
            if (!valueHashMap.isEmpty()) {
                recursiveFillSection(evaluation);
            }

            bundle.putSerializable(ConfigurationParams.NEXT_SECTION, evaluation);
            bundle.putSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, new ArrayList<SectionEvaluationItem>() {{
                add(new SectionEvaluationItem(activity, ConfigurationParams.COMPUTE_EVALUATION, activity.getResources().getString(R.string.compute_evaluation), false, new ArrayList<>()));
            }});
            evaluationListFragment.setArguments(bundle);
            if (isAdd) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, evaluationListFragment)
                        .commit();
            } else {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0
                        && !getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName().equals(EvaluationActivityPresenterImpl.class.getSimpleName())) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, evaluationListFragment)
                            .addToBackStack(EvaluationActivityPresenterImpl.class.getSimpleName())
                            .commit();
                }
            }
        }
    }

    private void recursiveFillSection(EvaluationItem tempEvaluationItem) {
        ArrayList<EvaluationItem> evaluationItems = tempEvaluationItem.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                Object value = valueHashMap.get(evaluationItem.getId());
                if (value != null) {
                    evaluationItem.setValue(value);
                }
                recursiveFillSection(evaluationItem);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    Activity activity = getActivity();
                    if (activity != null) {
                        AlertModalManager.createAndShowCancelEvaluationAlertDialog(activity, v -> NavUtils.navigateUpFromSameTask(activity));
                    }
                    return true;
                }
                break;
            case R.id.change_font:
                Activity activity = getActivity();
                if (activity != null) {
                    AlertModalManager.createAndShowChangeFontDialog(activity);
                }
                break;
            case R.id.exit_evaluation:
                if (getActivity() != null) {
                    getActivity().finish();
                }
                break;
        }
        return false;
    }



}
