package com.company.kpisample.web.kpi;

import com.company.kpisample.entity.Achievement;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.kpisample.entity.KPI;
import com.haulmont.cuba.gui.data.GroupDatasource;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class KPIEdit extends AbstractEditor<KPI> {

//    ###### Injections Come Here #####
    @Inject
    private Logger log;
    private Double totalAchievement;
    @Inject
    private GroupDatasource<Achievement, UUID> achievementsDs;
    @Inject
    private Metadata metadata;
    //    ##### Overrides Go Here ######


    @Override
    public void init(Map<String, Object> params) {
        updateAchievements();
        super.init(params);
    }


//    ###### ALL CODE GOES DOWN HERE ###

    private void updateAchievements() {
        achievementsDs.addCollectionChangeListener(e -> {
            if (e.getItems().size() !=0){
                setKPIAchievements();
            }
        });

    }

    private void setKPIAchievements() {
        Double kpiAchievement = 0.0;
        log.error("starting task achievement code");
        for (Achievement a : getItem().getAchievement()) {
            totalAchievement = nullToZero(a.getAchievement());
            kpiAchievement = kpiAchievement + totalAchievement;

        }
        getItem().setTotalAchievement(nullToZero(kpiAchievement));
    }

    Double nullToZero(Double d) {
        if (d == null) {
            return 0.0;
        } else {
            return d;
        }
    }

    public void onAddAchievementClick() {
        Achievement achievementAdd = metadata.create(Achievement.class);
        achievementAdd.setKPI(getItem());
        openEditor("kpisample$Achievement.edit", achievementAdd, WindowManager.OpenType.DIALOG).addCloseWithCommitListener(() -> {
            achievementsDs.refresh();
        });
    }
}