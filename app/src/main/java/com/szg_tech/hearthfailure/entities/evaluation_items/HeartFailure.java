package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
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
                add(new SectionEvaluationItem(context, ConfigurationParams.HISTORY, context.getString(R.string.history), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NEW_ON_SET_INITIAL_EVALUATION, "New Onset / Suspected Heart Failure", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_ON_SET_INITIAL_EVALUATION, context.getString(R.string.new_onset_hf_initial_evaluation), false));
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CHRONIC_HF, "Chronic Known Heart Failure", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });

                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_HF, "Chronic known HF", false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.HF_DIAGNOSIS_DURATION_WEEK, context.getString(R.string.duration_week), context.getString(R.string.value), 0, 999, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ONE_OR_MORE_HF_ADMISSION, "One or more HF admissions in 12 months", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TWO_UNSCHEDULED_VISITS, "Two unscheduled ED or clinic visits in 12 months", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_PAIN, context.getString(R.string.chest_pain), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "Weight Gain", false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DYSPNEA_ON_EXERTION, "Dyspnea on exertion", false, new ArrayList<EvaluationItem>() {
                            {

                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CLASS1, "Dyspnea on strenous exertion", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                                }) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CLASS2, "Dyspnea on more than routine activities", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                                }) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CLASS3, "Dyspnea on minimum activities", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                                }) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.CLASS1, "Dyspnea on strenous exertion", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.CLASS2, "Dyspnea on more than routine activities", false));
                                //
                                // add(new BooleanEvaluationItem(context, ConfigurationParams.CLASS3, "Dyspnea on minimum activities", false));

                            }
                        }));


                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_AT_REST, "Dyspnea at rest", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_ICD, "S/P AICD", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_BiV_PPM, "S/P BIVPACER", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_PPM_RV_LEAD_ONLY, "S/P PPM RV LEAD ONLY", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.ETIOLOGY, context.getString(R.string.etiology), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC_DCM_NONISCHEMIC, context.getString(R.string.idiopathic_dcm_nonischemic), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.POST_MI_MORE_45, context.getString(R.string.post_mi_more_45), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ISCHEMIC_POST_MI_LESS_45, context.getString(R.string.ischemic_post_mi_less_45), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CARDIOTOXINS, context.getString(R.string.cardiotoxins), false, new ArrayList<EvaluationItem>() {
                            {

                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.XRT, "Radiation therapy", false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANTERIORCHEST, "Anterior chest", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TUMOR, "Tumor next to heart", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHIELD, "No shielding", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HIGHDOSERT, "High dose XRT > 2Gy/day", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CUMULATIVE, "Cumulative > 30Gy ", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CONCOMITANT, "Concomitant chemo", false));
                                    }
                                }));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ANTRACYCLINES, context.getString(R.string.antracyclines), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TRASTUZUMAB, "AntiHER2/ Trastuzumab", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ALKYLATING, "Alkylating ", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.IMMUNO, "5-FU", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PROTEASE, "Protease inhibitor", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.THYROSINE, "Thyrosine kinase inhibitor", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ATEZO, "PDL/PDL-1", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VEGF, "VEGF inhibitor", false));
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
                        add(new BooleanEvaluationItem(context, ConfigurationParams.MYOCARDITIS, "Myocarditis", false));



                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));



                add(new SectionEvaluationItem(context, ConfigurationParams.CLINICAL_PRESENTATION, context.getString(R.string.clinical_presentation), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 1, 80, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.RASAT, "RA O2 SAT","Value", 50, 100, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.VO2SAT, context.getString(R.string.cv_svo2_sat), context.getString(R.string.value), 30, 100, false, true));

                        add(new BooleanEvaluationItem(context, ConfigurationParams.HJR, context.getString(R.string.hepatojuluar_reflux), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.JUGULAR_VENOUS_DISTENTION, context.getString(R.string.jugular_venous_distention), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EDEMA, context.getString(R.string.edema_ascites), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_SIDED_S3, context.getString(R.string.left_sided_gallop), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_RALES, context.getString(R.string.new_rales), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EDEMA, context.getString(R.string.pulmonary_edema), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CYANOSIS, context.getString(R.string.low_urine_output), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANY_CNS_SYMPTOMS, context.getString(R.string.any_cns_symptoms), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COLD_CLAMMY_EXTERMITIES, context.getString(R.string.cold_clammy_extremities), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CYANOSIS, context.getString(R.string.cyanosis), false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.AHA_STAGE, context.getString(R.string.aha_stage), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AT_HIGH_RISK, context.getString(R.string.at_high_risk), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NO_SIGNS_OF_HF, context.getString(R.string.no_signs_of_hf), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYMPTOMS_OF_HF, context.getString(R.string.symptoms_of_hf), false));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ADVANCED_HF, context.getString(R.string.advanced_hf), false, new ArrayList<EvaluationItem>() {
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
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_1, " NYHA Class 1 ", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_2, " NYHA Class 2", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_3, " NYHA Class 3", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_4, " NYHA Class 4 ", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_1, context.getString(R.string.nyha_ccvs_class_1), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_2, context.getString(R.string.nyha_ccvs_class_2), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_3, context.getString(R.string.nyha_ccvs_class_3), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_4, context.getString(R.string.nyha_ccvs_class_4), false));


                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.HOME_THERAPEUTICS, context.getString(R.string.home_therapeutics), false, new ArrayList<EvaluationItem>() {
                    {

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.B_BLOCKER, context.getString(R.string.b_blocker), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_3125BID, context.getString(R.string.carvedilol_3125bid), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_625BID, context.getString(R.string.carvedilol_625bid), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_125BID, context.getString(R.string.carvedilol_125bid), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CARVEDILOL_25BID, context.getString(R.string.carvedilol_25bid), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_25_QD, context.getString(R.string.metoprololer_25_qd), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_50_QD, context.getString(R.string.metoprololer_50_qd), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_100_QD, context.getString(R.string.metoprololer_100_qd), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_150_QD, context.getString(R.string.metoprololer_150_qd), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.METOPROLOLER_200_QD, context.getString(R.string.metoprololer_200_qd), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BISOPROLOL_25_QD, "Bisoprolol 2.5 qd", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BISOPROLOL_5_QD, "Bisoprolol 5 qd", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BISOPROLOL_10_QD, "Bisoprolol 10 qd", false));
                            }
                        }));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ACEL_ARB, context.getString(R.string.acel_arb), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ENALAPRIL5, context.getString(R.string.enalapril5), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ENALAPRIL10, context.getString(R.string.enalapril10), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.RAMIPRIL5, context.getString(R.string.ramipril5), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.RAMIPRIL25, context.getString(R.string.ramipril25), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LISINOPIRIL5, context.getString(R.string.lisinopiril5), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LISINOPIRIL10, context.getString(R.string.lisinopiril10), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LOSARTAN25, context.getString(R.string.losartan25), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LOSARTAN50, context.getString(R.string.losartan50), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OLMESARTAN10, context.getString(R.string.olmesartan10), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OLMESARTAN20, context.getString(R.string.olmesartan20), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VALSARTAN80, context.getString(R.string.valsartan80), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VALSARTAN160, context.getString(R.string.valsartan160), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SACIBITRIL24, context.getString(R.string.sacibitril24), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SACIBITRIL49, context.getString(R.string.sacibitril49), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SACIBITRIL97, context.getString(R.string.sacibitril97), false));
                            }
                        }));

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

                             add(new BooleanEvaluationItem(context, ConfigurationParams.CURRENT_VKA_THERAPY, "Current VKA therapy", false));
                             add(new BooleanEvaluationItem(context, ConfigurationParams.CCB_OTHER_VASOLIDATORS, "CCB", false));
                             add(new BooleanEvaluationItem(context, ConfigurationParams.VASODILATOR, "Vasodilator", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.ACUTELY_DECOMPENSATED_OR_HOSPITALIZED, context.getString(R.string.acutely_decompensated_hospitalized), false, new ArrayList<EvaluationItem>() {
                    {


                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.DAY1, " In Hospital Day 1  ", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.DAY2, " In Hospital Day2 ", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.DAY4, " Discharge day ", "radio_section", false, false, new ArrayList<EvaluationItem>() {

                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.DAY1, context.getString(R.string.day1), false));
                       //add(new BooleanEvaluationItem(context, ConfigurationParams.DAY2, context.getString(R.string.day2), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.DAY3, context.getString(R.string.day3), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.DAY4, context.getString(R.string.pre_discharge_or_discharge_day), false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));


                add(new SectionEvaluationItem(context, ConfigurationParams.IN_HOSPITAL_THERAPIES, context.getString(R.string.in_hospital_therapies), false, new ArrayList<EvaluationItem>() {
                    {

                        add(new BooleanEvaluationItem(context, ConfigurationParams.DEFIBRILLATION_ACLS, context.getString(R.string.defibrillation_acls), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.URGENT_CV, context.getString(R.string.urgent_cv), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.FOUR_VASOPRESSORS, context.getString(R.string.four_vasopressors), false));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_VASOACTIVE, context.getString(R.string.four_vasoactive), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVVA, context.getString(R.string.Continuous), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOLUS_IVVA, context.getString(R.string.bolus), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TITRATION_IVVA, context.getString(R.string.titration), false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVVA, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.FOUR_NPS, context.getString(R.string.four_nps), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.FOUR_NTG, context.getString(R.string.four_ntg), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.FOUR_MILRINONE, context.getString(R.string.four_milrinone), false));
                            }
                        }));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_ANTIARRYTHMIC, context.getString(R.string.four_antiarrythmic), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVAA, context.getString(R.string.Continuous), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOLUS_IVAA, context.getString(R.string.bolus), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TITRATION_IVAA, context.getString(R.string.titration), false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVAA, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TRANSITION_TO_PO_ANTIARRYTHMIC, context.getString(R.string.transition_to_po_antiarrythmic), false));
                            }
                        }));


                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_ANTIHYPERTENSIVE, context.getString(R.string.four_antihypertensive), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVHT, context.getString(R.string.Continuous), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOLUS_IVHT, context.getString(R.string.bolus), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TITRATION_IVHT, context.getString(R.string.titration), false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVHT, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                            }
                        }));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_DIURETIC, context.getString(R.string.four_diuretic), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVDI, context.getString(R.string.Continuous), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMITTENT, context.getString(R.string.intermittent), false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVDI, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.MECHANICAL_VENTIALLATION_OR_NIPPV, context.getString(R.string.mechanical_ventiallation_or_nippv), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.RESPIRATORY_INTERVENTIONS_Q_HR, context.getString(R.string.respiratory_interventions_q_hr), context.getString(R.string.value), 1, 6, false, true));
                            }
                        }));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.O2_SUPPLEMENT, context.getString(R.string.o2_supplement), context.getString(R.string.value), 23, 100, false, true));

                        add(new BooleanEvaluationItem(context, ConfigurationParams.ULTRAFILTRATION, context.getString(R.string.ultrafiltration), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.IABP, context.getString(R.string.iabp), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TEMPORARY_PM, context.getString(R.string.temporary_pm), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ON_MAX_TOLERATED_B_BLOCKER, context.getString(R.string.on_max_tolerated_b_blocker), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ON_MAX_TOLERATED_ACE_IARB, context.getString(R.string.on_max_tolerated_acei_arb), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_INOTROPE_DEPENDENCE, context.getString(R.string.chronic_inotrope_dependence), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMITTENT_INOTROPE_DEPENDENCE, context.getString(R.string.intermittent_inotrope_dependence), false));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.DISCHARGE_THERAPEUTICS, context.getString(R.string.discharge_therapeutics), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.DCDIURETIC, "Discharge daily diuretic dose, furosemide equivalent", "Value", 10, 240, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PRE6MWT, "Predischarge 6MW distance", "Value",10, 800, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PREBNP, "Predischarge BNP pg/ml", "Value", 10, 80000, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.VO2, "VO2 max.kg","Value", 1, 30, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARA, "B blocker intolerance", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COM, "Non cardiac co-morbidities", false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
            }
        };
    }
}