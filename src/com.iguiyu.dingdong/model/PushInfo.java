//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.util.Date;

public class PushInfo {
    private int id;
    private int ownerId;
    private int ownerType;
    private int infoType;
    private String title;
    private String from;
    private String to;
    private String fromDesc;
    private String toDesc;
    private String studentName;
    private int studentId;
    private int sendStatus;
    private int priority;
    private int status;
    private long send_at;
    private long create_at = (new Date()).getTime();
    private String url;
    private String templateId;
    private String remark;
    public static final int OWNER_TYPE_MESSAGE = 0;
    public static final int OWNER_TYPE_ATTENDANCE = 1;
    public static final int OWNER_TYPE_HOMEWORK = 2;
    public static final int OWNER_TYPE_POINTEVENT = 3;
    public static final int OWNER_TYPE_SCORE = 4;
    public static final int INFO_TYPE_WX_TEMPLATE = 0;
    public static final int INFO_TYPE_SMS_MESSAGE = 1;

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public PushInfo() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public int getInfoType() {
        return this.infoType;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public int getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerType() {
        return this.ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromDesc() {
        return this.fromDesc;
    }

    public void setFromDesc(String fromDesc) {
        this.fromDesc = fromDesc;
    }

    public String getToDesc() {
        return this.toDesc;
    }

    public void setToDesc(String toDesc) {
        this.toDesc = toDesc;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getSend_at() {
        return this.send_at;
    }

    public void setSend_at(long send_at) {
        this.send_at = send_at;
    }

    public long getCreate_at() {
        return this.create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public static void main(String[] args) {
        PushInfo p = new PushInfo();
        System.out.println(p.getCreate_at());
    }
}
