package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by ahmetkucuk on 5/19/17.
 */

public class HeartFailure extends SectionEvaluationItem {

    public HeartFailure(Context context) {
        super(context, ConfigurationParams.HEART_FAILURE, null, false);
        this.evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.heart_failure);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "HISTORY", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_ICD, "Status post AICD", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_BiV_PPM, "S/P BiV PPM", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_PPM_RV_LEAD_ONLY, "S/P PPM with RV Lead Only", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_ON_SET_INITIAL_EVALUATION, "NEW ONSET HF/INITIAL EVALUATION", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_HF, "CHRONIC HF", false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.HF_DIAGNOSIS_DURATION_WEEK, "Duration / week", context.getString(R.string.value), 0, 999, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ONE_OR_MORE_HF_ADMISSION, "One or More HF Admissions in 12 Months", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TWO_UNSCHEDULED_VISITS, "Two Unscheduled Visits (eg. ED or Clinic) in 12 Months", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_PAIN, "Chest Pain", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Etiology", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC_DCM_NONISCHEMIC, context.getString(R.string.idiopathic_dcm_nonischemic), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.POST_MI_MORE_45, context.getString(R.string.post_mi_more_45), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ISCHEMIC_POST_MI_LESS_45, context.getString(R.string.ischemic_post_mi_less_45), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CARDIOTOXINS, "Cardiotoxins", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.XRT, "XRT", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ANTRACYCLINES, "Antracyclines", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HISTORY_OF_SUDDEN_DEATH, context.getString(R.string.history_of_sudden_death), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.REST_DYNAMIC_PEAK, context.getString(R.string.rest_dynamic_peak), false));
                            }
                        }));

                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILIAL_CMP, context.getString(R.string.familial_cmp), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.VALVULAR_HEART_DISEASE, context.getString(R.string.valvular_heart_disease), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.RV_DYSPLASIA, context.getString(R.string.rv_dysplasia), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.HOCM, context.getString(R.string.hocm), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LVH_MORE_30, context.getString(R.string.lvh_more_30), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_BP_RESPONSE_TO_EXERCISE, context.getString(R.string.abnormal_bp_response_to_exercise), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HISTORY_OF_SUDDEN_DEATH, context.getString(R.string.history_of_sudden_death), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.REST_DYNAMIC_PEAK, context.getString(R.string.rest_dynamic_peak), false));
                            }
                        }));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Acutely Decompensated / Hospitalized", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGE_IT, context.getString(R.string.day1), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGE_IT, context.getString(R.string.day2), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGE_IT, context.getString(R.string.day3), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Pre-discharge or Discharge Day", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Clinical Presentation", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.RASAT, "RA O2sat%", context.getString(R.string.value), 10, 80, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.CHANGE_IT, "CV/ SVO2sat%", context.getString(R.string.value), 10, 80, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "Weight Gain", false));

                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_ON_EXERTION, "Dyspnea on Exertion, not at Rest", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_AT_REST, "Dyspnea at Rest / Orthopnea", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HJR, "Hepatojugular Reflux", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.JUGULAR_VENOUS_DISTENTION, "Jugular Venous Distention", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EDEMA, "Edema/Ascites", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_SIDED_S3, "Left Sided Gallop", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_RALES, "New Rales", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EDEMA, "Pulmonary Edema", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Low Urine Output < 30ml/hr", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANY_CNS_SYMPTOMS, "Any CNS Symptoms", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COLD_CLAMMY_EXTERMITIES, "Cold Clammy Extremities", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CYANOSIS, "Cyanosis", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "AHA Stage", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AT_HIGH_RISK, context.getString(R.string.at_high_risk), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NO_SIGNS_OF_HF, context.getString(R.string.no_signs_of_hf), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYMPTOMS_OF_HF, context.getString(R.string.symptoms_of_hf), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.REFRACTORY_HF, context.getString(R.string.refractory_hf), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BoldEvaluationItem(context, ConfigurationParams.CALCULATE_HFSS, context.getString(R.string.calculate_hfss), false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.NO_SIGNIFICANT_COMORBIDITIES, context.getString(R.string.no_significant_comorbidities), false, new ArrayList<EvaluationItem>() {
                                    {
                                    }
                                }) {
                                    {
                                        setShouldShowAlert(true);
                                    }
                                });
                                add(new NumericalEvaluationItem(context, ConfigurationParams.VO_MAX_KG, context.getString(R.string.vo_max_kg), context.getString(R.string.value), 6, 40, false, true));
                            }
                        }));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Home Therapeutics", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "Weight Gain", false));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "IV / In Hospital Therapeutics", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "Weight Gain", false));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.CHANGE_IT, "Discharge Therapeutics   ", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "Weight Gain", false));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
            }
        };
    }
}

//
//                add(new BooleanEvaluationItem(context, ConfigurationParams.PREVIOUS_HF_HOSPITALIZATION, context.getString(R.string.previous_hf_hospitalization), false));
//                add(new BooleanEvaluationItem(context, ConfigurationParams.CRT_ICD, "Status post CRT", false));
//
//
//
//                add(new SectionEvaluationItem(context, ConfigurationParams.NYHA_CLASS, "Heart Failure Stage", false, new ArrayList<EvaluationItem>() {{
//
//
//
//                }}, SectionElementState.OPENED) {
//                    {
//                        setHasStateIcon(false);
//                    }
//                });
//                add(new EmptyCellEvaluationItem());
//
//
//
//
//                add(new BooleanEvaluationItem(context, ConfigurationParams.MYOCARDITIS, "Myocarditis", false));
//
//                add(new BooleanEvaluationItem(context, ConfigurationParams.PERIPARTUM_CMP, context.getString(R.string.peripartum_cmp), false));
