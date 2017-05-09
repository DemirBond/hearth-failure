package com.szg_tech.hearthfailure.fragments.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.evaluation.EvaluationActivity;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.fragments.saved_evaluation_list.SavedEvaluationFragment;
import com.szg_tech.hearthfailure.storage.EvaluationDAO;

class HomePresenterImpl extends AbstractPresenter<HomeView> implements HomePresenter {

    HomePresenterImpl(HomeView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.heart_check);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.home_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
            if (position == 0) {
                holder.image.setImageResource(R.drawable.clipboard);
                holder.title.setText(R.string.new_evaluation_title);
                holder.description.setText(R.string.new_evaluation_description);
                holder.view.setOnClickListener(v -> {
                    EvaluationDAO.getInstance().clearEvaluation();
                    getView().startActivity(EvaluationActivity.class);
                });
            } else if (position == 1) {
                holder.image.setImageResource(R.drawable.locked);
                holder.title.setText(R.string.saved_evaluation_title);
                holder.description.setText(R.string.saved_evaluation_desription);
                holder.image.setImageResource(R.drawable.folder);
                holder.view.setOnClickListener(v -> {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, new SavedEvaluationFragment())
                            .addToBackStack(getSupportFragmentManager().getClass().getSimpleName())
                            .commit();
                });
//                Activity activity = getActivity();
//                if (activity instanceof MainActivity) {
//                    ((MainActivity) activity).setOnAuthorizationChangedListener(isAuthorized -> {
//                        if (isAuthorized) {
//                            holder.image.setImageResource(R.drawable.folder);
//                        } else {
//                            holder.image.setImageResource(R.drawable.locked);
//                        }
//                    });
//                }
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            ImageView image;
            TextView title;
            TextView description;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                image = (ImageView) itemView.findViewById(R.id.image);
                title = (TextView) itemView.findViewById(R.id.title);
                description = (TextView) itemView.findViewById(R.id.description);
            }
        }
    }
}
