package com.rbsagile.tcsrbs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BackLog {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer PTsequence =0;
    private String empId;

    public BackLog() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getPTsequence() {
        return PTsequence;
    }

    public void setPTsequence(Integer PTsequence) {
        this.PTsequence = PTsequence;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
