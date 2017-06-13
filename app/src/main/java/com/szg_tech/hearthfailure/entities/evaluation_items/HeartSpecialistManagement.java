package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TabEvaluationItem;

import java.util.ArrayList;

public class HeartSpecialistManagement extends SectionEvaluationItem {
    public HeartSpecialistManagement(Context context) {
        super(context, ConfigurationParams.HEART_SPECIALIST_MANAGEMENT, null, false);
        name = context.getString(R.string.heart_specialist_management);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(context, ConfigurationParams.BIO_PAH_MAIN, " 6MWT, CPET ", false, new ArrayList<EvaluationItem>() {
                    {
                        //TODO make expanding control
                        add(new StringEvaluationItem(context, ConfigurationParams.NAME, context.getString(R.string.name), context.getString(R.string.name_hint), true, null));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.AGE, context.getString(R.string.age), context.getString(R.string.age_hint), 20, 100, true, true));
                        add(new SectionPlaceholderEvaluationItem(context, ConfigurationParams.GENDER, context.getString(R.string.gender), context.getString(R.string.male), false,
                                new ArrayList<EvaluationItem>() {
                                    {
                                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.MALE, context.getString(R.string.male), ConfigurationParams.GENDER, false, true));
                                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.FEMALE, context.getString(R.string.female), ConfigurationParams.GENDER, false, false));
                                    }
                                }));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.BMI, "BMI", "Enter BMI", 100, 220, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.WEIGHT, context.getString(R.string.weight), context.getString(R.string.weight_hint), 40, 400, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.HEART_RATE, context.getString(R.string.heart_rate), context.getString(R.string.heart_rate_hint), 30, 300, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.SBP, context.getString(R.string.sbp), context.getString(R.string.sbp_hint), 60, 300, true, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.DBP, context.getString(R.string.dbp), context.getString(R.string.dbp_hint), 30, 160, true, true));

                        add(new BooleanEvaluationItem(context, ConfigurationParams.ORTHOSTATIC_SYMPTOMPS, context.getString(R.string.orthostatic_symptomps), false));

                        add(new NumericalEvaluationItem(context, ConfigurationParams.SIX_MW_DISTANCE, context.getString(R.string.six_mw_distance), context.getString(R.string.value), 50, 600, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.MAX_VO_MG_KG_MIN, context.getString(R.string.max_vo_mg_kg_min), context.getString(R.string.value), 6, 40, false, true));

                    }
                }, SectionElementState.OPENED));
                add(new SectionEvaluationItem(context, ConfigurationParams.PAH, "PAH clinics", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new TabEvaluationItem(context, "heart_rate_tab", "tab", new ArrayList<SectionEvaluationItem>() {
                            {
                                add(new SectionEvaluationItem(context, "tab_pg1", context.getString(R.string.pah), false, new ArrayList<EvaluationItem>() {
                                    {

                                        add(new BooleanEvaluationItem(context, ConfigurationParams.IDIOPATHIC, context.getString(R.string.idiopathic), false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CONGENITAL, context.getString(R.string.congenital), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ASD_LESS_2CM, context.getString(R.string.asd_less_2cm), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.VSD_LESS_1CM, context.getString(R.string.vsd_less_1cm), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.POST_CORRECTIVE_SURGERY, context.getString(R.string.post_corrective_surgery), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.EISENMENGER, context.getString(R.string.eisenmenger), false));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SCLERODERMA, context.getString(R.string.scleroderma), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SLE, context.getString(R.string.sle), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HIV, context.getString(R.string.hiv), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PORTAL_HYPERTENSION, context.getString(R.string.portal_hypertension), false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.RESPIRATORY_DISEASE_HYPOXIA, context.getString(R.string.respiratory_disease_hypoxia), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new NumericalEvaluationItem(context, ConfigurationParams.AHI, context.getString(R.string.ahi), context.getString(R.string.value), 0, 100, false, true));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.OSA, context.getString(R.string.osa), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.IPF_ILD, context.getString(R.string.ipf_ild), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.COPD, context.getString(R.string.copd), false));
                                            }
                                        }));

                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PVOD_PCH, context.getString(R.string.pvod_pch), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPLENECTOMY_SC, context.getString(R.string.splenectomy_sc), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILIAL, context.getString(R.string.familial), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CTEP, context.getString(R.string.ctep), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DRUGS_TOXINS, context.getString(R.string.drugs_toxins), false));
                                    }
                                }));
                                add(new SectionEvaluationItem(context, "tab_pg2", context.getString(R.string.pah), false, new ArrayList<EvaluationItem>() {
                                    {
                                        {
                                            add(new NumericalEvaluationItem(context, ConfigurationParams.DLCO, "DLCO,%", "Value",1, 6, false));
                                            add(new NumericalEvaluationItem(context, ConfigurationParams.FEV1_LT, "FEV1,lt","Value", 16, 144, false, true));
                                            add(new NumericalEvaluationItem(context, ConfigurationParams.FEV1_PERCENT, "FEV1,%","Value", 1, 6, false));
                                            add(new NumericalEvaluationItem(context, ConfigurationParams.IC_TLC, "IC/TLC","Value", 1, 6, false));
                                        }
                                    }
                                }));

                                add(new SectionEvaluationItem(context, "tab_pg3", context.getString(R.string.pah), false, new ArrayList<EvaluationItem>() {
                                    {
                                        {
                                    add(new NumericalEvaluationItem(context, ConfigurationParams.TR_JET_VELOCITY, "TRJ m/s","Value", 1, 6, false));
                                    add(new NumericalEvaluationItem(context, ConfigurationParams.EXERCISE_RSVP, "Exercise RVSPmmHg","Value", 16, 144, false, true));

                                    add(new BooleanEvaluationItem(context, ConfigurationParams.CHECK_IF_LV_TD_DONE, "Check if LV TD done", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.CHECK_IF_RVOT_PW_DONE, "Check if RVOT flow interrogated", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.CHECK_IF_TAPSE_DONE, "Check if TAPSE done", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.E_E_LESS_8, "E/E <8 ", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.SHORT_PAAT, "Short PAAT", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.TAPSE_LESS_2, "TAPSE < 2 ", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.E_E_8_16, "E/E' 8 to 16", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.MIDSYS_NOTCH, "Midsystolic notch", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.ENLARGED_RA, "Enlarged RA", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.E_E_MORE_16, "E/E' > 16", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.ENLARGED_RV, "Enlarged RV", false));
                                    add(new BooleanEvaluationItem(context, ConfigurationParams.PERICARDIAL_EFFUSION, "Pericardial effusion", false));
                                        }
                                    }

                                }));
                            }
                        }));
                    }

                }, SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.VALVULAR, context.getString(R.string.valvular), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(context, ConfigurationParams.VALVULAR, context.getString(R.string.valvular), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF_PAH, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_ONSET_ATRIAL_FIBRILATION, context.getString(R.string.new_onset_atrial_fibrilation), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PREGNANCY, context.getString(R.string.pregnancy), false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.AORTIC_STENOSIS, context.getString(R.string.aortic_stenosis), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING, "Calcified AV", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CONGENITALLY_STENOTIC_AORTIC_VALVE, context.getString(R.string.congenitally_stenotic_aortic_valve), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RHEUMATIC_AV, context.getString(R.string.rheumatic_av), false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.CALCULATED_AORTIC_VALVE_AREA, context.getString(R.string.calculated_aortic_valve_area), context.getString(R.string.value), 0.1, 4, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.AORTIC_MEAN_PRESSURE_GRADIENT, context.getString(R.string.aortic_mean_pressure_gradient), context.getString(R.string.value), 4, 60, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.AORTIC_VALVE_VALOCITY, context.getString(R.string.aortic_valve_valocity), context.getString(R.string.value), 1, 6, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.STROKE_VOLUME_INDEX_SV_SBA, context.getString(R.string.stroke_volume_index_sv_sba), context.getString(R.string.value), 1, 9, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.INDEXED_VALVE_AREA_AVA_BSA, context.getString(R.string.indexed_valve_area_ava_bsa), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.BISCUSPID_AORTIC_ROOT_DIAMETER, context.getString(R.string.biscuspid_aortic_root_diameter), context.getString(R.string.value), 0.1, 7, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.MITRAL_STENOSIS, context.getString(R.string.mitral_stenosis), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.MVA_CM_2, context.getString(R.string.mva_cm_2), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.PHT_MSEC, context.getString(R.string.pht_msec), context.getString(R.string.value), 50, 400, false, true));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RHEUMATIC_MV_TV, context.getString(R.string.rheumatic_mv_tv), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAVORABLE_VALVE_MORPHOLOGY, context.getString(R.string.favorable_valve_morphology), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LA_CLOT, context.getString(R.string.la_clot), false));
                                    }
                                }));

                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PULMONIC_STENOSIS, context.getString(R.string.pulmonic_stenosis), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.PULMONIC_VALVE_VELOCITY, context.getString(R.string.pulmonic_valve_velocity), context.getString(R.string.value), 0.5, 5, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.AORTIC_REGURGITATION, context.getString(R.string.aortic_regurgitation), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HOLODIASTOLIC_FLOW_REVERSAL, context.getString(R.string.holodiastolic_flow_reversal), false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.VENA_CONTRACTA_WIDTH, context.getString(R.string.vena_contracta_width), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.REGURGITANT_VOLUME_ML_BEAT, context.getString(R.string.regurgitant_volume_ml_beat), context.getString(R.string.value), 0, 99, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.REGURGITANT_FRACTION, context.getString(R.string.regurgitant_fraction), context.getString(R.string.value), 0, 61, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.ERO, context.getString(R.string.ero), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEDD_MM, context.getString(R.string.lvedd_mm), context.getString(R.string.value), 10, 90, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVESD_MM, context.getString(R.string.lvesd_mm), context.getString(R.string.value), 10, 60, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.AORTIC_ROOT_DIAMETER, context.getString(R.string.aortic_root_diameter), context.getString(R.string.value), 2, 9, false, true));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PRIMARY_MITRAL_REGURGITATION, context.getString(R.string.primary_mitral_regurgitation), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HOLODIASTOLIC_FLOW_REVERSAL, context.getString(R.string.holodiastolic_flow_reversal), false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.VENA_CONTRACTA_WIDTH, context.getString(R.string.vena_contracta_width), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.REGURGITANT_VOLUME_ML_BEAT, context.getString(R.string.regurgitant_volume_ml_beat), context.getString(R.string.value), 0, 99, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.REGURGITANT_FRACTION, context.getString(R.string.regurgitant_fraction), context.getString(R.string.value), 0, 61, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.ERO, context.getString(R.string.ero), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEDD_MM, context.getString(R.string.lvedd_mm), context.getString(R.string.value), 10, 90, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVESD_MM, context.getString(R.string.lvesd_mm), context.getString(R.string.value), 10, 60, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.AORTIC_ROOT_DIAMETER, context.getString(R.string.aortic_root_diameter), context.getString(R.string.value), 2, 9, false, true));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.TRICUSPID_REGURGITATION, context.getString(R.string.tricuspid_regurgitation), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.ANNULAR_DIAMETER, context.getString(R.string.annular_diameter), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.CENTRAL_JET_AREA_CM_2, context.getString(R.string.central_jet_area_cm_2), context.getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.VENA_CONTRACTA_WIDTH_TRI, context.getString(R.string.vena_contracta_width), context.getString(R.string.value), 0.1, 9, false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEPATIC_VEIN_FLOW_REVERSAL, context.getString(R.string.hepatic_vein_flow_reversal), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_TV_LEAFLETS, context.getString(R.string.abnormal_tv_leaflets), false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PULMONIC_REGURGITATION, context.getString(R.string.pulmonic_regurgitation), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.WIDE_REGURFITANT_JET, context.getString(R.string.wide_regurfitant_jet), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_PULMONIC_VALVE_LEAFLETS, context.getString(R.string.abnormal_pulmonic_valve_leaflets), false));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));

                        add(new SectionEvaluationItem(context, ConfigurationParams.VALVULAR_SURGERY_RISK, context.getString(R.string.valvular_surgery_risk), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LOW, context.getString(R.string.low), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMEDIATE, context.getString(R.string.intermediate), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HIGH, context.getString(R.string.high), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PROHIBITIVE, context.getString(R.string.prohibitive), false));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(context, ConfigurationParams.OTHER_SURGICAL_RISK, context.getString(R.string.other_surgical_risk), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY, context.getString(R.string.high_risk_supra_inguinal_vascular_surgery), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LOW_RISK_CATARACT_PLASTIC, context.getString(R.string.low_risk_cataract_plastic), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMEDIATE_RISK, context.getString(R.string.intermediate_risk), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OTHER_CARDIAC, context.getString(R.string.other_cardiac), false));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionElementState.OPENED));

                add(new SectionEvaluationItem(context, ConfigurationParams.ADVANCED_LHF, context.getString(R.string.advanced_lhf), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ADVANCED_HEART_FAILURE, context.getString(R.string.heart_failure), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionEvaluationItem(context, ConfigurationParams.HEART_FAILURE_DURATION, context.getString(R.string.heart_failure_duration), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.HEART_FAILURE_DURATION_WEEK, context.getString(R.string.heart_failure_duration_week), context.getString(R.string.value), 0, 100, false));

                                        //TODO make control
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY1, context.getString(R.string.day1), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY2, context.getString(R.string.day2), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY3, context.getString(R.string.day3), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY4, context.getString(R.string.day4), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY5, context.getString(R.string.day5), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DAY6, context.getString(R.string.day6), false));

                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HFPLVF, context.getString(R.string.hfplvf), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAILED_OUTPUT_RX, context.getString(R.string.failed_output_rx), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CRT_ICD, context.getString(R.string.crt_icd), false));
                                    }
                                }, SectionElementState.OPENED));
                                add(new SectionEvaluationItem(context, ConfigurationParams.CLINICS, context.getString(R.string.clinics), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.RASAT, "RA O2 sat","", 50, 100, false, true));
                                        add(new NumericalEvaluationItem(context, ConfigurationParams.NT_PROBNP_PG_ML, context.getString(R.string.nt_probnp_pg_ml), context.getString(R.string.value), 50, 100000, false, true));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PULMONARY_EDEMA, context.getString(R.string.pulmonary_edema), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LEFT_SIDED_S3, "Left sided S3", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARDIO_SHOCK, context.getString(R.string.cardio_shock), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_ON_EXERTION, context.getString(R.string.dyspnea_on_exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_AT_REST_MORE_2_HRS_AFTER_RX, context.getString(R.string.dyspnea_at_rest_more_2_hrs_after_rx), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NEW_RALES, context.getString(R.string.new_rales), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HJR, context.getString(R.string.hepatojuluar_reflux), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JUGULAR_VENOUS_DISTENTION, context.getString(R.string.jugular_venous_distention), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, context.getString(R.string.weight_gain), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANY_CNS_SYMPTOMS, context.getString(R.string.any_cns_symptoms), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.WORSENING_RENAL_FX, context.getString(R.string.worsening_renal_fx), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EDEMA, context.getString(R.string.edema), false));
                                    }
                                }, SectionElementState.OPENED));
                                add(new SectionEvaluationItem(context, ConfigurationParams.ETIOLOGY, context.getString(R.string.Etiology), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DCM, "Nonischemic CMP", false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.HOCM, context.getString(R.string.hocm), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.LVH_MORE_30, context.getString(R.string.lvh_more_30), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABNORMAL_BP_RESPONSE_TO_EXERCISE, context.getString(R.string.abnormal_bp_response_to_exercise), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILY_HISTORY_OF_SUDDEN_DEATH, context.getString(R.string.family_history_of_sudden_death), false));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ISCHEMIC, context.getString(R.string.ischemic), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CARDIOTOXINS, context.getString(R.string.cardiotoxins), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILIAL_CMP_ASSOCIATED_SUDDEN_DEATH, context.getString(R.string.familial_cmp_associated_sudden_death), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.VALVULAR_HEART_DISEASE_SEC, context.getString(R.string.valvular_heart_disease), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.RV_DYSPLASIA, context.getString(R.string.rv_dysplasia), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.MI_MORE_45_DAYS, context.getString(R.string.mi_more_45_days), false));
                                    }
                                }, SectionElementState.OPENED));
                                add(new SectionEvaluationItem(context, ConfigurationParams.STAGE_CLASS, context.getString(R.string.stage_class), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.AT_HIGH_RISK, context.getString(R.string.at_high_risk), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NO_SIGNS_OF_HF, context.getString(R.string.no_signs_of_hf), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYMPTOMS_OF_HF, context.getString(R.string.symptoms_of_hf), false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.REFRACTORY_HF, context.getString(R.string.refractory_hf), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BoldEvaluationItem(context, ConfigurationParams.CALCULATE_HFSS, context.getString(R.string.calculate_hfss), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.NO_SIGNIFICANT_COMORBIDITIES, context.getString(R.string.no_significant_comorbidities), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.FREQUENT_HOSPITAL_ADMISSIONS, context.getString(R.string.frequent_hospital_admissions), false));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_1, "NYHA/CCVS Class 1", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_2, context.getString(R.string.nyha_ccvs_class_2), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_3, context.getString(R.string.nyha_ccvs_class_3), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_4, context.getString(R.string.nyha_ccvs_class_4), false));
                                    }
                                }, SectionElementState.OPENED));

                                add(new SectionEvaluationItem(context, ConfigurationParams.ARRTHYMIAS, context.getString(R.string.arrthymias), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.AV_NODE_DISEASE, context.getString(R.string.av_node_disease), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SINUS_NODE_DYSFUNCTION, context.getString(R.string.sinus_node_dysfunction), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.VENTRICULAR_TACHYCARDIA_PAH, context.getString(R.string.ventricular_tachycardia), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NSVT, context.getString(R.string.nsvt), false));
                                    }
                                }, SectionElementState.OPENED));

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
                                    }
                                }, SectionElementState.OPENED));

                                add(new SectionEvaluationItem(context, ConfigurationParams.THERAPEUTICS, context.getString(R.string.therapeutics), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_ANTIARRYTHMIC, context.getString(R.string.four_antiarrythmic), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVAA, context.getString(R.string.Continuous), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOLUS_IVAA, context.getString(R.string.bolus), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.TITRATION_IVAA, context.getString(R.string.titration), false));
                                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVAA, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.TRANSITION_TO_PO_ANTIARRYTHMIC, context.getString(R.string.transition_to_po_antiarrythmic), false));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.URGENT_CV, context.getString(R.string.urgent_cv), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DEFIBRILLATION_ACLS, context.getString(R.string.defibrillation_acls), false));
                                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.FOUR_ANTIHYPERTENSIVE, context.getString(R.string.four_antihypertensive), false, new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.CONTINOUS_IVHT, context.getString(R.string.Continuous), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOLUS_IVHT, context.getString(R.string.bolus), false));
                                                add(new BooleanEvaluationItem(context, ConfigurationParams.TITRATION_IVHT, context.getString(R.string.titration), false));
                                                add(new NumericalEvaluationItem(context, ConfigurationParams.MONITORING_FREQUENCY_Q_HR_IVHT, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, false, true));
                                            }
                                        }));
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
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FOUR_VASOPRESSORS, context.getString(R.string.four_vasopressors), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ULTRAFILTRATION, context.getString(R.string.ultrafiltration), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.IABP, context.getString(R.string.iabp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TEMPORARY_PM, context.getString(R.string.temporary_pm), false));

                                    }
                                }, SectionElementState.OPENED));
                            }


                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ECHOCARDIOGRAPHY, "Echocardiography", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.E_A_LESS_05_AND_DT_MORE_280MS, "Grade 1 DD", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.GRADE_MORE_2_DIASTOLIC_DYSFUNCTION, "Grade 2 DD", false));

                                add(new NumericalEvaluationItem(context, ConfigurationParams.LV_LATEREAL_ANNULUS_E_E, "Lateral annulus E/E'","Value", 1, 30, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.LVEF, "LVEF"," Value", 10, 80, false, true));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.EKG, "EKG", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.QRS_DURATION, "QRS duration","Value", 10, 300, false, true));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.LBBB, "LBBB", false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.LABORATORIES, "Laboratories", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(context, ConfigurationParams.GFR_ML_MIN, "GFR","Value", 0, 120, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.CREATININE_MG_DL, "Creatinine","Value", 0.4, 20, false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.NA, "Na meq.l","Value", 99, 170, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.K_MEQ_L, "K meq.l","Value", 2, 9, false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.PLATELETS_K_ML, "Platelet K","Value", 1000, 1000000, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.ALBUMIN_G_DL, "Albumin gm.dl","Value", 0.9, 5, false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.INR_PAH, "INR","Value", 0.8, 100, false));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.AST_U_ML, "AST U.ml","Value", 10, 100000, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.BUN_U_DL, "BUN","Value", 6, 200, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.HEMATOCRIT, "Hematocrit","Value", 9, 75, false, true));
                                add(new NumericalEvaluationItem(context, ConfigurationParams.BNP_PG_ML, "BNP","Value", 10, 100000, false, true));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ON_MAX_TOLERATED_B_BLOCKER, "Maximum tolerated b blocker", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ON_MAX_TOLERATED_ACE_IARB, "Maximum tolerated ACE I/ ARB", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_INOTROPE_DEPENDENCE, "Chronic inotrope dependence", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMITTENT_INOTROPE_DEPENDENCE, "Intermittent inotrope dependence", false));
                    }
                }, SectionElementState.OPENED));





                add(new SectionEvaluationItem(context, ConfigurationParams.RHC, context.getString(R.string.rhc), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(context, ConfigurationParams.MEAN_PAP_MMHG, context.getString(R.string.mean_pap_mmhg), context.getString(R.string.value), 10, 70, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PVR_WU, context.getString(R.string.pvr_wu), context.getString(R.string.value), 1, 20, false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.LVEDP_MMHG, context.getString(R.string.lvedp_mmhg), context.getString(R.string.value), 8, 50, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PCWP_MMGH, context.getString(R.string.pcwp_mmgh), context.getString(R.string.value), 3, 40, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.CL_LT_MIN_SQ, context.getString(R.string.cl_lt_min_sq), context.getString(R.string.value), 0.9, 5, false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.RA_PRESSURE_MMHG, context.getString(R.string.ra_pressure_mmhg), context.getString(R.string.value), 0, 40, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.V_WAVE_AMPLITUDE, context.getString(R.string.v_wave_amplitude), context.getString(R.string.value), 0, 40, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NO_V_WAVE, context.getString(R.string.no_v_wave), false));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.PADP_MMHG, context.getString(R.string.padp_mmhg), context.getString(R.string.value), 5, 40, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.RVEDP_MMGH, context.getString(R.string.rvedp_mmgh), context.getString(R.string.value), 3, 20, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.SVR_WU, context.getString(R.string.svr_wu), "SVR, WU", 1, 19, false));
                        //TODO add image view
                    }
                }, SectionElementState.OPENED));
            }
        };
    }
}
