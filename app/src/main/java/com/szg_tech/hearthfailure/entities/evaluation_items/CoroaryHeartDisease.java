package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by ahmetkucuk on 5/20/17.
 */

public class CoroaryHeartDisease extends SectionEvaluationItem {

    public CoroaryHeartDisease(Context context) {
        super(context, ConfigurationParams.CORONARY_HEART_DISEASE, null, false);
        this.evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.coronary_heart_disease);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ACUTE_CORONARY_SYNDROME, context.getString(R.string.acute_coronary_syndrome), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_2_ANGINA_24HR, context.getString(R.string.more_2_angina_24hr), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANGINA_MORE_20MIN, context.getString(R.string.angina_more_20min), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ASA_ACS, context.getString(R.string.asa_use_in_past_1_week), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_2_ANTANGINAL, context.getString(R.string.more_2_antanginal), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.STEMI, context.getString(R.string.stemi), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.DURATION_HOURS, context.getString(R.string.duration_hours), context.getString(R.string.value), 0, 48, false, true));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ANTERIOR, context.getString(R.string.anterior), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.INFERIOR, context.getString(R.string.inferior), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OTHER, context.getString(R.string.other), false));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.REFRACTORY_ANGINA, context.getString(R.string.refractory_angina), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGING_TROP_I, context.getString(R.string.changing_trop_i), false));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PCI_CABG, context.getString(R.string.pci_cabg), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LAST_PROCEDURE, context.getString(R.string.last_procedure), context.getString(R.string.value), 0, 50, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BMS, context.getString(R.string.bms), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DES, context.getString(R.string.des), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CABG, context.getString(R.string.cabg), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.AUTO_VEIN, context.getString(R.string.auto_vein), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.AUTO_ARTERY, context.getString(R.string.auto_artery), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NON_AUTO, context.getString(R.string.non_auto), false));
                            }
                        }));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.STABLE_ANG, context.getString(R.string.stable_ang), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_1, "NYHACCVS Class 1", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_2, "NYHACCVS Class 2", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_3, context.getString(R.string.nyha_ccvs_class_3), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_4, context.getString(R.string.nyha_ccvs_class_4), false));
                    }
                }));
                add(new BooleanEvaluationItem(context, ConfigurationParams.LM, context.getString(R.string.lm), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.LAD, context.getString(R.string.lad), false));
                //add(new BooleanEvaluationItem(context, ConfigurationParams.RCA, context.getString(R.string.rca), false));
                //add(new BooleanEvaluationItem(context, ConfigurationParams.LCX, context.getString(R.string.lcx), false));
                //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ICD_10, context.getString(R.string.icd_10), false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_TOTAL_OCCLUSION, context.getString(R.string.chronic_total_occlusion), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CORONARY_ANEURYSM, context.getString(R.string.coronary_aneurysm), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CORONARY_DISSECTION, context.getString(R.string.coronary_dissection), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CALCIFIED_CORONARY_LESION, context.getString(R.string.calcified_coronary_lesion), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.LIPID_RICH_PLAQUE, context.getString(R.string.lipid_rich_plaque), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.DOCUMENTED_VASOSPASM, context.getString(R.string.documented_vasospasm), false));
                    }
                //}));
                add(new NumericalEvaluationItem(context, ConfigurationParams.VESSEL_MORE_50, context.getString(R.string.vessel_more_50), context.getString(R.string.value), 1, 3, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF_CHD, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
            }

        };
    }
}
