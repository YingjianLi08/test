package com.zmyjn.file.util;

import com.zmyjn.core.log.LogUtil;
import com.zmyjn.file.entity.SysFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUploadUtil {

    private static final LogUtil logger = LogUtil.getLogger(FileUploadUtil.class);


//    @Value("${upload_root_dir}")
    //private static String uploadRootDir = "C:/Users/Administrator/Desktop/layuiModel/layuiAdmin/";

    private static String allowImgType = "bmp,jpg,jpeg,png,gif";

    private static String allowFileType = "doc,docx,xls,xlsx,ppt,pptx,txt";

    private static String allowPackageType = "jar,war,zip,rar";

    /**
     * 保存附件
     *
     */
    public static boolean saveFile(HttpServletRequest request, HttpServletResponse response, MultipartFile file1,  Map result,String uploadRootDir) throws IOException {

        SysFile resultVo = new SysFile();
        List list = new ArrayList();
        try {

            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator iterator = req.getFileNames();
            String savePath = "";
            String transformPath = "";
            String newFilename = "";
            String fileStorePath = "";
            String[] imgArr = allowImgType.split(","); // 图片后缀
            String[] fileArr = allowFileType.split(","); // 附件后缀
            String[] packageArr = allowPackageType.split(","); // 压缩包后缀
            List imgTypeList = Arrays.asList(imgArr);
            List fileTypeList = Arrays.asList(fileArr);
            List packageTypeList = Arrays.asList(packageArr);

            while (iterator.hasNext()) {
            MultipartFile file = req.getFile((String)iterator.next());
                // 获取文件名称
                String fileNames = file.getOriginalFilename();

                // 获取文件类型
                int split = fileNames.lastIndexOf(".");
                String fileType = fileNames.substring(split + 1, fileNames.length());

                if (imgTypeList.contains(fileType.toLowerCase())) {
                    fileStorePath = getFileStorePath(uploadRootDir, "/file_upload/image");
                } else {
                    fileStorePath = getFileStorePath(uploadRootDir, "/file_upload/file");
                }

                if (imgTypeList.contains(fileType.toLowerCase())) {
                    // 图片类型的文件
                    newFilename = String.valueOf(UUID.randomUUID().toString().replace("-", "")) + String.valueOf(System.currentTimeMillis()) + "." + fileType;
                    savePath = fileStorePath + newFilename;
                    createDir(savePath);
                    File saveFile = new File(savePath);
                    file.transferTo(saveFile);

                    String isScaleImge = request.getParameter("isScaleImge");
                    if ((null != isScaleImge) && ("true".equalsIgnoreCase(isScaleImge.trim()))) {
                        ScaleImage(saveFile, request);
                    }
                    resultVo.setFieldName(newFilename);
                    resultVo.setResult(true);
                    resultVo.setStoragePath(savePath.replace(uploadRootDir, ""));
                    resultVo.setPdfStoragePath("");
                    list.add(resultVo);
                } else if (fileTypeList.contains(fileType.toLowerCase())) {
                    newFilename = String.valueOf(UUID.randomUUID().toString().replace("-", "")) + String.valueOf(System.currentTimeMillis()) + "." + fileType;
                    savePath = fileStorePath + newFilename;
                    int fileSplit = savePath.lastIndexOf(".");
                    String transStr = savePath.substring(0, fileSplit);
                    transformPath = transStr + ".pdf";
                    createDir(savePath);
                    File saveFile = new File(savePath);
                    file.transferTo(saveFile);
                    if (fileType.contains("xls")) {
                        transformPath = transStr + ".html";
                    }
                    resultVo.setPdfStoragePath(savePath.replace(uploadRootDir, ""));
                    if (!fileType.equals("txt")) {
                        fileTransform(savePath, transformPath, fileType);
                        resultVo.setPdfStoragePath(transformPath.replace(uploadRootDir, ""));
                    }

                    resultVo.setFieldName(fileNames);
                    resultVo.setResult(true);
                    resultVo.setStoragePath(savePath.replace(uploadRootDir, ""));
                    list.add(resultVo);
                } else if (packageTypeList.contains(fileType.toLowerCase())) {
                    newFilename = String.valueOf(UUID.randomUUID().toString().replace("-", "")) + String.valueOf(System.currentTimeMillis()) + "." + fileType;
                    savePath = fileStorePath + newFilename;
                    createDir(savePath);
                    File saveFile = new File(savePath);
                    file.transferTo(saveFile);
                    resultVo.setFieldName(fileNames);
                    resultVo.setResult(true);
                    resultVo.setStoragePath(savePath.replace(uploadRootDir, ""));
                    resultVo.setPdfStoragePath("");
                    list.add(resultVo);
                } else {
                    logger.error("", "不支持的文件类型");
                    response.getWriter().print("please  add the Appropriate types");
                    return false;
                }

                long size = file.getSize();
                if (size == 0L) {
                    resultVo.setErrorMsg("文件内容为空.");
                    resultVo.setFieldName(fileNames);
                    resultVo.setResult(false);
                    list.add(resultVo);
                    continue;
                }
            }

        } catch (Exception e) {
            logger.error("", e);
            response.getWriter().print("please  add the form attribute of 'multipart/form-data'.");
            return false;
        }

//            String baseUrl = request.getScheme() + "://" + request.getServerName()
//                + ":" + request.getServerPort() + request.getContextPath() + "/";

        result.put("data", list);
        return true;
    }

    public static String getFileStorePath(String uploadRootDir, String type) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String matchStr = dateFormat.format(currentDate);
        String storePath = uploadRootDir + type + File.separator + matchStr;
        File file = new File(storePath);

        if (!file.exists()) {
            file.mkdirs();
        }

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String dayMatch = dayFormat.format(currentDate);
        storePath = storePath + File.separator + dayMatch;

        File dayFile = new File(storePath);

        if (!dayFile.exists()) {
            dayFile.mkdirs();
        }

        return storePath + File.separator;
    }

    public static void createDir(String filepath) {
        File file = new File(filepath);
        if (file.getParentFile().exists()) {
            return;
        }

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        createDir(file.getParent());
    }

    public static void ScaleImage(File file, HttpServletRequest request) {
        if (logger.isDebugEnabled()) {
            logger.debug("开始压缩图片...");
        }

        int width = request.getParameter("width") == null ? 160 :
                Integer.parseInt(request
                        .getParameter("width"));

        int height = request.getParameter("height") == null ? 160 :
                Integer.parseInt(request
                        .getParameter("height"));

//        ThreadManager.getInstance().executeThread(new FileUploadUtil .1 (file, width, height));
    }


    public static void fileTransform(String savePath, String transformPath, String fileType) {
        if (logger.isDebugEnabled()) {
            logger.debug("开始转文件...");
        }

        //ThreadManager.getInstance().executeThread(new FileUploadUtil.2(fileType, savePath, transformPath));
    }

    /**
     * 读取文件内容
     *
     * @param is
     * @return
     */
