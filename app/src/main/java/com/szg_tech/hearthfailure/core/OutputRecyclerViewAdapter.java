package com.szg_tech.hearthfailure.core;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.hearthfailure.core.views.cell.BoldTextCell;
import com.szg_tech.hearthfailure.core.views.cell.CellItem;
import com.szg_tech.hearthfailure.core.views.cell.HeartPartnerCell;
import com.szg_tech.hearthfailure.core.views.cell.ICOCardCell;
import com.szg_tech.hearthfailure.core.views.cell.StringEditTextCell;
import com.szg_tech.hearthfailure.core.views.cell.TextCell;
import com.szg_tech.hearthfailure.entities.EvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.HeartPartnerEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.ICOCellEvaluationItem;
import com.szg_tech.hearthfailure.entities.evaluation_item_elements.TextEvaluationItem;

import java.util.List;

public class OutputRecyclerViewAdapter extends RecyclerView.Adapter<OutputRecyclerViewAdapter.ViewHolder> {
    private Activity activity;
    private List<EvaluationItem> evaluationItemsList;


    public OutputRecyclerViewAdapter(Activity activity, List<EvaluationItem> evaluationItemsList) {
        this.activity = activity;
        this.evaluationItemsList = evaluationItemsList;
    }

    @Override
    public int getItemViewType(int position) {
        EvaluationItem evaluationItem = evaluationItemsList.get(position);
        if (evaluationItem instanceof BoldEvaluationItem) {
            return 0;
        } else if (evaluationItem instanceof TextEvaluationItem) {
            return 1;
        } else if (evaluationItem instanceof HeartPartnerEvaluationItem) {
            return 2;
        } else if (evaluationItem instanceof ICOCellEvaluationItem) {
            return 3;
        }
        return -1;
    }

    @Override
    public OutputRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switch (viewType) {
            case 0:
                BoldTextCell boldTextCell = new BoldTextCell(activity);
                boldTextCell.setLayoutParams(layoutParams);
                return new OutputRecyclerViewAdapter.ViewHolder(boldTextCell);
            case 1:
                TextCell textCell = new TextCell(activity);
                textCell.setLayoutParams(layoutParams);
                return new OutputRecyclerViewAdapter.ViewHolder(textCell);
            case 2:
                HeartPartnerCell heartPartnerCell = new HeartPartnerCell(activity);
                heartPartnerCell.setLayoutParams(layoutParams);
                return new OutputRecyclerViewAdapter.ViewHolder(heartPartnerCell);
            case 3:
                ICOCardCell icoCardCell = new ICOCardCell(activity);
                icoCardCell.setLayoutParams(layoutParams);
                return new OutputRecyclerViewAdapter.ViewHolder(icoCardCell);
        }
        StringEditTextCell stringEditTextCell = new StringEditTextCell(activity);
        return new OutputRecyclerViewAdapter.ViewHolder(stringEditTextCell);
    }

    @Override
    public void onBindViewHolder(OutputRecyclerViewAdapter.ViewHolder holder, int position) {
        if (holder != null) {
            EvaluationItem evaluationItem = evaluationItemsList.get(position);
            holder.view.setLabelText(evaluationItem.getName());
            holder.view.setHintText(evaluationItem.getHint());
            if (evaluationItem instanceof HeartPartnerEvaluationItem) {
                HeartPartnerCell heartPartnerCell = (HeartPartnerCell) holder.view;
                heartPartnerCell.setDepartmentName(((HeartPartnerEvaluationItem) evaluationItem).getDepartmentName());
                heartPartnerCell.setDescription(((HeartPartnerEvaluationItem) evaluationItem).getDescription());
                heartPartnerCell.setHours(((HeartPartnerEvaluationItem) evaluationItem).getHours());
            } else if (evaluationItem instanceof ICOCellEvaluationItem) {
                ICOCardCell icoCardCell = (ICOCardCell) holder.view;
                icoCardCell.setBlueTextViewText(((ICOCellEvaluationItem) evaluationItem).getBlueButtonText());
                icoCardCell.setGreenTextView(((ICOCellEvaluationItem) evaluationItem).getGreenButtonText());
            }
        }
    }

    @Override
    public int getItemCount() {
        return evaluationItemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        protected CellItem view;

        ViewHolder(View itemView) {
            super(itemView);
            view = (CellItem) itemView;
        }
    }
}
