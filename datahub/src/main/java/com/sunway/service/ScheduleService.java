package com.sunway.service;

import com.sunway.model.IoBaseEntity;
import com.sunway.utils.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sunway.utils.Notice.DEVICELIST;

@Component
public class ScheduleService {

    public final static long SCHE_SECOND =  1 * 1000;

    private boolean isInitialize = false;

    @Autowired
    private RealDataService realDataService;

    @Autowired
    private HistoryDataService hisDataService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(initialDelay = SCHE_SECOND*2, fixedDelay=SCHE_SECOND*3)
    private void transferReal2His(){

        //System.out.println( sdf.format(new Date()));

        if(!isInitialize){ hisDataService.initial();  isInitialize =true;}
        List<Object> deviceList = realDataService.getAllDevices();

        for (Object device : deviceList){
            ArrayList temp = (ArrayList)device;
            for(Object obj : temp){
                Map<String, Object> varMap = realDataService.queryRealDataByDevice((String)obj);
                if(varMap!=null) System.out.println(varMap);
                hisDataService.writeDeviceHistoryData((String)obj, varMap);
            }
        }
    }
}
