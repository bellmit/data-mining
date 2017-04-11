package com.jdrx.dm.bean.domain;

import java.io.Serializable;

/**
 * 结果集
 * Created by 赵少泉 on 2016-07-08.
 */
public class Result implements Serializable {
    private String resultId;                        // 结果集ID
    private String instanceId;                      // 数据实例ID
    private String jobId;                           // 任务ID
    private String resultDb;                        // 结果集库名
    private String resultTable;                     // 结果集表名

    public Result() {

    }

    public Result(String resultId) {
        this.resultId = resultId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getResultDb() {
        return resultDb;
    }

    public void setResultDb(String resultDb) {
        this.resultDb = resultDb;
    }

    public String getResultTable() {
        return resultTable;
    }

    public void setResultTable(String resultTable) {
        this.resultTable = resultTable;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId='" + resultId + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", resultDb='" + resultDb + '\'' +
                ", resultTable='" + resultTable + '\'' +
                '}';
    }
}
