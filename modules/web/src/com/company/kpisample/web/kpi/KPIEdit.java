package com.company.kpisample.web.kpi;

import com.company.kpisample.entity.Achievement;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.kpisample.entity.KPI;
import org.slf4j.Logger;

import javax.inject.Inject;

public class KPIEdit extends AbstractEditor<KPI> {

//    ###### Injections Come Here #####
    @Inject
    private Logger log;
    private Double totalAchievement;

//    ##### Overrides Go Here ######



//    ###### ALL CODE GOES DOWN HERE ###

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
}