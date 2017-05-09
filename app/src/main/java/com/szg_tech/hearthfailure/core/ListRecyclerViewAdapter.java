package com.szg_tech.hearthfailure.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomEditText;
import com.szg_tech.hearthfailure.core.views.cell.BoldTextCell;
import com.szg_tech.hearthfailure.core.views.cell.CellItem;
import com.szg_tech.hearthfailure.core.views.cell.CheckBoxCell;
import com.szg_tech.hearthfailure.core.views.cell.DatePickerCell;
import com.szg_tech.hearthfailure.core.views.cell.EmptyCell;
import com.szg_tech.hearthfailure.core.views.cell.MinutesSecondsCell;
import com.szg_tech.hearthfailure.core.views.cell.RadioButtonCell;
import com.szg_tech.hearthfailure.core.views.cell.RadioViewManager;
import com.szg_tech.hearthfailure.core.views.cell.SectionCell;
import com.szg_tech.hearthfailure.core.views.cell.SectionCheckboxCell;
import com.szg_tech.hearthfailure.core.views.cell.SectionDependsOnManager;
import com.szg_tech.hearthfailure.core.views.cell.SectionPlaceholderCell;
import com.szg_tech.hearthfailure.core.views.cell.StringEditTextCell;
import com.szg_tech.hearthfailure.core.views.cell.TextCell;
import com.szg_tech.hearthfailure.core.views.modal.AlertModalManager;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.DatePickerEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.MinutesSecondsEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalDependantEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TabEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TextEvaluationItem;
import com.szg_tech.hearthfailure.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.hearthfailure.fragments.tab_fragment.TabFragment;
import com.szg_tech.hearthfailure.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {
    private Activity activity;
    private List<EvaluationItem> evaluationItemsList;
    private HashMap<String, RadioViewManager> radioViewManagerHashMap = new HashMap<>();
    private ArrayList<SectionEvaluationItem> nextSectionEvaluationItems;
    private SectionDependsOnManager sectionDependsOnManager = new SectionDependsOnManager();
    private String parentTitle;
    private ArrayList<Object> oldValues = new ArrayList<>();

    public ListRecyclerViewAdapter(Activity activity, List<EvaluationItem> evaluationItemsList, ArrayList<Object> oldValues) {
        this.activity = activity;
        this.evaluationItemsList = evaluationItemsList;
        this.oldValues = oldValues;
    }

    @Override
    public int getItemViewType(int position) {
        EvaluationItem evaluationItem = evaluationItemsList.get(position);
        if (evaluationItem instanceof BooleanEvaluationItem) {
            return 0;
        } else if (evaluationItem instanceof StringEvaluationItem) {
            return 1;
        } else if (evaluationItem instanceof NumericalEvaluationItem) {
            return 2;
        } else if (evaluationItem instanceof SectionEvaluationItem) {
            return 3;
        } else if (evaluationItem instanceof RadioButtonGroupEvaluationItem) {
            return 4;
        } else if (evaluationItem instanceof SectionPlaceholderEvaluationItem) {
            return 5;
        } else if (evaluationItem instanceof BoldEvaluationItem) {
            return 6;
        } else if (evaluationItem instanceof MinutesSecondsEvaluationItem) {
            return 7;
        } else if (evaluationItem instanceof SectionCheckboxEvaluationItem) {
            return 8;
        } else if (evaluationItem instanceof NumericalDependantEvaluationItem) {
            return 9;
        } else if (evaluationItem instanceof EmptyCellEvaluationItem) {
            return 10;
        } else if (evaluationItem instanceof DatePickerEvaluationItem) {
            return 11;
        } else if (evaluationItem instanceof TextEvaluationItem) {
            return 12;
        }
        return -1;
    }

    public void addNextSectionEvaluationItems(ArrayList<SectionEvaluationItem> nextSectionEvaluationItems) {
        this.nextSectionEvaluationItems = nextSectionEvaluationItems;
    }

    @Override
    public ListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switch (viewType) {
            case 0:
                CheckBoxCell checkBoxCell = new CheckBoxCell(activity);
                checkBoxCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(checkBoxCell);
            case 1:
            case 2:
            case 9:
                StringEditTextCell stringEditTextCell = new StringEditTextCell(activity);
                stringEditTextCell.setLayoutParams(layoutParams);
                if (viewType == 2 || viewType == 9) {
                    stringEditTextCell.setNumeric();
                }
                return new ListRecyclerViewAdapter.ViewHolder(stringEditTextCell);
            case 3:
                SectionCell sectionCell = new SectionCell(activity);
                sectionCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionCell);
            case 4:
                RadioButtonCell radioButtonCell = new RadioButtonCell(activity);
                radioButtonCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(radioButtonCell);
            case 5:
                SectionPlaceholderCell sectionPlaceholderCell = new SectionPlaceholderCell(activity);
                sectionPlaceholderCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionPlaceholderCell);
            case 6:
                BoldTextCell boldTextCell = new BoldTextCell(activity);
                boldTextCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(boldTextCell);
            case 7:
                MinutesSecondsCell minutesSecondsCell = new MinutesSecondsCell(activity);
                minutesSecondsCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(minutesSecondsCell);
            case 8:
                SectionCheckboxCell sectionCheckboxCell = new SectionCheckboxCell(activity);
                sectionCheckboxCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionCheckboxCell);
            case 10:
                EmptyCell emptyCell = new EmptyCell(activity);
                return new ListRecyclerViewAdapter.ViewHolder(emptyCell);
            case 11:
                DatePickerCell datePickerCell = new DatePickerCell(activity);
                datePickerCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(datePickerCell);
            case 12:
                TextCell textCell = new TextCell(activity);
                textCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(textCell);
        }
        StringEditTextCell stringEditTextCell = new StringEditTextCell(activity);
        return new ListRecyclerViewAdapter.ViewHolder(stringEditTextCell);
    }

    @Override
    public void onBindViewHolder(ListRecyclerViewAdapter.ViewHolder holder, int position) {
        if (holder != null) {
            EvaluationItem evaluationItem = evaluationItemsList.get(position);
            String name = evaluationItem.getName();
            if (evaluationItem.isMandatory()) {
                name += "*";
            }
            holder.view.setLabelText(name);
            holder.view.setHintText(evaluationItem.getHint());
            if (evaluationItem instanceof SectionEvaluationItem) {
                if (!((SectionEvaluationItem) evaluationItem).isHasStateIcon()) {
                    ((SectionCell) holder.view).setStateIconLayoutVisibility(false);
                }
                SectionEvaluationItem.SectionElementState state = ((SectionEvaluationItem) evaluationItemsList.get(position)).getSectionElementState();
                switch (state) {
                    case LOCKED:
                        ((SectionCell) holder.view).setLocked();
                        break;
                    case OPENED:
                        ((SectionCell) holder.view).setOpened();
                        break;
                    case VIEWED:
                        ((SectionCell) holder.view).setViewed();
                        break;
                    case FILLED:
                        ((SectionCell) holder.view).setFilled();
                        break;
                }

                String dependsOn = ((SectionEvaluationItem) evaluationItem).getDependsOn();
                SectionEvaluationItem mainEvaluationItem = null;
                if (dependsOn != null) {
                    for (EvaluationItem tempEvaluationItem : evaluationItemsList) {
                        if (tempEvaluationItem instanceof SectionEvaluationItem && tempEvaluationItem.getId().equals(dependsOn)) {
                            mainEvaluationItem = (SectionEvaluationItem) tempEvaluationItem;
                            sectionDependsOnManager.addToMap(mainEvaluationItem, (SectionEvaluationItem) evaluationItem);
                        }
                    }
//                    if (mainEvaluationItem != null && mainEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.FILLED) {
                    if (mainEvaluationItem != null && mainEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED
                            && ((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                        ((SectionEvaluationItem) evaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                        ((SectionCell) holder.view).setOpened();
                    }
                }
                if (evaluationItem.getId().equals(ConfigurationParams.LABORATORIES) && ((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                    for (int i = 0; i < evaluationItemsList.size(); i++) {
                        EvaluationItem item = evaluationItemsList.get(i);
                        if ((item.getId().equals(ConfigurationParams.CURRENT_PAST_CV_PROFILE) &&
                                ((SectionEvaluationItem) item).getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED)
                                || (item.getId().equals(ConfigurationParams.MAJOR_CV_RISK) &&
                                ((SectionEvaluationItem) item).getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED)) {
                            ((SectionEvaluationItem) evaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                            ((SectionCell) holder.view).setOpened();
                        }
                    }
                }

                SectionEvaluationItem finalMainEvaluationItem = mainEvaluationItem;
                ((SectionCell) holder.view).setOnClickListener(v -> {
                    if (((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                        if (evaluationItem.getId().equals(ConfigurationParams.LABORATORIES)
                                || evaluationItem.getId().equals(ConfigurationParams.DIAGNOSTICS)) {
                            SectionEvaluationItem bioEvaluationItem = null;
                            int bioPosition = 0;
                            SectionEvaluationItem currentCVEvaluationItem = null;
                            int currentCVPosition = 0;
                            SectionEvaluationItem majorCVRiskEvaluationItem = null;
                            int majorCVRiskPosition = 0;

                            SectionEvaluationItem laboratoriesEvaluationItem = null;
                            SectionEvaluationItem diagnosticEvaluationItem = null;

                            for (int i = 0; i < evaluationItemsList.size(); i++) {
                                EvaluationItem item = evaluationItemsList.get(i);
                                switch (item.getId()) {
                                    case ConfigurationParams.BIO:
                                        bioEvaluationItem = (SectionEvaluationItem) item;
                                        bioPosition = i;
                                        break;
                                    case ConfigurationParams.CURRENT_PAST_CV_PROFILE:
                                        currentCVEvaluationItem = (SectionEvaluationItem) item;
                                        currentCVPosition = i;
                                        break;
                                    case ConfigurationParams.MAJOR_CV_RISK:
                                        majorCVRiskEvaluationItem = (SectionEvaluationItem) item;
                                        majorCVRiskPosition = i;
                                        break;
                                    case ConfigurationParams.LABORATORIES:
                                        laboratoriesEvaluationItem = (SectionEvaluationItem) item;
                                        break;
                                    case ConfigurationParams.DIAGNOSTICS:
                                        diagnosticEvaluationItem = (SectionEvaluationItem) item;
                                        break;
                                }
                            }
                            if (bioEvaluationItem != null && bioEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                                int finalBioPosition = bioPosition;
                                SectionEvaluationItem finalBioEvaluationItem = bioEvaluationItem;
                                AlertModalManager.createAndShowDependsOnSectionAlertDialog(activity, bioEvaluationItem.getName(), v1 -> goToNextScreen(finalBioPosition, finalBioEvaluationItem));
                            } else if ((currentCVEvaluationItem != null
                                    && currentCVEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED)
                                    && (majorCVRiskEvaluationItem != null
                                    && majorCVRiskEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED)) {
                                SectionEvaluationItem finalCurrentCVEvaluationItem = currentCVEvaluationItem;
                                SectionEvaluationItem finalMajorCVRiskEvaluationItem = majorCVRiskEvaluationItem;
                                int finalCurrentCVPosition = currentCVPosition;
                                int finalMajorCVRiskPosition = majorCVRiskPosition;
                                SectionEvaluationItem finalLaboratoriesEvaluationItem = laboratoriesEvaluationItem;
                                SectionEvaluationItem finalDiagnosticEvaluationItem = diagnosticEvaluationItem;
                                AlertModalManager.createAndShowThreeButtonDependsOnDialog(activity, v1 -> {
                                    if (finalLaboratoriesEvaluationItem != null) {
                                        finalLaboratoriesEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                    }
                                    if(finalDiagnosticEvaluationItem != null) {
                                        finalDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                    }
                                    goToNextScreen(finalCurrentCVPosition, finalCurrentCVEvaluationItem);
                                }, v2 -> {
                                    if (finalLaboratoriesEvaluationItem != null) {
                                        finalLaboratoriesEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                    }
                                    if(finalDiagnosticEvaluationItem != null) {
                                        finalDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                    }
                                    goToNextScreen(finalMajorCVRiskPosition, finalMajorCVRiskEvaluationItem);
                                });
                            }
                        } else if (finalMainEvaluationItem != null) {
                            goToMandatorySection(activity, finalMainEvaluationItem);
                        }
                    } else if (activity instanceof AppCompatActivity) {
                        if (isScreenValid()) {
                            goToNextScreen(position, (SectionEvaluationItem) evaluationItem);
                            if (evaluationItem.getId().equals(ConfigurationParams.CURRENT_PAST_CV_PROFILE) ||
                                    evaluationItem.getId().equals(ConfigurationParams.MAJOR_CV_RISK)) {

                                for (EvaluationItem tempEvaluationItem : evaluationItemsList) {
                                    if (tempEvaluationItem.getId().equals(ConfigurationParams.LABORATORIES) || tempEvaluationItem.getId().equals(ConfigurationParams.DIAGNOSTICS)) {
                                        SectionEvaluationItem tempLabOrDiagnosticEvaluationItem = (SectionEvaluationItem) tempEvaluationItem;
                                        if (tempLabOrDiagnosticEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                                            tempLabOrDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                        }
                                    }
                                }
                            }
                        } else {
                            showSnackbarBottomButtonError(((SectionCell) holder.view).getTextView());
                        }
                    }
                });
            } else if (evaluationItem instanceof SectionPlaceholderEvaluationItem) {
                ArrayList<EvaluationItem> evaluationItems = evaluationItem.getEvaluationItemList();
                if (evaluationItems.get(0) instanceof RadioButtonGroupEvaluationItem) {
                    for (EvaluationItem item : evaluationItems) {
                        if (((RadioButtonGroupEvaluationItem) item).isChecked()) {
                            evaluationItem.setHint(item.getName());
                            holder.view.setHintText(item.getName());
                            break;
                        }
                    }
                }
                ((SectionPlaceholderCell) holder.view).setOnClickListener(v -> {
                    if (activity instanceof AppCompatActivity) {
                        saveAllValues();
                        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                        if (fragmentManager != null) {
                            EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(ConfigurationParams.NEXT_SECTION, evaluationItem);
                            bundle.putString(ConfigurationParams.SUBTITLE, parentTitle);
                            evaluationListFragment.setArguments(bundle);
                            fragmentManager.beginTransaction()
                                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                    .replace(R.id.container, evaluationListFragment)
                                    .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                                    .commit();
                        }
                    }
                });
            } else if (evaluationItem instanceof RadioButtonGroupEvaluationItem) {
                RadioViewManager radioViewManager = radioViewManagerHashMap.get(((RadioButtonGroupEvaluationItem) evaluationItem).getGroupName());
                if (radioViewManager == null) {
                    radioViewManager = new RadioViewManager();
                    radioViewManagerHashMap.put(((RadioButtonGroupEvaluationItem) evaluationItem).getGroupName(), radioViewManager);
                }
                ((RadioButtonCell) holder.view).setBackgroundHighlighted(((RadioButtonGroupEvaluationItem) evaluationItem).isBackgroundHighlighted());
                ((RadioButtonCell) holder.view).setChecked(((RadioButtonGroupEvaluationItem) evaluationItem).isChecked());
                radioViewManager.addToMap((RadioButtonCell) holder.view, (RadioButtonGroupEvaluationItem) evaluationItem);
                if (evaluationItem.getEvaluationItemList() != null) {
                    ((RadioButtonCell) holder.view).showNextArrow();
                    ((RadioButtonCell) holder.view).setOnClickListener(v -> {
                        if (((RadioButtonGroupEvaluationItem) evaluationItem).isChecked()) {
                            saveAllValues();
                            FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                            if (fragmentManager != null) {
                                EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(ConfigurationParams.NEXT_SECTION, evaluationItem);
                                bundle.putString(ConfigurationParams.SUBTITLE, parentTitle);
                                evaluationListFragment.setArguments(bundle);
                                fragmentManager.beginTransaction()
                                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                        .replace(R.id.container, evaluationListFragment)
                                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                                        .commit();
                            }
                        }
                    });
                }
            } else if (evaluationItem instanceof BooleanEvaluationItem) {
                ((CheckBoxCell) holder.view).setBackgroundHighlighted(((BooleanEvaluationItem) evaluationItem).isBackgroundHighlighted());
                ((CheckBoxCell) holder.view).getCheckBox().setOnCheckedChangeListener((buttonView, isChecked) -> ((BooleanEvaluationItem) evaluationItem).setChecked(isChecked));
                ((CheckBoxCell) holder.view).setChecked(((BooleanEvaluationItem) evaluationItem).isChecked());
            } else if (evaluationItem instanceof NumericalEvaluationItem) {
                StringEditTextCell stringEditTextCell = (StringEditTextCell) holder.view;
                setImeOptionsForLastEditText(stringEditTextCell, position);
                CustomEditText editText = stringEditTextCell.getEditText();
                editText.clearTextWatchers();
                if (evaluationItem.getValue() != null) {
                    stringEditTextCell.setCorrect(evaluationItem.isValid());
                }
                if (((NumericalEvaluationItem) evaluationItem).isWhole()) {
                    stringEditTextCell.setNumeric(true);
                }
                Double number = ((NumericalEvaluationItem) evaluationItem).getNumber();
                if (number != null) {
                    editText.setText(((NumericalEvaluationItem) evaluationItem).isWhole() ? String.valueOf(number.intValue()) : String.valueOf(number));
                } else {
                    editText.getText().clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String text = s.toString();
                        if (!text.isEmpty()) {
                            Double value = Double.parseDouble(text);
                            if (value >= ((NumericalEvaluationItem) evaluationItem).getFrom()
                                    && value <= ((NumericalEvaluationItem) evaluationItem).getTo()) {
                                ((NumericalEvaluationItem) evaluationItem).setNumber(Double.parseDouble(s.toString()));
                                stringEditTextCell.setCorrect(true);
                                return;
                            }
                        } else if (!evaluationItem.isMandatory() && text.isEmpty()) {
                            ((NumericalEvaluationItem) evaluationItem).setNumber(null);
                            stringEditTextCell.setCorrect(true);
                            return;
                        }
                        ((NumericalEvaluationItem) evaluationItem).setNumber(null);
                        stringEditTextCell.setCorrect(false);
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!hasFocus) {
                        if (!stringEditTextCell.isCorrect()) {
                            String snackbarText = null;
                            if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                            } else if (!editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_range_message), evaluationItem.getName(),
                                        String.valueOf(((NumericalEvaluationItem) evaluationItem).getFrom()), String.valueOf(((NumericalEvaluationItem) evaluationItem).getTo()));
                            }
                            if (snackbarText != null) {
                                Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                        Snackbar.LENGTH_SHORT);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                snackbar.show();
                            }
                        }
                    } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                        stringEditTextCell.setCorrect(false);
                    }
                });
            } else if (evaluationItem instanceof NumericalDependantEvaluationItem) {
                StringEditTextCell stringEditTextCell = (StringEditTextCell) holder.view;
                setImeOptionsForLastEditText(stringEditTextCell, position);
                if (evaluationItem.getValue() != null) {
                    stringEditTextCell.setCorrect(evaluationItem.isValid());
                }
                CustomEditText editText = stringEditTextCell.getEditText();
                editText.clearTextWatchers();
                if (((NumericalDependantEvaluationItem) evaluationItem).isWhole()) {
                    stringEditTextCell.setNumeric(true);
                }
                Double number = ((NumericalDependantEvaluationItem) evaluationItem).getNumber();
                if (number != null) {
                    editText.setText(((NumericalDependantEvaluationItem) evaluationItem).isWhole() ? String.valueOf(number.intValue()) : String.valueOf(number));
                } else {
                    editText.getText().clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String text = s.toString();
                        if (!text.isEmpty()) {
                            Double value = Double.parseDouble(text);
                            if (value >= ((NumericalDependantEvaluationItem) evaluationItem).getFrom()
                                    && value <= ((NumericalDependantEvaluationItem) evaluationItem).getTo()) {
                                ((NumericalDependantEvaluationItem) evaluationItem).setNumber(Double.parseDouble(s.toString()));
                                stringEditTextCell.setCorrect(true);
                                return;
                            }
                        } else if (!evaluationItem.isMandatory() && text.isEmpty()) {
                            ((NumericalDependantEvaluationItem) evaluationItem).setNumber(null);
                            stringEditTextCell.setCorrect(true);
                            return;
                        }
                        ((NumericalDependantEvaluationItem) evaluationItem).setNumber(null);
                        stringEditTextCell.setCorrect(false);
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!hasFocus) {
                        if (!stringEditTextCell.isCorrect()) {
                            String snackbarText = null;
                            if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                            } else if (!editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_range_message), evaluationItem.getName(),
                                        String.valueOf(((NumericalDependantEvaluationItem) evaluationItem).getFrom()), String.valueOf(((NumericalDependantEvaluationItem) evaluationItem).getTo()));
                            }
                            if (snackbarText != null) {
                                Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                        Snackbar.LENGTH_SHORT);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                snackbar.show();
                            }
                        }
                    } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                        stringEditTextCell.setCorrect(false);
                    }
                });
                String dependentItem = ((NumericalDependantEvaluationItem) evaluationItem).getDependsOn();
                for (EvaluationItem tempEvaluationItem : evaluationItemsList) {
                    if (tempEvaluationItem.getId().equals(dependentItem)) {
                        if (tempEvaluationItem instanceof NumericalEvaluationItem) {
                            ((NumericalEvaluationItem) tempEvaluationItem).addOnValueChangeListener(value -> {
                                if (value != null && value >= ((NumericalDependantEvaluationItem) evaluationItem).getEnableFrom()
                                        && value <= ((NumericalDependantEvaluationItem) evaluationItem).getEnableTo()) {
                                    stringEditTextCell.setEnabled(true);
                                } else {
                                    stringEditTextCell.setEnabled(false);
                                }
                            });
                            Double value = ((NumericalEvaluationItem) tempEvaluationItem).getNumber();
                            if (value != null && value >= ((NumericalDependantEvaluationItem) evaluationItem).getEnableFrom()
                                    && value <= ((NumericalDependantEvaluationItem) evaluationItem).getEnableTo()) {
                                stringEditTextCell.setEnabled(true);
                            } else {
                                stringEditTextCell.setEnabled(false);
                            }
                        }

                        break;
                    }
                }
            } else if (evaluationItem instanceof StringEvaluationItem) {
                StringEditTextCell stringEditTextCell = (StringEditTextCell) holder.view;
                stringEditTextCell.setEditable(((StringEvaluationItem) evaluationItem).isEditable());
                setImeOptionsForLastEditText(stringEditTextCell, position);
                CustomEditText editText = stringEditTextCell.getEditText();
                editText.clearTextWatchers();
                if (evaluationItem.getValue() != null) {
                    stringEditTextCell.setCorrect(evaluationItem.isValid());
                }
                String text = ((StringEvaluationItem) evaluationItem).getText();
                if (text != null) {
                    editText.setText(text);
                } else {
                    editText.getText().clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String inputText = s.toString();
                        if (inputText.isEmpty()) {
                            ((StringEvaluationItem) evaluationItem).setText(null);
                            if (!evaluationItem.isMandatory()) {
                                stringEditTextCell.setCorrect(true);
                            } else {
                                stringEditTextCell.setCorrect(false);
                            }
                        } else {
                            ((StringEvaluationItem) evaluationItem).setText(s.toString());
                            stringEditTextCell.setCorrect(true);
                        }
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!hasFocus) {
                        if (!stringEditTextCell.isCorrect()) {
                            String snackbarText;
                            if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                                Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                        Snackbar.LENGTH_SHORT);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                snackbar.show();
                            }
                        }
                    } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                        stringEditTextCell.setCorrect(false);
                    }
                });
            } else if (evaluationItem instanceof MinutesSecondsEvaluationItem) {
                Integer minutes = ((MinutesSecondsEvaluationItem) evaluationItem).getMinutes();
                if (minutes != null) {
                    ((MinutesSecondsCell) holder.view).setMinutes(minutes);
                }
                Integer seconds = ((MinutesSecondsEvaluationItem) evaluationItem).getSeconds();
                if (seconds != null) {
                    ((MinutesSecondsCell) holder.view).setSeconds(seconds);
                }
                ((MinutesSecondsCell) holder.view).addOnMinutesChangeListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() != 0) {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setMinutes(Integer.valueOf(s.toString()));
                        } else {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setMinutes(null);
                        }
                    }
                });
                ((MinutesSecondsCell) holder.view).addOnSecondsChangeListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() != 0) {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setSeconds(Integer.valueOf(s.toString()));
                        } else {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setSeconds(null);
                        }
                    }
                });
            } else if (evaluationItem instanceof SectionCheckboxEvaluationItem) {
                ((SectionCheckboxCell) holder.view).getCheckBox().setOnCheckedChangeListener((buttonView, isChecked) -> ((SectionCheckboxEvaluationItem) evaluationItem).setChecked(isChecked));
                ((SectionCheckboxCell) holder.view).setChecked(((SectionCheckboxEvaluationItem) evaluationItem).isChecked());
                ((SectionCheckboxCell) holder.view).setOnClickListener(v -> {
                    if (isScreenValid()) {
                        if (activity instanceof AppCompatActivity && ((SectionCheckboxCell) holder.view).isChecked()) {
                            saveAllValues();
                            FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                            if (fragmentManager != null) {
                                EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable(ConfigurationParams.NEXT_SECTION, evaluationItem);
                                bundle.putString(ConfigurationParams.SUBTITLE, parentTitle);
                                bundle.putBoolean(ConfigurationParams.SHOULD_SHOW_ALERT, ((SectionCheckboxEvaluationItem) evaluationItem).isShouldShowAlert());
                                evaluationListFragment.setArguments(bundle);
                                fragmentManager.beginTransaction()
                                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                        .replace(R.id.container, evaluationListFragment)
                                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                                        .commit();
                            }
                        }
                    } else {
                        showSnackbarBottomButtonError(((SectionCheckboxCell) holder.view).getRootView());
                    }
                });
            } else if (evaluationItem instanceof BoldEvaluationItem) {
                ((BoldTextCell) holder.view).setBackgroundHighlighted(((BoldEvaluationItem) evaluationItem).isBackgroundHighlighted());
            } else if (evaluationItem instanceof DatePickerEvaluationItem) {
                DatePicker datePicker = ((DatePickerCell) holder.view).getDatePicker();
                Calendar calendar = Calendar.getInstance();
                Long value = ((DatePickerEvaluationItem) evaluationItem).getDate();
                if (value != null) {
                    calendar.setTimeInMillis(value);
                }
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), (view, year, monthOfYear, dayOfMonth) -> {
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.MONTH, monthOfYear);
                    cal.set(Calendar.YEAR, year);
                    evaluationItem.setValue(cal.getTimeInMillis());
                });
            }
        }
    }

    public void saveAllValues() {
        for (EvaluationItem evaluationItem : evaluationItemsList) {
            EvaluationDAO.getInstance().addToHashMap(evaluationItem.getId(), evaluationItem.getValue());
        }
        EvaluationDAO.getInstance().saveValues();
    }

    public boolean isScreenValid() {
        return isScreenValid(true);
    }

    public boolean isScreenValid(boolean isEmptyAllowed) {
        boolean isValid = true;
        boolean isAllTheSame = true;
        boolean isFilled = true;
        for (int i = 0; i < evaluationItemsList.size(); i++) {
            EvaluationItem evaluationItem = evaluationItemsList.get(i);
            if (!evaluationItem.isValid()) {
                isValid = false;
            }
            if (!isEmptyAllowed && evaluationItem.isMandatory() && (evaluationItem instanceof NumericalEvaluationItem || evaluationItem instanceof StringEvaluationItem) && evaluationItem.getValue() == null) {
                isFilled = false;
            }
            if (!Objects.equals(evaluationItem.getValue(), oldValues.get(i))) {
                isAllTheSame = false;
            }
            if (!isValid && !isAllTheSame) {
                break;
            }
        }
        return isValid || (isAllTheSame && isFilled);
    }

    private void goToNextScreen(int position, SectionEvaluationItem evaluationItem) {
        saveAllValues();
        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        if (fragmentManager != null) {
            Bundle bundle = new Bundle();
            ArrayList<SectionEvaluationItem> nextSectionsArrayList = new ArrayList<>();
            for (int i = position + 1; i < getItemCount(); i++) {
                EvaluationItem nextEvaluationItem = evaluationItemsList.get(i);
                if (nextEvaluationItem instanceof SectionEvaluationItem) {
                    if (!((SectionEvaluationItem) nextEvaluationItem).isBottomButtonReferenceSkipped()) {
                        nextSectionsArrayList.add((SectionEvaluationItem) nextEvaluationItem);
                    }
                }
            }
            if (nextSectionEvaluationItems != null) {
                nextSectionsArrayList.addAll(nextSectionEvaluationItems);
            }
            bundle.putSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionsArrayList);
            if (evaluationItem.getEvaluationItemList().size() == 1 && evaluationItem.getEvaluationItemList().get(0) instanceof TabEvaluationItem) {
                TabFragment tabFragment = new TabFragment();
                bundle.putSerializable(ConfigurationParams.TAB_SECTION_LIST, ((TabEvaluationItem) evaluationItem.getEvaluationItemList().get(0)).getTabSectionList());
                tabFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, tabFragment)
                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                        .commit();
                if (evaluationItem.getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    evaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            } else {
                EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                bundle.putSerializable(ConfigurationParams.NEXT_SECTION, evaluationItem);
                bundle.putBoolean(ConfigurationParams.SHOULD_SHOW_ALERT, evaluationItem.isShouldShowAlert());

                evaluationListFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, evaluationListFragment)
                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                        .commit();
                if (evaluationItem.getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    evaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            }
        }
    }

    private void goToMandatorySection(Activity activity, SectionEvaluationItem sectionEvaluationItem) {
        if (sectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
            String dependsOn = sectionEvaluationItem.getDependsOn();
            SectionEvaluationItem finalMainEvaluationItem = null;
            for (EvaluationItem evaluationItem : evaluationItemsList) {
                if (evaluationItem instanceof SectionEvaluationItem && evaluationItem.getId().equals(dependsOn)) {
                    finalMainEvaluationItem = (SectionEvaluationItem) evaluationItem;
                }
            }
            if (finalMainEvaluationItem != null) {
                goToMandatorySection(activity, finalMainEvaluationItem);
            }
        } else if (activity instanceof AppCompatActivity) {
            AlertModalManager.createAndShowDependsOnSectionAlertDialog(activity, sectionEvaluationItem.getName(), v -> {
                saveAllValues();
                FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                if (fragmentManager != null) {
                    EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION, sectionEvaluationItem);
                    ArrayList<SectionEvaluationItem> nextSectionsArrayList = new ArrayList<>();
                    int position = evaluationItemsList.indexOf(sectionEvaluationItem);
                    for (int i = position + 1; i < getItemCount(); i++) {
                        EvaluationItem nextEvaluationItem = evaluationItemsList.get(i);
                        if (nextEvaluationItem instanceof SectionEvaluationItem) {
                            nextSectionsArrayList.add((SectionEvaluationItem) nextEvaluationItem);
                        }
                    }
                    nextSectionsArrayList.addAll(nextSectionEvaluationItems);
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionsArrayList);
                    bundle.putString(ConfigurationParams.SUBTITLE, parentTitle);
                    evaluationListFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, evaluationListFragment)
                            .addToBackStack(fragmentManager.getClass().getSimpleName() + sectionEvaluationItem.getName())
                            .commit();
                    if ((sectionEvaluationItem).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                        (sectionEvaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                    }
                }
            });
        }
    }

    private void setImeOptionsForLastEditText(StringEditTextCell stringEditTextCell, int position) {
        boolean isLastInput = true;
        for (int i = position + 1; i < getItemCount(); i++) {
            if (getItemViewType(position) == 1 || getItemViewType(position) == 2 || getItemViewType(position) == 9) {
                isLastInput = false;
                break;
            }
        }
        if (isLastInput) {
            stringEditTextCell.setImeOptions(EditorInfo.IME_ACTION_DONE);
        }
    }

    @Override
    public int getItemCount() {
        return evaluationItemsList.size();
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    private void showSnackbarBottomButtonError(View view) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(view, R.string.snackbar_bottom_button_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        protected CellItem view;

        ViewHolder(View itemView) {
            super(itemView);
            view = (CellItem) itemView;
        }
    }
}
