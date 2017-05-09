package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class ReviewOfSystems extends SectionEvaluationItem {
    ReviewOfSystems(Context context) {
        super(context, ConfigurationParams.REVIEW_OF_SYSTEMS, null, false);
        name = context.getString(R.string.review_of_systems);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {{
            add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_CHANGE, "Weight gain", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.THYROTOXICOSIS, "Thyrotoxicosis", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.HYPOTHYRO, "Hypothyroidism", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.OSA , "Obstructive sleep apnea", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.HEMOPTYSIS, "Hemoptysis" ,false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PREVIOUS_DVTE, "Previous pulmonary embolism" ,false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PND, "Paroxysmal nocturnal dyspnea", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.ORTHOPNEA, "Orthopnea", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PALPITATIONS, context.getString(R.string.palpitations), false));



            add(new BooleanEvaluationItem(context, ConfigurationParams.ACTIVE_PEPTIC_ULCER_DISEASE, context.getString(R.string.active_peptic_ulcer_disease), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.LIVER_DISEASE, context.getString(R.string.liver_disease), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.BLEED_IN_THE_PAST_3_MONTHS, "Bleeding in the past 3 months", false));

            add(new BooleanEvaluationItem(context, ConfigurationParams.TIA, "Transient ischemic attack", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.CLAUDICATION, "Claudication", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.ULCER, "Lower extremity ulceration", false));

            add(new BooleanEvaluationItem(context, ConfigurationParams.UNILATERAL_LOWER_LIMB_PAIN, "Unilateral lower limb pain", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PREVIOUS_DVT_PE, "Previous DVT", false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.RHEUMATIC_DISEASE, "Rheumatic disease", false));
        }};
    }
}
