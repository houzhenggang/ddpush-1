//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Base;

public class Image extends Base {
    public static final String FILE_PATH = "/Users/XmacZone/desktop/dev/dingdong/img/";
    private String name;
    private int originSize;
    private int owner_id;
    private int owner_type;
    private String key;
    private String hash;
    private String type;
    private int size;
    private String url;
    private String origin_url;

    public Image() {
    }

    public int getOwner_type() {
        return this.owner_type;
    }

    public void setOwner_type(int owner_type) {
        this.owner_type = owner_type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginSize() {
        return this.originSize;
    }

    public void setOriginSize(int originSize) {
        this.originSize = originSize;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrigin_url() {
        return this.origin_url;
    }

    public void setOrigin_url(String origin_url) {
        this.origin_url = origin_url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getOwner_id() {
        return this.owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
