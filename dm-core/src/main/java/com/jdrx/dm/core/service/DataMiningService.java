package com.jdrx.dm.core.service;

import com.jdrx.dm.baseinfo.commons.JsonUtils;
import com.jdrx.dm.baseinfo.commons.ReplaceChars;
import com.jdrx.dm.bean.domain.*;
import com.jdrx.dm.bean.input.InParam;
import com.jdrx.dm.core.ArithmeticFactory;
import com.jdrx.dm.core.mapper.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jdrx.dm.core.AzkabanFactory.newAzkaban;

/**
 * Created by 赵少泉 on 2016-07-18.
 */
@Service
@Transactional(readOnly = true)
public class DataMiningService {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private DbInstanceMapper dbInstanceMapper;
    @Autowired
    private SourceColumnMapper sourceColumnMapper;
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private ResultColumnMapper resultColumnMapper;

    @Transactional(readOnly = false)
    public void input(InParam in)throws Exception{
        dbInstanceMapper.save(in.getInstance());
        sourceMapper.save(in.getSource());

        SourceColumn sc1 = new SourceColumn();
        sc1.setSourceId("0");
        sc1.setOldName("paied_flow");
        sc1.setNewName("c0");
        sc1.setOldIdx(0);
        sc1.setNewIdx(1);
        sc1.setColType("float");
        sourceColumnMapper.save(sc1);

        SourceColumn sc2 = new SourceColumn();
        sc2.setSourceId("0");
        sc2.setOldName("td_flow");
        sc2.setNewName("c1");
        sc2.setOldIdx(1);
        sc2.setNewIdx(2);
        sc2.setColType("float");
        sourceColumnMapper.save(sc2);

        SourceColumn sc3 = new SourceColumn();
        sc3.setSourceId("0");
        sc3.setOldName("gprs_flow");
        sc3.setNewName("c2");
        sc3.setOldIdx(2);
        sc3.setNewIdx(3);
        sc3.setColType("float");
        sourceColumnMapper.save(sc3);

        SourceColumn sc4 = new SourceColumn();
        sc4.setSourceId("0");
        sc4.setOldName("brand");
        sc4.setNewName("c3");
        sc4.setOldIdx(3);
        sc4.setNewIdx(0);
        sc4.setColType("int");
        sourceColumnMapper.save(sc4);

        Business business = new Business();
        business.setBusinessId("0");
        business.setAlgorithmType("0");
        business.setAlgorithmContent("{\"DT\":0,\"LR\":0}");
        businessMapper.save(business);

        Job job = new Job();
        job.setJobId("0");
        job.setJobBusinessId("0");
        job.setJobSourceId("0");
        job.setJobStatus("0");
        jobMapper.save(job);

        this.insertResult();
        this.insertResultColumn();
        ArithmeticFactory.saveArithmetic2(in.getArithmetic(), in.getType());

//        newAzkaban().login().uploadJob();
    }

    private void insertResult()throws Exception{
        Result r0 = new Result();
        r0.setResultId("0");
        r0.setInstanceId("0");
        r0.setJobId("0");
        r0.setResultDb("dm_demo");
        r0.setResultTable("dt_detail");
        resultMapper.save(r0);

        Result r1 = new Result();
        r1.setResultId("1");
        r1.setInstanceId("0");
        r1.setJobId("0");
        r1.setResultDb("dm_demo");
        r1.setResultTable("dt_summary");
        resultMapper.save(r1);

        Result r2 = new Result();
        r2.setResultId("2");
        r2.setInstanceId("0");
        r2.setJobId("0");
        r2.setResultDb("dm_demo");
        r2.setResultTable("lr_detail");
        resultMapper.save(r2);

        Result r3 = new Result();
        r3.setResultId("3");
        r3.setInstanceId("0");
        r3.setJobId("0");
        r3.setResultDb("dm_demo");
        r3.setResultTable("lr_summary");
        resultMapper.save(r3);
    }

    private void insertResultColumn()throws Exception{
        StringBuilder sqlJson = new StringBuilder();
        sqlJson.append("{'resultId':'0','colName':'predict','colType':'int','colIdx':'0'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'0','colName':'brand','colType':'int','colIdx':'1'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'0','colName':'paied_flow','colType':'float','colIdx':'2'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'0','colName':'td_flow','colType':'float','colIdx':'3'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'0','colName':'gprs_flow','colType':'float','colIdx':'4'}").append(ArithmeticFactory.SPLIT);

        sqlJson.append("{'resultId':'1','colName':'accuracy_rate','colType':'float','colIdx':'0'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'1','colName':'y_predict_100','colType':'int','colIdx':'1'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'1','colName':'y_predict_200','colType':'int','colIdx':'2'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'1','colName':'y_predict_300','colType':'int','colIdx':'3'}").append(ArithmeticFactory.SPLIT);

        sqlJson.append("{'resultId':'2','colName':'predict','colType':'int','colIdx':'0'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'2','colName':'brand','colType':'int','colIdx':'1'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'2','colName':'paied_flow','colType':'float','colIdx':'2'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'2','colName':'td_flow','colType':'float','colIdx':'3'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'2','colName':'gprs_flow','colType':'float','colIdx':'4'}").append(ArithmeticFactory.SPLIT);

        sqlJson.append("{'resultId':'3','colName':'accuracy_rate','colType':'float','colIdx':'0'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'3','colName':'y_predict_100','colType':'int','colIdx':'1'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'3','colName':'y_predict_200','colType':'int','colIdx':'2'}").append(ArithmeticFactory.SPLIT);
        sqlJson.append("{'resultId':'3','colName':'y_predict_300','colType':'int','colIdx':'3'}").append(ArithmeticFactory.SPLIT);

        for(String json : StringUtils.split(sqlJson.toString(), ArithmeticFactory.SPLIT)){
            ResultColumn resultColumn = JsonUtils.json2object(json, ResultColumn.class, new ReplaceChars("'", "\""));
            resultColumnMapper.save(resultColumn);
        }
    }

}
