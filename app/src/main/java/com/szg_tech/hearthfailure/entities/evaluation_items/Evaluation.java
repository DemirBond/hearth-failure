package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

public class Evaluation extends SectionEvaluationItem {

    public Evaluation(Context context) {
        super(context, ConfigurationParams.EVALUATION, null, false);
        name = context.getString(R.string.evaluation);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new Bio(context));
                add(new HeartFailure(context));
                add(new CoroaryHeartDisease(context));
                add(new AtrialFibrillation(context));
                add(new ThromboembolicCVA(context));
                add(new BradyarrthymiasSyncope(context));
                add(new VentricularTachyarrthymias(context));
                add(new MajorCVRisk(context));
                add(new Laboratories(context));
                add(new Diagnostics(context));
            }
        };
    }
}
