package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.StringEvaluationItem;

import java.util.ArrayList;

class Bio extends SectionEvaluationItem {

    Bio(Context context) {
        super(context, ConfigurationParams.BIO, null, false);
        name = context.getString(R.string.bio);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new StringEvaluationItem(context, ConfigurationParams.NAME, context.getString(R.string.name), context.getString(R.string.name_hint), true, null));
                add(new NumericalEvaluationItem(context, ConfigurationParams.AGE, context.getString(R.string.age), context.getString(R.string.age_hint), 20, 100, true, true));
                add(new SectionPlaceholderEvaluationItem(context, ConfigurationParams.GENDER, context.getString(R.string.gender), context.getString(R.string.male), false,
                        new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.MALE, context.getString(R.string.male), ConfigurationParams.GENDER, false, true));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.FEMALE, context.getString(R.string.female), ConfigurationParams.GENDER, false, false));
                            }
                        }));
                add(new NumericalEvaluationItem(context, ConfigurationParams.BMI, context.getString(R.string.bmi), context.getString(R.string.enter_bmi_value), 10, 50, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.WEIGHT, context.getString(R.string.weight), context.getString(R.string.weight_hint), 40, 400, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.HEART_RATE, context.getString(R.string.heart_rate), context.getString(R.string.heart_rate_hint), 30, 300, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.SBP, context.getString(R.string.sbp), context.getString(R.string.sbp_hint), 60, 300, true, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.DBP, context.getString(R.string.dbp), context.getString(R.string.dbp_hint), 30, 160, true, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.ORTHOSTATIC_SBP, context.getString(R.string.orthostatic_sbp), context.getString(R.string.value), 0, 240, false,true));
                add(new BooleanEvaluationItem(context, ConfigurationParams.ORTHOSTATIC_SYMPTOMPS, context.getString(R.string.orthostatic_symptomps), false));
                add(new NumericalEvaluationItem(context, ConfigurationParams.WAIST_CIRC, context.getString(R.string.waist_circ), context.getString(R.string.value), 20, 60, false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.AA, context.getString(R.string.aa), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.PREGNANCY, context.getString(R.string.pregnancy), false));
                //add(new NumericalEvaluationItem(context, ConfigurationParams.RASAT, context.getString(R.string.ra_o2_sat), context.getString(R.string.value), 50, 100, false, true));

            }
        };
    }
}
