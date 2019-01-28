package com.company.kpisample.listener;

import com.company.kpisample.entity.Achievement;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.kpisample.entity.Task;
import org.slf4j.Logger;

import javax.inject.Inject;

@Component("kpisample_TaskEntityListener")
public class TaskEntityListener implements BeforeUpdateEntityListener<Task> {
    @Inject
    private Logger log;
    private Double totalAchievement;


    @Override
    public void onBeforeUpdate(Task entity, EntityManager entityManager) {

//        Double taskAchievement = 0.0;
//        log.error("starting task achievement entity listener code");
//        for (Achievement a : entity.getAchievement()) {
//            totalAchievement = nullToZero(a.getAchievement());
//            taskAchievement = taskAchievement + totalAchievement;
//
//        }
//        entity.setTaskAchievement(nullToZero(taskAchievement));

    }

//    Double nullToZero(Double d) {
//        if (d == null) {
//            return 0.0;
//        } else {
//            return d;
//        }
//    }


}