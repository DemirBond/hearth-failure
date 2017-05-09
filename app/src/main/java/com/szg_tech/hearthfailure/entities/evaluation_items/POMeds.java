package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class POMeds extends SectionEvaluationItem {
    POMeds(Context context) {
        super(context, ConfigurationParams.PO_MEDS, null, false);
        name = context.getString(R.string.po_meds);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.B_BLOCKER, context.getString(R.string.b_blocker), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_3125BID, context.getString(R.string.carvedilol_3125bid), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_625BID, "chkCarvedilol625", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_125BID, context.getString(R.string.carvedilol_125bid), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_25BID, context.getString(R.string.carvedilol_25bid), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_25_QD, context.getString(R.string.metoprololer_25_qd), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_50_QD, context.getString(R.string.metoprololer_50_qd), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_100_QD, context.getString(R.string.metoprololer_100_qd), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_150_QD, context.getString(R.string.metoprololer_150_qd), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_200_QD, context.getString(R.string.metoprololer_200_qd), false));
                    }
                }));
                add(new BooleanEvaluationItem(context, ConfigurationParams.ACEL_ARB, context.getString(R.string.acel_arb), false));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PO_DIURETIC, context.getString(R.string.po_diuretic), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.FUROSEMIDE_40, context.getString(R.string.furosemide_40), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.FUROSEMIDE_80, context.getString(R.string.furosemide_80), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.FUROSEMIDE_80_PLUS, context.getString(R.string.furosemide_80_plus), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BURNEX_1, context.getString(R.string.burnex_1), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BURNEX_2, context.getString(R.string.burnex_2), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BURNEX_2_PLUS, context.getString(R.string.burnex_2_plus), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TORSEMIDE_20, context.getString(R.string.torsemide_20), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TORSEMIDE_40, context.getString(R.string.torsemide_40), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TORSEMIDE_50_PLUS, context.getString(R.string.torsemide_50_plus), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HCTZ, context.getString(R.string.hctz), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.INDAPAMIDE, context.getString(R.string.indapamide), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHLORTHALIDONE_METOLAZONE, context.getString(R.string.chlorthalidone_metolazone), false));
                    }
                }));
                add(new BooleanEvaluationItem(context, ConfigurationParams.CCB_OTHER_VASOLIDATORS, context.getString(R.string.ccb_other_vasolidators), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.CURRENT_VKA_THERAPY, context.getString(R.string.current_vka_therapy), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.DIRECT_THROMBIN_INHIBITORS, context.getString(R.string.direct_thrombin_inhibitors), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.FACTOR_XA_INHIBITORS, context.getString(R.string.factor_xa_inhibitors), false));
            }
        };
    }
}
