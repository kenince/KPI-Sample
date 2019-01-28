package com.company.kpisample.web.task;

import com.company.kpisample.entity.Achievement;
import com.company.kpisample.entity.KPI;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.kpisample.entity.Task;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

import com.haulmont.cuba.gui.data.GroupDatasource;
import org.slf4j.Logger;
import com.haulmont.cuba.gui.components.Component;

public class TaskEdit extends AbstractEditor<Task> {

    @Named("kpiFieldGroup.kPI")
    private LookupPickerField kPIField;
    @Named("taskFieldGroup.taskTarget")
    private TextField taskTargetField;
    @Named("kpiFieldGroup.kpiTarget")
    private TextField kpiTargetField;
    @Named("kpiFieldGroup.kpiAchievement")
    private TextField kpiAchievementField;
    @Named("taskFieldGroup.taskAchievement")
    private TextField taskAchievementField;
    @Inject
    private CollectionDatasource<KPI, UUID> kPIsDs;
    @Inject
    private Metadata metadata;
    @Inject
    private Datasource<Task> taskDs;
    @Inject
    private CollectionDatasource<Achievement, UUID> achievementDs;
    @Inject
    private Logger log;
    private Double totalAchievement;
    @Inject
    private GroupDatasource<Achievement, UUID> achievementsDs;

    @Override
    public void init(Map<String, Object> params) {
        manageKPIField();



        super.init(params);
    }


    @Override
    public void ready() {
        updateKPIDetails();
//        getItem().setTaskAchievement(1.0);
        refreshTaskAchievement();

        super.ready();
    }
    private void refreshTaskAchievement() {
        achievementsDs.addCollectionChangeListener(e -> {
            log.error("Checking the size = "+ e.getItems().size());
            if (e.getItems().size() !=0){
                setTaskAchievements();
                log.error("log size = " + e.getItems().size());
            }


        });
    }

    private void setTaskAchievements() {
        Double taskAchievement = 0.0;
        log.error("starting task achievement code");
        for (Achievement a : getItem().getAchievement()) {
                totalAchievement = nullToZero(a.getAchievement());
                taskAchievement = taskAchievement + totalAchievement;

        }
        getItem().setTaskAchievement(nullToZero(taskAchievement));
    }

    private void manageKPIField() {

        kPIField.addValueChangeListener(e -> {
            if (e.getValue() !=null){
                taskTargetField.setEditable(true);
                taskTargetField.setRequired(true);
            }
            else {
                taskTargetField.setEditable(false);
                taskTargetField.setValue(null);
                kpiTargetField.setValue(null);
                kpiAchievementField.setValue(null);
                taskTargetField.setRequired(false);
            }
        });
    }

    private void updateKPIDetails() {
        kPIField.addValueChangeListener(e -> {
            if (e.getValue() !=null){
                kPIsDs.refresh();
                getItem().setKpiTarget(nullToZero(getItem().getKPI().getTarget()));
                getItem().setKpiAchievement(nullToZero(getItem().getKPI().getTotalAchievement()));
            }
        });
    }

    Double nullToZero(Double d) {
    if (d == null) {
        return 0.0;
    } else {
        return d;
    }
}

    public void onAddAchievementButtonClick() {
        Achievement achievementAdd = metadata.create(Achievement.class);
        log.warn("Task Name = " + getItem().getTaskName());
        log.warn("KPI Name = " + getItem().getKPI().getKpi());
        achievementAdd.setTask(getItem());
        achievementAdd.setKPI(getItem().getKPI());
        openEditor("kpisample$Achievement.edit", achievementAdd, WindowManager.OpenType.DIALOG).addCloseWithCommitListener(() -> {
            taskDs.refresh();
            achievementDs.refresh();
        });
    }

}