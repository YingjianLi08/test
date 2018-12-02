package com.zmyjn.file.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.zmyjn.core.base.controller.ResultData;
import com.zmyjn.core.log.LogUtil;
import com.zmyjn.file.entity.SysFile;
import com.zmyjn.file.util.FileUploadUtil;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "系统上传管理服务",tags = "系统上传管理服务接口")
@RequestMapping("file/fileManager")
public class FileManagerController {

    private final LogUtil logger = LogUtil.getLogger(getClass());

    @Value("${upload_root_dir}")
    private String uploadRootDir;

    /**
     * 上传文件。
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam(value = "file", required = true)MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
//        byte[] bytes = file.getBytes();
//        File fileToSave = new File(file.getOriginalFilename());
//        FileCopyUtils.copy(bytes, fileToSave);
//        return fileToSave.getAbsolutePath();

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf-8");

        Map result = new HashMap();
         boolean flag = FileUploadUtil.saveFile(request,response,file,result,uploadRootDir);

         if(flag){
             response.setContentType("application/json;charset=UTF-8");
//             String jsonMap = JSONObject.toJSONString(result);
             Map<String,Object> map = new HashMap<>();
             List<SysFile> sysFileList = new ArrayList<>();
             sysFileList = (List<SysFile>)result.get("data");
             SysFile sysFile = new SysFile();
             if(sysFileList!=null && sysFileList.size()> 0){
                 sysFile = sysFileList.get(0);

                 map.put("fieldName",sysFile.getFieldName());
                 map.put("url",sysFile.getStoragePath());
                 map.put("src",sysFile.getStoragePath());
                 map.put("imageWidth",sysFile.getImageWidth());
                 map.put("imageHight",sysFile.getImageHight());
             }
             String jsonMap = JSONUtils.toJSONString(map);
             response.getWriter().print(jsonMap);
             response.getWriter().flush();
         }
    }



    /**
     * 富文本上传文件。
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile2(@RequestParam(value = "file", required = true)MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf-8");

        Map result = new HashMap();
        boolean flag = FileUploadUtil.saveFile(request,response,file,result,uploadRootDir);

        ResultData  resultData = new ResultData();

        if(flag){
            response.setContentType("application/json;charset=UTF-8");
            Map<String,Object> map = new HashMap<>();
            List<SysFile> sysFileList = new ArrayList<>();
            sysFileList = (List<SysFile>)result.get("data");
            SysFile sysFile = new SysFile();
            if(sysFileList!=null && sysFileList.size()> 0){
                sysFile = sysFileList.get(0);
                map.put("src",sysFile.getStoragePath());
                resultData.setData(map);

                Map data = new HashMap();
                data.put("src",sysFile.getStoragePath());

                map.put("code",0);
                map.put("msg","上传成功");
                map.put("data",data);

            }
            String jsonMap = JSONUtils.toJSONString(map);
            response.getWriter().print(jsonMap);
            response.getWriter().flush();
        }
    }



//    @ResponseBody
//    @RequestMapping({"/upload"})
//    protected void fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { if (this.logger.isDebugEnabled()) {
//        this.logger.debug("begining...");
//    }
//        request.setCharacterEncoding("utf-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setCharacterEncoding("utf-8");
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if (!isMultipart) {
//            response.getWriter().print("please  add the form attribute of 'multipart/form-data'.");
//            return;
//        }
//
//        Map result = new HashMap();
//
//        boolean flag = FileUploadUtil.saveFile(request, response, result, this.uploadRootDir, this.allowImgType, this.allowFileType, this.allowPackageType);
//        if (flag) {
//            response.setContentType("application/json;charset=UTF-8");
//            String jsonMap = JSONObject.toJSONString(result);
//            response.getWriter().print(jsonMap);
//            response.getWriter().flush();
//        }
//    }


}
