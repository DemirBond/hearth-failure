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
 * Created by ahmetkucuk on 5/20/17.
 */

public class AtrialFibrillation extends SectionEvaluationItem {

    public AtrialFibrillation(Context context) {
        super(context, ConfigurationParams.ATRIAL_FIBRILATION, null, false);
        this.evaluationItemList = createEvaluationItemElementsList();
        name = context.getString(R.string.atrial_fibrilation);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                //add(new BooleanEvaluationItem(context, ConfigurationParams.CHRONIC_AF, context.getString(R.string.chronic_af), false));
                //add(new BooleanEvaluationItem(context, ConfigurationParams.PERSISTENT_AF, context.getString(R.string.persistent_af), false));
                //add(new BooleanEvaluationItem(context, ConfigurationParams.PAROXYMAL_AF, context.getString(R.string.paroxymal_af), false));
                //add(new BooleanEvaluationItem(context, ConfigurationParams.S_P_SUCCESSFUL_ABLATION, context.getString(R.string.s_p_successful_ablation), false));
                add(new BoldEvaluationItem(context, ConfigurationParams.PLEASE_SELECT_ONE, context.getString(R.string.please_select_one), false));
                add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.RHYTM_CONTROL, context.getString(R.string.rhytm_control), "radio_section", false, false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CURRENT_ANIARRYTHMIC_THERAPY, context.getString(R.string.current_aniarrythmic_therapy), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PROPOFONONE_FLECANIDE, context.getString(R.string.propofonone_flecanide), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SOTALOL_AMIODARONE_MULTAQ_DOFETILIDE, context.getString(R.string.sotalol_amiodarone_multaq_dofetilide), false));
                            }
                        //}));

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
                add(new BooleanEvaluationItem(context, ConfigurationParams.THYROTOXICOSIS, "Thyrotoxicosis", false));
            }
        };
    }
}
