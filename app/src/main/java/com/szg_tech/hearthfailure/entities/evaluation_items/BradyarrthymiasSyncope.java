package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by ahmetkucuk on 5/20/17.
 */

public class BradyarrthymiasSyncope extends SectionEvaluationItem {

    public BradyarrthymiasSyncope(Context context) {
        super(context, ConfigurationParams.BRADYARRTHYMIA_SYNCOPE, null, false);
        evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.bradyarrthymia_syncope);
        sectionElementState = SectionElementState.OPENED;
    }
    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(context, ConfigurationParams.SYNCOPE, "CLINICAL SYNCOPE", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.SYMPTOMATIC_SINUS_NODE_DYSFUNCTION, context.getString(R.string.symptomatic_sinus_node_dysfunction), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.HIGH_GRADE_AV_NODE_DISEASE, context.getString(R.string.high_grade_av_node_disease), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.ISOLATED_NEUROCARDIOGENIC_UNEXPLAINED_SYNCOPE, context.getString(R.string.isolated_neurocardiogenic_unexplained_syncope), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.CAROTID_SINUS_HYPERSENSITIVITY, context.getString(R.string.carotid_sinus_hypersensitivity), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.POTS, context.getString(R.string.pots), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.AUTONOMIC_FAILURE_SYNDROME, context.getString(R.string.autonomic_failure_syndrome), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.HISTORY_OF_CARDIAC_ARREST, context.getString(R.string.history_of_cardiac_arrest), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.BRUGADA_SYNDROME, context.getString(R.string.brugada_syndrome), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.LONG_QT, "Long QT syndrome", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.SARCOIDOSIS_GIANT_CELL_CHAGAS, context.getString(R.string.sarcoidosis_giant_cell_chagas), false));
            }
        };
    }
}
