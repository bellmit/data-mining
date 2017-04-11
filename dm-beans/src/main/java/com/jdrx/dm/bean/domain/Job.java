package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 任务对象
 * Created by 赵少泉 on 2016-07-08.
 */
public class Job implements Serializable {
    private String jobId;                       // 任务ID
    private String jobBusinessId;               // 业务ID
    private String jobSourceId;                 // 源数据ID
    private String jobStatus;                   // 任务状态

    public Job() {

    }

    public Job(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobBusinessId() {
        return jobBusinessId;
    }

    public void setJobBusinessId(String jobBusinessId) {
        this.jobBusinessId = jobBusinessId;
    }

    public String getJobSourceId() {
        return jobSourceId;
    }

    public void setJobSourceId(String jobSourceId) {
        this.jobSourceId = jobSourceId;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId='" + jobId + '\'' +
                ", jobBusinessId='" + jobBusinessId + '\'' +
                ", jobSourceId='" + jobSourceId + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                '}';
    }
}
