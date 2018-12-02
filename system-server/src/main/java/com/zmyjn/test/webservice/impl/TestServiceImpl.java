//package com.zmyjn.test.webservice.impl;
//
//import com.alibaba.druid.support.json.JSONUtils;
//import com.zmyjn.test.webservice.TestService;
//
//import javax.jws.WebService;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@WebService(targetNamespace="http://webservice.test.zmyjn.com/",endpointInterface = "com.zmyjn.test.webservice.TestService")
//public class TestServiceImpl implements TestService {
//
//
//    @Override
//    public String getParam(String param) {
//        return "webservice param:"+param;
//    }
//
//    @Override
//    public String getFirmInfo(String firmName) {
//
//        Map<String,Object> map = new HashMap<>();
//
//        List<Map> list = new ArrayList<>();
//
//        if(firmName!=null){
//
//            Map<String,Object> firmMap = new HashMap<>();
//            firmMap.put("id","1");
//            firmMap.put("law_name","001律师事务所");
//            firmMap.put("code","001");
//            firmMap.put("city","深圳");
//            firmMap.put("web_url","http://baidu.com");
//            list.add(firmMap);
//
//        }else{
//            // 查询全部
//            Map<String,Object> firmMap = new HashMap<>();
//            firmMap.put("id","1");
//            firmMap.put("law_name","001律师事务所");
//            firmMap.put("code","001");
//            firmMap.put("city","深圳");
//            firmMap.put("web_url","http://baidu.com");
//            list.add(firmMap);
//
//            Map<String,Object> firmMap2 = new HashMap<>();
//            firmMap2.put("id","2");
//            firmMap2.put("law_name","002律师事务所");
//            firmMap2.put("code","002");
//            firmMap2.put("city","广州");
//            firmMap2.put("web_url","http://baidu2.com");
//            list.add(firmMap2);
//        }
//
//        map.put("data",list);
//
//        String json = JSONUtils.toJSONString(map);
//
//        return json;
//    }
//
//    @Override
//    public String getLawerInfo(String firmId, String layerName) {
//        return null;
//    }
//
//    @Override
//    public String sendProjectInfo(String data) {
//        System.out.println(data);
//        Map<String,String> resultMap = new HashMap<>();
//        resultMap.put("result","success");
//        String result = JSONUtils.toJSONString(resultMap);
//        return result;
//    }
//
//
//    @Override
//    public String agreementEntryFile(String strXML) {
//
//        System.out.println(strXML);
//        return "2";
//    }
//}
