package com.szg_tech.hearthfailure.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.hearthfailure.BuildConfig;
import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TextEvaluationItem;

import java.util.ArrayList;

public class About extends SectionEvaluationItem {
    public About(Context context) {
        super(context, ConfigurationParams.ABOUT, null, false);
        name = context.getString(R.string.about);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(context, ConfigurationParams.PRIVACY_POLICY, context.getString(R.string.privacy_policy), false, new ArrayList<EvaluationItem>() {
                    {

                    }
                }, SectionElementState.OPENED) {
                    {
                        setHasStateIcon(false);
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(context, ConfigurationParams.TERMS_OF_USE, context.getString(R.string.terms_of_use), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new TextEvaluationItem(context, ConfigurationParams.TERMS_OF_USE_TEXT, context.getString(R.string.terms_of_use_text), false));
                    }
                }, SectionElementState.OPENED) {
                    {
                        setHasStateIcon(false);
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(context, ConfigurationParams.HELP_SUPPORT, context.getString(R.string.help_support), false, new ArrayList<EvaluationItem>() {
                    {

                    }
                }, SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                        setHasStateIcon(false);
                    }
                });
                add(new BoldEvaluationItem(context, ConfigurationParams.DEVELOPMENT, context.getString(R.string.development), false));
                add(new StringEvaluationItem(context, ConfigurationParams.LOGIC, context.getString(R.string.logic), null, false, null) {
                    {
                        setText(context.getString(R.string.logic_dev_name));
                        setEditable(false);
                    }
                });
                add(new StringEvaluationItem(context, ConfigurationParams.ENGINEERING, context.getString(R.string.engineering), null, false, null) {
                    {
                        setText(context.getString(R.string.engineering_dev_name));
                        setEditable(false);
                    }
                });
                add(new StringEvaluationItem(context, ConfigurationParams.DESIGN, context.getString(R.string.design), null, false, null) {
                    {
                        setText(context.getString(R.string.designer_name));
                        setEditable(false);
                    }
                });
                add(new BoldEvaluationItem(context, ConfigurationParams.VERSION_CAPS, context.getString(R.string.version_caps), false));
                add(new TextEvaluationItem(context, ConfigurationParams.VERSION, String.format(context.getString(R.string.version), BuildConfig.VERSION_NAME), false));
            }
        };
    }
}
