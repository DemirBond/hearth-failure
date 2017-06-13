package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class MajorCVRisk extends SectionEvaluationItem {
    MajorCVRisk(Context context) {
        super(context, ConfigurationParams.MAJOR_CV_RISK, null, false);
        name = context.getString(R.string.cv_risk);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DIABETES, context.getString(R.string.diabetes), false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.TYPE_2_DM, context.getString(R.string.type_2_dm), false, new ArrayList<EvaluationItem>() {
                            //{
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMNP, "Diabetic Nephropathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMCKD, "Diabetic CKD", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMOTHER,"Other kidney complications", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMMONO, "Diabetic mononeuropathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMPOLY, "Diabetic polyneuropathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMAUTONOM, "Diabetic autonom neuropathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMANGIO, "Peripheral angiopathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMOTHERCIRC, "Other circulatory complications", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMGANGRENE, "Angiopathy with gangrene", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMARTHRO, "Diabetic arthropathy", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMSKIN, "Diabetic skin complications", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMORAL, "Diabetic oral complications", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMHYPO, "Hypoglycemia", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMHYPOCOMA, "Hypoglycemia with coma", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMHYPER, "Hyperglycemia", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMOTHERCOMP, "Other specified complications", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMUNSPEC, "Unspecified complications", false));

                                //add(new BooleanEvaluationItem(context, ConfigurationParams.DMWITHOUT, " Without complications", false));
                            //}
                        //}));



                        //add(new BooleanEvaluationItem(context, ConfigurationParams.GESTATIONAL_DM, context.getString(R.string.gestational_dm), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RETINOPATHY, context.getString(R.string.retinopathy), false));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYSTEMIC_ARTERIAL_HYPERTENSION, context.getString(R.string.systemic_arterial_hypertension), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.AMB_SBP, context.getString(R.string.amb_sbp), context.getString(R.string.value), 80, 190, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.AMB_DBP, context.getString(R.string.amb_dbp), context.getString(R.string.value), 30, 150, false, true));
                        add(new BoldEvaluationItem(context, ConfigurationParams.CHECK_LVH_ON_EKG, context.getString(R.string.check_lvh_on_ekg), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SBP_TREATED, context.getString(R.string.sbp_treated), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AFRICAN_AMERICAN, context.getString(R.string.african_american), false));
                        add(new BoldEvaluationItem(context, ConfigurationParams.SECONDARY_HYPERTENSION, "Secondary hypertension", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRIMARY_HYPERALDESTERONISM, context.getString(R.string.primary_hyperaldesteronism), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.RENOVASCULAR_ATHEROSCLEROTIC, context.getString(R.string.renovascular_atherosclerotic), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PHEOCROMOCYTOMA, context.getString(R.string.pheocromocytoma), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.OSA, context.getString(R.string.osa), false));
                        add(new BoldEvaluationItem(context, ConfigurationParams.ACUTELY_SYMPTOMATIC, context.getString(R.string.acutely_symptomatic), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEADACHED_BLURRED_VISION_OR_AMS, context.getString(R.string.headached_blurred_vision_or_ams), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EPISTAXIS, context.getString(R.string.epistaxis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_BACK_PAIN_DYSPNEA, context.getString(R.string.chest_back_pain_dyspnea), false));
                    }
                }));
                add(new BooleanEvaluationItem(context, ConfigurationParams.TOBACCO_USE, context.getString(R.string.tobacco_use), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILY_HISTORY, context.getString(R.string.family_history), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.CKD, context.getString(R.string.ckd), false));
            }
        };
    }
}