//    public static String readFile(InputStream is) {
//        BufferedReader br = null;
//        StringBuffer sb = new StringBuffer();
//        try {
//            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            String readLine = null;
//            while ((readLine = br.readLine()) != null) {
//                sb.append(readLine);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb.toString();
//    }


    /**
     * 判断指定的文件是否存在。
     *
     * @param fileName
     * @return
     */
    public static boolean isFileExist(String fileName) {
        return new File(fileName).isFile();
    }

    /**
     * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
     * 注意：可能会在返回false的时候创建部分父目录。
     *
     * @param file
     * @return
     */
    public static boolean makeDirectory(File file) {
        File parent = file.getParentFile();
        if (parent != null) {
            return parent.mkdirs();
        }
        return false;
    }

    /**
     * 返回文件的URL地址。
     *
     * @param file
     * @return
     * @throws MalformedURLException
     */
    public static URL getURL(File file) throws MalformedURLException {
        String fileURL = "file:/" + file.getAbsolutePath();
        URL url = new URL(fileURL);
        return url;
    }

    /**
     * 从文件路径得到文件名。
     *
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }

    /**
     * 从文件名得到文件绝对路径。
     *
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    /**
     * 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。
     *
     * @param filePath
     * @return
     */
    public static String toUNIXpath(String filePath) {
        return filePath.replace("", "/");
    }

    /**
     * 从文件名得到UNIX风格的文件绝对路径。
     *
     * @param fileName
     * @return
     */
    public static String getUNIXfilePath(String fileName) {
        File file = new File(fileName);
        return toUNIXpath(file.getAbsolutePath());
    }

    /**
     * 得到文件后缀名
     *
     * @param fileName
     * @return
     */
    public static String getFileExt(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point + 1, length);
        }
    }

    /**
     * 得到文件的名字部分。 实际上就是路径中的最后一个路径分隔符后的部分。
     *
     * @param fileName
     * @return
     */
    public static String getNamePart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return fileName;
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                if (length == 1) {
                    return fileName;
                } else {
                    return fileName.substring(0, point);
                }
            } else {
                return fileName.substring(secondPoint + 1, point);
            }
        } else {
            return fileName.substring(point + 1);
        }
    }

    /**
     * 得到文件名中的父路径部分。 对两种路径分隔符都有效。 不存在时返回""。
     * 如果文件名是以路径分隔符结尾的则不考虑该分隔符，例如"/path/"返回""。
     *
     * @param fileName
     * @return
     */
    public static String getPathPart(String fileName) {
        int point = getPathLastIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return "";
        } else if (point == length - 1) {
            int secondPoint = getPathLastIndex(fileName, point - 1);
            if (secondPoint == -1) {
                return "";
            } else {
                return fileName.substring(0, secondPoint);
            }
        } else {
            return fileName.substring(0, point);
        }
    }

    /**
     * 得到路径分隔符在文件路径中最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @return
     */
    public static int getPathLastIndex(String fileName) {
        int point = fileName.lastIndexOf("/");
        if (point == -1) {
            point = fileName.lastIndexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置前最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @param fromIndex
     * @return
     */
    public static int getPathLastIndex(String fileName, int fromIndex) {
        int point = fileName.lastIndexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.lastIndexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @return
     */
    public static int getPathIndex(String fileName) {
        int point = fileName.indexOf("/");
        if (point == -1) {
            point = fileName.indexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置后首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     * @param fromIndex
     * @return
     */
    public static int getPathIndex(String fileName, int fromIndex) {
        int point = fileName.indexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.indexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 将文件名中的类型部分去掉。
     *
     * @param filename
     * @return
     */
    public static String removeFileExt(String filename) {
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(0, index);
        } else {
            return filename;
        }
    }

    /**
     * 得到相对路径。 文件名不是目录名的子节点时返回文件名。
     *
     * @param pathName
     * @param fileName
     * @return
     */
    public static String getSubpath(String pathName, String fileName) {
        int index = fileName.indexOf(pathName);
        if (index != -1) {
            return fileName.substring(index + pathName.length() + 1);
        } else {
            return fileName;
        }
    }

    /**
     * 删除一个文件。
     *
     * @param filename
     * @throws IOException
     */
    public static void deleteFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.isDirectory()) {
            throw new IOException("IOException -> BadInputException: not a file.");
        }
        if (!file.exists()) {
            throw new IOException("IOException -> BadInputException: file is not exist.");
        }
        if (!file.delete()) {
            throw new IOException("Cannot delete file. filename = " + filename);
        }
    }

    /**
     * 删除文件夹及其下面的子文件夹
     *
     * @param dir
     * @throws IOException
     */
    public static void deleteDir(File dir) throws IOException {
        if (dir.isFile())
            throw new IOException("IOException -> BadInputException: not a directory.");
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    file.delete();
                } else {
                    deleteDir(file);
                }
            }
        }
        dir.delete();
    }

    /**
     * 复制文件
     *
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

    /**
     * @param src
     * @param dst
     * @param append
     * @throws Exception
     * @复制文件，支持把源文件内容追加到目标文件末尾
     */
    public static void copy(File src, File dst, boolean append) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst, append), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

}
