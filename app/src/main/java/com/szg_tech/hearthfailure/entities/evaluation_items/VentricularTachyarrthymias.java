package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by ahmetkucuk on 5/20/17.
 */

public class VentricularTachyarrthymias extends SectionEvaluationItem {

    public VentricularTachyarrthymias(Context context) {
        super(context, ConfigurationParams.VENTRICULAR_TACHYARRTHYMIAS, null, false);
        this.evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.ventricular_tachyarrthymias);
        sectionElementState = SectionElementState.OPENED;
    }


    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(context, ConfigurationParams.NSVT, context.getString(R.string.nsvt), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.MONOMORPHIC_VT, context.getString(R.string.monomorphic_vt), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.REPETITIVE_MONOMORPHIC_VT, context.getString(R.string.repetitive_monomorphic_vt), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.POLYMORPHIC_VT, context.getString(R.string.polymorphic_vt), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.TORSADES, context.getString(R.string.torsades), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.INCESSANT_VT, context.getString(R.string.incessant_vt), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC_VT, context.getString(R.string.idiopathic_vt), false));

            }
        };
    }
}
