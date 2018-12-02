//package com.zmyjn.test.webservice;
//
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
//
//@WebService
//public interface TestService {
//
//    @WebMethod
//    String getParam(@WebParam(name="param") String param);
//
//    /**
//     * 获取律所信息
//     * @param firmName 律所名称
//     * @return
//     */
//    @WebMethod
//    String getFirmInfo(@WebParam(name="firmName") String firmName);
//
//    /**
//     * 获取律师信息
//     * @param firmId 律所id
//     * @param layerName 律师名称
//     * @return
//     */
//    @WebMethod
//    String getLawerInfo(@WebParam(name="firmId") String firmId,@WebParam(name="layerName") String layerName);
//
//    /**
//     * 委托信息发送
//     * @param data
//     * @return
//     */
//    @WebMethod
//    String sendProjectInfo(@WebParam(name="data") String data);
//
//
//    /**
//     * 协议归档
//     * @param strXML
//     * @return
//     */
//    @WebMethod
//    String agreementEntryFile(String strXML);
//}
