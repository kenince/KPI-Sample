package com.company.kpisample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name = "KPISAMPLE_ACHIEVEMENT")
@Entity(name = "kpisample$Achievement")
public class Achievement extends StandardEntity {
    private static final long serialVersionUID = -4886624025643809366L;

    @Column(name = "ACHIEVEMENT")
    protected Double achievement;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACHIEVEMENT_DATE")
    protected Date achievementDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KPI_ID")
    protected KPI kPI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    protected Task task;

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }


    public void setKPI(KPI kPI) {
        this.kPI = kPI;
    }

    public KPI getKPI() {
        return kPI;
    }


    public void setAchievement(Double achievement) {
        this.achievement = achievement;
    }

    public Double getAchievement() {
        return achievement;
    }

    public void setAchievementDate(Date achievementDate) {
        this.achievementDate = achievementDate;
    }

    public Date getAchievementDate() {
        return achievementDate;
    }


}