package com.zmyjn.file.entity;

public class SysFile {

    private String fieldName;
    private String errorMsg;
    private boolean result = true;
    private String storagePath;
    private int imageWidth;
    private int imageHight;
    private String pdfStoragePath;
    private String swfStoragePath;
    private String scaleImageStoragePath;
    private String cropImageImageStoragePath;
    private String officefile;


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHight() {
        return imageHight;
    }

    public void setImageHight(int imageHight) {
        this.imageHight = imageHight;
    }

    public String getPdfStoragePath() {
        return pdfStoragePath;
    }

    public void setPdfStoragePath(String pdfStoragePath) {
        this.pdfStoragePath = pdfStoragePath;
    }

    public String getSwfStoragePath() {
        return swfStoragePath;
    }

    public void setSwfStoragePath(String swfStoragePath) {
        this.swfStoragePath = swfStoragePath;
    }

    public String getScaleImageStoragePath() {
        return scaleImageStoragePath;
    }

    public void setScaleImageStoragePath(String scaleImageStoragePath) {
        this.scaleImageStoragePath = scaleImageStoragePath;
    }

    public String getCropImageImageStoragePath() {
        return cropImageImageStoragePath;
    }

    public void setCropImageImageStoragePath(String cropImageImageStoragePath) {
        this.cropImageImageStoragePath = cropImageImageStoragePath;
    }

    public String getOfficefile() {
        return officefile;
    }

    public void setOfficefile(String officefile) {
        this.officefile = officefile;
    }

}
