package com.company.kpisample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;

@NamePattern("%s|kpi")
@Table(name = "KPISAMPLE_KPI")
@Entity(name = "kpisample$KPI")
public class KPI extends StandardEntity {
    private static final long serialVersionUID = 2941091861339536359L;

    @Column(name = "KPI")
    protected String kpi;

    @Column(name = "BASELINE")
    protected Double baseline;

    @Column(name = "TARGET")
    protected Double target;

    @Column(name = "TOTAL_ACHIEVEMENT")
    protected Double totalAchievement;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "kPI")
    protected List<Achievement> achievement;

    @OneToMany(mappedBy = "kPI")
    protected List<Task> task;

    public void setAchievement(List<Achievement> achievement) {
        this.achievement = achievement;
    }

    public List<Achievement> getAchievement() {
        return achievement;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public List<Task> getTask() {
        return task;
    }


    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public String getKpi() {
        return kpi;
    }

    public void setBaseline(Double baseline) {
        this.baseline = baseline;
    }

    public Double getBaseline() {
        return baseline;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getTarget() {
        return target;
    }

    public void setTotalAchievement(Double totalAchievement) {
        this.totalAchievement = totalAchievement;
    }

    public Double getTotalAchievement() {
        return totalAchievement;
    }


}