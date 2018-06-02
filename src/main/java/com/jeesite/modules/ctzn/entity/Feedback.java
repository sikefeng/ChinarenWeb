package com.jeesite.modules.ctzn.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

@Table(name = "ctzn_feedback", alias = "a", columns = {
        @Column(name = "id", attrName = "id", label = "编号", isPK = true),
        @Column(name = "pro_id", attrName = "proId", label = "产品ID", queryType = QueryType.LIKE),
        @Column(name = "pro_name", attrName = "proName", label = "产品名称", queryType = QueryType.LIKE),
        @Column(name = "conent", attrName = "conent", label = "反馈内容", queryType = QueryType.LIKE),
        @Column(name = "picture", attrName = "picture", label = "反馈图片", queryType = QueryType.LIKE),
        @Column(includeEntity = DataEntity.class),
}, orderBy = "a.update_date DESC"
)
public class Feedback extends DataEntity<Feedback> {

    private String proId; //产品ID
    private String proName; //产品名称
    private String conent; //反馈内容
    private String picture; //反馈图片

    public Feedback() {
        this(null);
    }

    public Feedback(String id) {
        super(id);
    }


    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
