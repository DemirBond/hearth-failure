package com.szg_tech.hearthfailure.fragments.about;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.hearthfailure.BuildConfig;
import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.AbstractPresenter;

class AboutPresenterImpl extends AbstractPresenter<AboutView> implements AboutPresenter {
    AboutPresenterImpl(AboutView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            recyclerView.setAdapter(new RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.about);
            }
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<AboutPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;
        private Context context;

        RecyclerViewAdapter(Context context) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public AboutPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case 0:
                    view = layoutInflater.inflate(R.layout.about_section_item, parent, false);
                    return new ViewHolder(view);
                case 1:
                    view = layoutInflater.inflate(R.layout.about_bold_item, parent, false);
                    return new ViewHolder(view);
                case 2:
                    view = layoutInflater.inflate(R.layout.about_map_item, parent, false);
                    return new MapItemViewHolder(view);
                case 3:
                default:
                    view = layoutInflater.inflate(R.layout.about_text_item, parent, false);
                    return new ViewHolder(view);
            }
        }


        @Override
        public void onBindViewHolder(AboutPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
            switch (holder.getItemViewType()) {
                case 0:
                    if (position == 0) {
                        holder.text.setText(R.string.privacy_policy);
                    } else if (position == 1) {
                        holder.text.setText(R.string.terms_of_use);
                    } else if (position == 2) {
                        holder.text.setText(R.string.help_support);
//                        ((CardView) holder.view).setUseCompatPadding(true);
                        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.view.getLayoutParams();
                        params.setMargins(0, 0, 0, 1);
                    }
                    break;
                case 1:
                    if (position == 3) {
                        holder.text.setText(R.string.development);
                    } else if (position == 7) {
                        holder.text.setText(R.string.version_caps);
                    }
                    break;
                case 2:
                    if (position == 4) {
                        holder.text.setText(R.string.logic);
                        ((MapItemViewHolder) holder).value.setText(R.string.logic_dev_name);
                    } else if (position == 5) {
                        holder.text.setText(R.string.engineering);
                        ((MapItemViewHolder) holder).value.setText(R.string.engineering_dev_name);
                    } else if (position == 6) {
                        holder.text.setText(R.string.design);
                        ((MapItemViewHolder) holder).value.setText(R.string.designer_name);
                    }
                    RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.view.getLayoutParams();
                    params.setMargins(0, 0, 0, 1);
                    break;
                case 3:
                    holder.text.setText(String.format(context.getString(R.string.version), BuildConfig.VERSION_NAME));
                    break;
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position < 3) {
                return 0;
            } else if (position == 3 || position == 7) {
                return 1;
            } else if (position > 3 && position < 7) {
                return 2;
            } else {
                return 3;
            }
        }

        @Override
        public int getItemCount() {
            return 9;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            protected View view;
            TextView text;

            ViewHolder(View itemView) {
                super(itemView);
                this.view = itemView;
                this.text = (TextView) itemView.findViewById(R.id.text);
            }
        }

        class MapItemViewHolder extends ViewHolder {
            TextView value;

            MapItemViewHolder(View itemView) {
                super(itemView);
                this.value = (TextView) itemView.findViewById(R.id.value);
            }
        }
    }
}
