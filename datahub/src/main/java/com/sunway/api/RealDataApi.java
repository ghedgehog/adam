package com.sunway.api;

import com.sunway.service.HistoryDataService;
import com.sunway.service.RealDataService;
import com.sunway.utils.DataTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="real")
public class RealDataApi {

    @Autowired
    RealDataService realDataService;

    @Autowired
    HistoryDataService historyDataService;

    DataTool dataTool = new DataTool();

    @RequestMapping("/write")
    public void writeRealData(String name, String value){

        //存进缓存
        realDataService.set(name, value);

    }
}