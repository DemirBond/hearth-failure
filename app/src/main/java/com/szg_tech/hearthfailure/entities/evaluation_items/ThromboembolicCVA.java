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

public class ThromboembolicCVA extends SectionEvaluationItem {

    public ThromboembolicCVA(Context context) {
        super(context, ConfigurationParams.THROMBOEMBOLIC_PREVENTION_VKA_THERAPY, null, false);
        this.evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.thromboembolic_prevention_vka_therapy);
        sectionElementState = SectionElementState.OPENED;
    }
    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {

                //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PATIENT_BLEED_RISK, "Patient related bleeding risk", false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ACTIVE_GASTRODUODENAL_ULCER, context.getString(R.string.active_gastroduodenal_ulcer), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.BLEED_IN_3_MO_BEFORE_ADMISSION, context.getString(R.string.bleed_in_3_mo_before_admission), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PLATELET_COUNT_LESS_50, context.getString(R.string.platelet_count_less_50), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ICU_OR_CCU_ADMISSION, context.getString(R.string.icu_or_ccu_admission), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.CENTRAL_VENOUS_CATHETER, context.getString(R.string.central_venous_catheter), false));

                    }
                //}));
                //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PROCEDURAL_BLEED_RISK, "Procedur related bleeding risk", false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PRIOR_BLEED_DURING_BRIDGING_SIMILAR, context.getString(R.string.prior_bleed_during_bridging_similar), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.PRIOR_ASA_USE, context.getString(R.string.prior_asa_use), false));
                       //add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_NOT_CLINICALLY_IMPORTANT_LOW, context.getString(R.string.risk_not_clinically_important_low), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_UNCERTAIN, context.getString(R.string.risk_uncertain), false));
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.RISK_INTERMEDIATE_HIGH, context.getString(R.string.risk_intermediate_high), false));
                    }
                //}));
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
        };
    }
}
