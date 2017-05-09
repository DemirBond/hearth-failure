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
                add(new Symptoms(context));
                add(new ReviewOfSystems(context));
                add(new PhysicalExam(context));
                add(new CurrentCVProfile(context));
                add(new MajorCVRisk(context));
                add(new Laboratories(context));
                add(new Diagnostics(context));
                add(new SectionEvaluationItem(context, ConfigurationParams.CURRENT_THERAPIES, context.getString(R.string.current_therapies), false, new ArrayList<EvaluationItem>() {{
                    add(new POMeds(context));
                    add(new InHospitalTherapies(context));
                }}, SectionElementState.LOCKED, ConfigurationParams.BIO));
                add(new NonCardiacSurgicalRisk(context));
            }
        };
    }
}
