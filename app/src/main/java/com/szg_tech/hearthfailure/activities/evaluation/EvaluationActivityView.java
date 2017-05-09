package com.szg_tech.hearthfailure.activities.evaluation;

import com.szg_tech.hearthfailure.core.MVPView;
import com.szg_tech.hearthfailure.entities.evaluation_items.HeartSpecialistManagement;

interface EvaluationActivityView extends MVPView {
    HeartSpecialistManagement getHeartSpecialistManagement();

    void onSessionExpired();
}
