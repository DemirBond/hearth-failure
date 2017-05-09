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

class CurrentCVProfile extends SectionEvaluationItem {
    CurrentCVProfile(Context context) {
        super(context, ConfigurationParams.CURRENT_PAST_CV_PROFILE, null, false);
        name = context.getString(R.string.cv_profile);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(context, ConfigurationParams.CORONARY_HEART_DISEASE, context.getString(R.string.coronary_heart_disease), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ACUTE_CORONARY_SYNDROME, context.getString(R.string.acute_coronary_syndrome), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_2_ANGINA_24HR, context.getString(R.string.more_2_angina_24hr), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ANGINA_MORE_20MIN, context.getString(R.string.angina_more_20min), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ASA_ACS, context.getString(R.string.asa_use_in_past_1_week), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.POSITIVE_TROP_I_OR_T, context.getString(R.string.positive_trop_i_or_t), false));
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
                        add(new BooleanEvaluationItem(context, ConfigurationParams.RCA, context.getString(R.string.rca), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LCX, context.getString(R.string.lcx), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ICD_10, context.getString(R.string.icd_10), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_TOTAL_OCCLUSION, context.getString(R.string.chronic_total_occlusion), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CORONARY_ANEURYSM, context.getString(R.string.coronary_aneurysm), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CORONARY_DISSECTION, context.getString(R.string.coronary_dissection), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CALCIFIED_CORONARY_LESION, context.getString(R.string.calcified_coronary_lesion), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LIPID_RICH_PLAQUE, context.getString(R.string.lipid_rich_plaque), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DOCUMENTED_VASOSPASM, context.getString(R.string.documented_vasospasm), false));
                            }
                        }));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.VESSEL_MORE_50, context.getString(R.string.vessel_more_50), context.getString(R.string.value), 1, 3, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF_CHD, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.HEART_FAILURE, context.getString(R.string.heart_failure), false, new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(context, ConfigurationParams.HF_DIAGNOSIS_DURATION_WEEK, "Duration / week", context.getString(R.string.value), 0, 999, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PREVIOUS_HF_HOSPITALIZATION, context.getString(R.string.previous_hf_hospitalization), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_ICD, "Status post AICD", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CRT_ICD, "Status post CRT", false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));




                        add(new SectionEvaluationItem(context, ConfigurationParams.NYHA_CLASS, "Heart Failure Stage", false, new ArrayList<EvaluationItem>() {{

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

                        }}, SectionElementState.OPENED) {
                            {
                                setHasStateIcon(false);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC_DCM_NONISCHEMIC, context.getString(R.string.idiopathic_dcm_nonischemic), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.POST_MI_MORE_45, context.getString(R.string.post_mi_more_45), false, new ArrayList<EvaluationItem>() {
                            {
                                new BooleanEvaluationItem(context, ConfigurationParams.LV_ANEURYSM, context.getString(R.string.lv_aneurysm), false);
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ISCHEMIC_POST_MI_LESS_45, context.getString(R.string.ischemic_post_mi_less_45), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARDIOTOXINS, context.getString(R.string.cardiotoxins), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILIAL_CMP, context.getString(R.string.familial_cmp), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.MYOCARDITIS,"Myocarditis", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.RV_DYSPLASIA, context.getString(R.string.rv_dysplasia), false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.HOCM, context.getString(R.string.hocm), false, new ArrayList<EvaluationItem>() {
                                {
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.LVH_MORE_30, context.getString(R.string.lvh_more_30), false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_BP_RESPONSE_TO_EXERCISE, context.getString(R.string.abnormal_bp_response_to_exercise), false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.HISTORY_OF_SUDDEN_DEATH, context.getString(R.string.history_of_sudden_death), false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.REST_DYNAMIC_PEAK, context.getString(R.string.rest_dynamic_peak), false));
                                }
                            }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PERIPARTUM_CMP, context.getString(R.string.peripartum_cmp), false));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.ATRIAL_FIBRILATION, context.getString(R.string.atrial_fibrilation), false, new ArrayList<EvaluationItem>() {
                    {

                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_AF, context.getString(R.string.chronic_af), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PERSISTENT_AF, context.getString(R.string.persistent_af), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAROXYMAL_AF, context.getString(R.string.paroxymal_af), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_SUCCESSFUL_ABLATION, context.getString(R.string.s_p_successful_ablation), false));
                        add(new BoldEvaluationItem(context, ConfigurationParams.PLEASE_SELECT_ONE, context.getString(R.string.please_select_one), false));
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.RHYTM_CONTROL, context.getString(R.string.rhytm_control), "radio_section", false, false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CURRENT_ANIARRYTHMIC_THERAPY, context.getString(R.string.current_aniarrythmic_therapy), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PROPOFONONE_FLECANIDE, context.getString(R.string.propofonone_flecanide), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SOTALOL_AMIODARONE_MULTAQ_DOFETILIDE, context.getString(R.string.sotalol_amiodarone_multaq_dofetilide), false));
                                    }
                                }));

                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.VENTRICULAR_RATE_CONTROL, context.getString(R.string.ventricular_rate_control), "radio_section", false, false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.HEART_RATE_WITH_ACTIVITY, context.getString(R.string.heart_rate_with_activity), context.getString(R.string.value), 40, 300, false, true));
                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYMPTOMATIC, context.getString(R.string.symptomatic), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ACUTELY, context.getString(R.string.acutely), false));
                            }
                        }));


                        add(new NumericalEvaluationItem(context, ConfigurationParams.DURATION_DAYS, context.getString(R.string.duration_days), context.getString(R.string.value), 0, 999, false, true));

                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PREVIOUS_TIA_CVA, context.getString(R.string.previous_tia_cva), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.LAST_THROMBOEMBOLIC_EVENT_MONTHS_AGO, context.getString(R.string.last_thromboembolic_event_months_ago), context.getString(R.string.value), 0, 600, false, true));
                            }
                        }));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.THROMBOEMBOLIC_VKA, context.getString(R.string.thromboembolic_vka), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(context, ConfigurationParams.THROMBOEMBOLIC_PREVENTION_VKA_THERAPY, "Thromboembolism / VKA ", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.INR, context.getString(R.string.inr), context.getString(R.string.value), 0.5, 100, false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PATIENT_BLEED_RISK, "Patient related bleeding risk", false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ACTIVE_GASTRODUODENAL_ULCER, context.getString(R.string.active_gastroduodenal_ulcer), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BLEED_IN_3_MO_BEFORE_ADMISSION, context.getString(R.string.bleed_in_3_mo_before_admission), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PLATELET_COUNT_LESS_50, context.getString(R.string.platelet_count_less_50), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ICU_OR_CCU_ADMISSION, context.getString(R.string.icu_or_ccu_admission), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CENTRAL_VENOUS_CATHETER, context.getString(R.string.central_venous_catheter), false));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PROCEDURAL_BLEED_RISK, "Procedur related bleeding risk", false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRIOR_BLEED_DURING_BRIDGING_SIMILAR, context.getString(R.string.prior_bleed_during_bridging_similar), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRIOR_ASA_USE, context.getString(R.string.prior_asa_use), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_NOT_CLINICALLY_IMPORTANT_LOW, context.getString(R.string.risk_not_clinically_important_low), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_UNCERTAIN, context.getString(R.string.risk_uncertain), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_INTERMEDIATE_HIGH, context.getString(R.string.risk_intermediate_high), false));
                                    }
                                }));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DEEP_VENOUS_THROMBOSIS, context.getString(R.string.deep_venous_thrombosis), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EMBOLISM, context.getString(R.string.pulmonary_embolism), false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DVY_PE_DIAGNOSIS_PREVENTION, "DVT diagnosis, prevention", false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.MAJOR_SURGERY_TRAUMA, context.getString(R.string.major_surgery_trauma), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.MAJOR_GYN_UROLOGY, context.getString(R.string.major_gyn_urology), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TKR, context.getString(R.string.tkr), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.THR, context.getString(R.string.thr), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HIP_FRACTURE, context.getString(R.string.hip_fracture), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPINE_SURGERY, context.getString(R.string.spine_surgery), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPINAL_CORD_INJURY, context.getString(R.string.spinal_cord_injury), false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.MEDICAL_ILLNESS, context.getString(R.string.medical_illness), false, new ArrayList<EvaluationItem>() {
                                            {


                                                add(new BooleanEvaluationItem(context, ConfigurationParams.PAINFUL_DEEP_VENOUS_PALPATION_AND_EDEMA, context.getString(R.string.painful_deep_venous_palpation_and_edema), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ACTIVE_CANCER, context.getString(R.string.active_cancer), false));

                                                add(new BooleanEvaluationItem(context, ConfigurationParams.RESPIRATORY_FAILURE, context.getString(R.string.respiratory_failure), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ALREADY_KNOWN_THROMBOPHILIC_CONDITION, context.getString(R.string.already_known_thrombophilic_condition), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.RECENT_TRAUMA_SURGERY, context.getString(R.string.recent_trauma_surgery), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.REDUCED_MOBILITY, context.getString(R.string.reduced_mobility), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ONGOING_HORMONAL_TREATMENT, context.getString(R.string.ongoing_hormonal_treatment), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ACUTE_INFECTION_RHEUMATOLOGIC_DISORDER, "Active infection, rheumatologic disorder", false));
                                            }
                                        }));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ACUTE_CVA, context.getString(R.string.acute_cva), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.NIHSS, context.getString(R.string.nihss), context.getString(R.string.value), 0, 42, false, true));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNILATERAL_WEAKNESS, context.getString(R.string.unilateral_weakness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPEECH_DISTURBANCE, context.getString(R.string.speech_disturbance), false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.DURATION_OF_SYMPTOMS, context.getString(R.string.duration_of_symptoms), context.getString(R.string.value), 0, 24, false, true));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRE_HOSPITAL_CARE, context.getString(R.string.pre_hospital_care), false));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.VALVULAR_HEART_DISEASE_THROMBOEMBOLIC, "Valvular heart disease ", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MECHANICAL_CAGEBALL, context.getString(R.string.mechanical_cageball), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MECHANICAL_DISK_BILEAFLET_MITRAL, context.getString(R.string.mechanical_disk_bileaflet_mitral), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MECHANICAL_DISK_BILEAFLET_AORTIC, context.getString(R.string.mechanical_disk_bileaflet_aortic), false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.RHEUMATIC_MITRAL_VALVE_DISEASE, context.getString(R.string.rheumatic_mitral_valve_disease), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LA_THROMBUS, context.getString(R.string.la_thrombus), false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LA_DIAMETER, context.getString(R.string.la_diameter), context.getString(R.string.value), 2, 7, false, true));
                                    }
                                }));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BIOPROSTHETIC_VALVE, context.getString(R.string.bioprosthetic_valve), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SYSTEMIC_EMBOLISM, context.getString(R.string.systemic_embolism), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.INFECTIVE_ENDROCARDITIS, context.getString(R.string.infective_endrocarditis), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_SIDED_PV_THROMBOSIS, context.getString(R.string.left_sided_pv_thrombosis), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.RIGHT_SIDED_PV_THROMBOSIS, context.getString(R.string.right_sided_pv_thrombosis), false));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.CARDIAC_SOURCE_OF_EMBOLISM, context.getString(R.string.cardiac_source_of_embolism), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NON_ACUTE_ARTERIAL_ISCHEMIC_STROKE, context.getString(R.string.non_acute_arterial_ischemic_stroke), false) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(context, ConfigurationParams.AORTIC_ARCH_ATHEROSCLEROSIS, context.getString(R.string.aortic_arch_atherosclerosis), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LV_THROMBUS, context.getString(R.string.lv_thrombus), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PFO, context.getString(R.string.pfo), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MVP, context.getString(R.string.mvp), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MITRAL_ANNULAR_VALCIFICATION, context.getString(R.string.mitral_annular_valcification), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CALCIFIC_AORTIC_VALVE_DISEASE, context.getString(R.string.calcific_aortic_valve_disease), false));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.MISCELLANEOUS, context.getString(R.string.miscellaneous), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HIT, context.getString(R.string.hit), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CEREBRAL_VENOUS_THROMBOSIS, context.getString(R.string.cerebral_venous_thrombosis), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HYPERCOAGULABLE_STATE, context.getString(R.string.hypercoagulable_state), false));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.VENTRICULAR_TACHYARRTHYMIAS, context.getString(R.string.ventricular_tachyarrthymias), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NSVT, context.getString(R.string.nsvt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.MONOMORPHIC_VT, context.getString(R.string.monomorphic_vt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.REPETITIVE_MONOMORPHIC_VT, context.getString(R.string.repetitive_monomorphic_vt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.POLYMORPHIC_VT, context.getString(R.string.polymorphic_vt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TORSADES, context.getString(R.string.torsades), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.INCESSANT_VT, context.getString(R.string.incessant_vt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC_VT, context.getString(R.string.idiopathic_vt), false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(context, ConfigurationParams.BRADYARRTHYMIA_SYNCOPE, context.getString(R.string.bradyarrthymia_syncope), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYMPTOMATIC_SINUS_NODE_DYSFUNCTION, context.getString(R.string.symptomatic_sinus_node_dysfunction), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HIGH_GRADE_AV_NODE_DISEASE, context.getString(R.string.high_grade_av_node_disease), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ISOLATED_NEUROCARDIOGENIC_UNEXPLAINED_SYNCOPE, context.getString(R.string.isolated_neurocardiogenic_unexplained_syncope), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CAROTID_SINUS_HYPERSENSITIVITY, context.getString(R.string.carotid_sinus_hypersensitivity), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.POTS, context.getString(R.string.pots), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AUTONOMIC_FAILURE_SYNDROME, context.getString(R.string.autonomic_failure_syndrome), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HISTORY_OF_CARDIAC_ARREST, context.getString(R.string.history_of_cardiac_arrest), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.BRUGADA_SYNDROME, context.getString(R.string.brugada_syndrome), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LONG_QT, context.getString(R.string.long_qt), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SARCOIDOSIS_GIANT_CELL_CHAGAS, context.getString(R.string.sarcoidosis_giant_cell_chagas), false));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
//                add(new SectionEvaluationItem(context, ConfigurationParams.ATHEROSCLEROTIC_VASCULAR_DISEASE, context.getString(R.string.atherosclerotic_vascular_disease), false, new ArrayList<EvaluationItem>() {
//TODO fill section
//                }, SectionElementState.OPENED) {
//                    {
//                        setBottomButtonReferenceSkipped(true);
//                    }
//                });
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.VALVULAR_HEART_DISEASE, context.getString(R.string.valvular_heart_disease), false, new ArrayList<EvaluationItem>(){}) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(context, ConfigurationParams.PULMONARY_HYPERTENSION, context.getString(R.string.pulmonary_hypertension), false, new ArrayList<EvaluationItem>() {
                    {
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(context, ConfigurationParams.VASCULAR_DISEASES, context.getString(R.string.vascular_diseases), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(context, ConfigurationParams.SYMPTOMATIC_CAROTID_DISEASE, context.getString(R.string.symptomatic_carotid_disease), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NONCARDIOEMBOLIC_VCA_TIA, "Noncardioembolic CVA associated with Carotid Plaque", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NONCARDIOEMBOLIC_TIA, "Noncardioembolic TIA associated with Carotid Plaque", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_50_CAROTID_STENOSIS, context.getString(R.string.more_50_carotid_stenosis), false));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.PERIPHERIC_VASCULAR_DISEASE, context.getString(R.string.peripheric_vascular_disease), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABI_LESS_09, context.getString(R.string.abi_less_09), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CLAUDICATION, context.getString(R.string.claudication), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CRITICAL_LIMB_ISCHEMIA, context.getString(R.string.critical_limb_ischemia), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ENDOVASCULAR_REVASCULARIZATION, context.getString(R.string.endovascular_revascularization), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PERIPHERAL_ARTERY_BYPASS_GRAFT, context.getString(R.string.peripheral_artery_bypass_graft), false));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.ABDOMINAL_AORTIC_ANEURYSM, "Aortic Aneurysm", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.AA_DIAMETER_MORE_5, context.getString(R.string.aa_diameter_more_5), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.THORACIC, "Thoracic Aortic Aneurysm ", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.THORACIC_ABDOMINAL, "Thoracoabdominal Aortic Aneurysm", false));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
            }
        };
    }
}
