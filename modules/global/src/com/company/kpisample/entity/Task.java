package com.company.kpisample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("kpisample_TaskEntityListener")
@NamePattern("%s|taskName")
@Table(name = "KPISAMPLE_TASK")
@Entity(name = "kpisample$Task")
public class Task extends StandardEntity {
    private static final long serialVersionUID = 1017051889248937423L;

    @Column(name = "TASK_NAME")
    protected String taskName;

    @Column(name = "TASK_TARGET")
    protected Double taskTarget;

    @Column(name = "TASK_ACHIEVEMENT")
    protected Double taskAchievement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KPI_ID")
    protected KPI kPI;

    @Column(name = "KPI_TARGET")
    protected Double kpiTarget;

    @Column(name = "KPI_ACHIEVEMENT")
    protected Double kpiAchievement;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "task")
    protected List<Achievement> achievement;

    public void setKpiTarget(Double kpiTarget) {
        this.kpiTarget = kpiTarget;
    }

    public Double getKpiTarget() {
        return kpiTarget;
    }

    public void setKpiAchievement(Double kpiAchievement) {
        this.kpiAchievement = kpiAchievement;
    }

    public Double getKpiAchievement() {
        return kpiAchievement;
    }


    public void setAchievement(List<Achievement> achievement) {
        this.achievement = achievement;
    }

    public List<Achievement> getAchievement() {
        return achievement;
    }


    public void setKPI(KPI kPI) {
        this.kPI = kPI;
    }

    public KPI getKPI() {
        return kPI;
    }


    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskTarget(Double taskTarget) {
        this.taskTarget = taskTarget;
    }

    public Double getTaskTarget() {
        return taskTarget;
    }

    public void setTaskAchievement(Double taskAchievement) {
        this.taskAchievement = taskAchievement;
    }

    public Double getTaskAchievement() {
        return taskAchievement;
    }


}