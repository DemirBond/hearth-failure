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

class InHospitalTherapies extends SectionEvaluationItem {
    InHospitalTherapies(Context context) {
        super(context, ConfigurationParams.IN_HOSPITAL_THERAPIES, null, false);
        name = context.getString(R.string.in_hospital_therapies);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
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
        };
    }
}
