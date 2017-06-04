package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class Diagnostics extends SectionEvaluationItem {
    Diagnostics(Context context) {
        super(context, ConfigurationParams.DIAGNOSTICS, null, false);
        name = context.getString(R.string.diagnostics);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.EKG, context.getString(R.string.ekg), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NSR, "Normal sinus rhtym", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SVT, "Supraventricular tachycardia", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ATRIAL_FIBRILATION, context.getString(R.string.atrial_fibrilation), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ATRIAL_FLUTTER, context.getString(R.string.atrial_flutter), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TYPICAL_AF, context.getString(R.string.typical_af), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ATYPICAL_AF, context.getString(R.string.atypical_af), false));
                            }
                        }));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PR_DURATION, context.getString(R.string.pr_duration), context.getString(R.string.value), 100, 400, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.QRS_DURATION, "QRS duration", "Value", 100, 500, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.QTC_DURATION, "QTC duration", "Value", 100, 1000, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NONSPECIFIC_ST_ABNORMALITY, "Nonspesific ST abnormality", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ST_DEVIATION_MORE_05_MM, context.getString(R.string.st_deviation_more_05_mm), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.T_WAVE_INVERSION_MORE_1MM, context.getString(R.string.t_wave_inversion_more_1mm), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LVH, "LVH", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LOW_VOLTAGE_QRS, context.getString(R.string.low_voltage_qrs), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_Q_WAVES, context.getString(R.string.abnormal_q_waves), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LBBB, "LBBB", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BIFASCICULAR, context.getString(R.string.bifascicular), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.LAHB, context.getString(R.string.lahb), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.LPHB, context.getString(R.string.lphb), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WPW, "WPW", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.VPACE, "Ventricular pacing", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RBBB, "RBBB", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.INTRAVENTICULAR_BLOCK, "IVCD", false));

                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ATRIAL_PREMATURE_DEPOLARIZATION, context.getString(R.string.atrial_premature_depolarization), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.JUNCTIONAL_PREMATURE_DEPOLARIZATION, context.getString(R.string.junctional_premature_depolarization), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.FREQUENT_VENTRICULAR_PACING_OR_ECTOPY, "Frequent ventricular ectopy", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.INFREQUENT_VENTRICULAR_PACING_OR_ECTOPY, "Infrequent ventricular ectopy", false));



                        //add(new BooleanEvaluationItem(context, ConfigurationParams.FIRST_DEGREE_AV_BLOCK, context.getString(R.string.first_degree_av_block), false));
                        //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SECOND_DEGREE_AV_BLOCK, context.getString(R.string.second_degree_av_block), false, new ArrayList<EvaluationItem>() {
                            {
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.TYPE_1, context.getString(R.string.type_1), false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.TYPE_2, context.getString(R.string.type_2), false));
                            }
                        //}));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.THIRD_DEGREE_AV_BLOCK, context.getString(R.string.third_degree_av_block), false));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.STRESS_TESTING, context.getString(R.string.stress_testing), false, new ArrayList<EvaluationItem>() {
                    {
                        //TODO duke treadmill fix - count automatically after clarification
                        add(new NumericalEvaluationItem(context, ConfigurationParams.DUKE_TREADMILL_SCORE, "DTS "," Value" ,-25, 25, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.SERUM_STRESS_SUMMED_SCORE, "SSS", " Value", 0, 99, false, true));


                        add(new NumericalEvaluationItem(context, ConfigurationParams.STRESS_DIFFERENCE_SCORE, "SDS", context.getString(R.string.value), 0, 99, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.ISCHEMIC_MYOCARDIUM_ON_MPS, "% Ischemic myocardium", context.getString(R.string.value), 0, 100, false, true));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.TID_OR_SIGNIFICANT_STRESS_INDUCED_LV_DISFUNCTION, "TID or stress induced LV dysfunction", false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.EX_TIME_MIN, context.getString(R.string.ex_time_min), context.getString(R.string.value), 1, 21, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.MAX_ST_MM, context.getString(R.string.max_st_mm), context.getString(R.string.value), 0, 8, false, true));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ANGINA_INDEX, context.getString(R.string.angina_index), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NO_ANGINA_DURING_EXERCISE, context.getString(R.string.no_angina_during_exercise), ConfigurationParams.ANGINA_INDEX, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NON_LIMITING_ANGINA, context.getString(R.string.non_limiting_angina), ConfigurationParams.ANGINA_INDEX, false, false));
                                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.EXERCISE_LIMITING_ANGINA, context.getString(R.string.exercise_limiting_angina), ConfigurationParams.ANGINA_INDEX, false, false));
                            }
                        }));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ST_ELEVATION, context.getString(R.string.st_elevation), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_BP_RESPONSE, context.getString(R.string.abnormal_bp_response), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.VENTRICULAR_TACHYCARDIA, context.getString(R.string.ventricular_tachycardia), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PROLONG_ST_DEPRESSION, context.getString(R.string.prolong_st_depression), false));

                        //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FIXED_PERFUSION_DEFECTS_OR_AKINETIC_DYSKINETIC, context.getString(R.string.fixed_perfusion_defects_or_akinetic_dyskinetic), false, new ArrayList<EvaluationItem>() {
                            //{
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VIABILITY_PRESENT, context.getString(R.string.viability_present), false));
                            //}
                        //}));
                        //add(new NumericalEvaluationItem(context, ConfigurationParams.DSE_ISCHEMIC_THRESHOLD, "DSE,ischemic threshold", "Value", 0, 200, false, true));
                        //add(new NumericalEvaluationItem(context, ConfigurationParams.DSE_OR_STRESS_MRI, "DSE or stress MRI, # of RWMA segments", "Value", 0, 24, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNABLE_TO_EXERCISE, "Unable to exercise", false));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ECHOCARDIOGRAPHY, context.getString(R.string.echocardiography), false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PERICARDIAL_EFFUSION, context.getString(R.string.pericardial_effusion), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RWMA, context.getString(R.string.rwma), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ENLARGED_LA_OR_LVH, "Enlarged LA", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LVHE, "LVH", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.E_A_LESS_05_AND_DT_MORE_280MS, context.getString(R.string.e_a_less_05_and_dt_more_280ms), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.GRADE_MORE_2_DIASTOLIC_DYSFUNCTION, "E/A > 1.5", false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RESPIRATORY_IVS_SHIFT, context.getString(R.string.respiratory_ivs_shift), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.MITRAL_E_VARIATION, context.getString(R.string.mitral_e_variation), false));

                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ENLARGED_RA, context.getString(R.string.enlarged_ra), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ESMALLER8, "E/E'<=10", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.E8TO16, "E/E'>10 ", false));
                        //add(new NumericalEvaluationItem(context, ConfigurationParams.LV_LATEREAL_ANNULUS_E_E, context.getString(R.string.lv_latereal_annulus_e_e), context.getString(R.string.value), 1, 30, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVED_ECHO, "LVED mm", context.getString(R.string.value), 10, 80, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.TRJ_VELOCITY, context.getString(R.string.trj_velocity), context.getString(R.string.value), 1, 6, false));
                    }
                }));
                //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CHEST_X_RAY, context.getString(R.string.chest_x_ray), false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RIGHT_PLEURAL_EFFUSION, context.getString(R.string.right_pleural_effusion), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_PLEURAL_EFFUSION, context.getString(R.string.left_pleural_effusion), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EDEMA_CHEST, context.getString(R.string.pulmonary_edema), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ENLARGED_CARDIAC_SOLHOUETTE, context.getString(R.string.enlarged_cardiac_solhouette), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.WIDENED_MEDIASTENEUM, context.getString(R.string.widened_mediasteneum), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PNEUMOTHORAX, context.getString(R.string.pneumothorax), false));
                    }
                //}));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.RHC, context.getString(R.string.rhc), false, new ArrayList<EvaluationItem>() {
                    {
                    }
                }) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                //add(new NumericalEvaluationItem(context, ConfigurationParams.CORONARY_CALCIUM_SCORE, context.getString(R.string.coronary_calcium_score), context.getString(R.string.value), 0, 100, false, true));
                //add(new NumericalEvaluationItem(context, ConfigurationParams.TOTAL_CCS, context.getString(R.string.total), context.getString(R.string.value), 0, 10000, false, true));
            }
        };
    }
}
