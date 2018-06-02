package com.jeesite.modules.ctzn.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;


@Table(name = "ctzn_product", alias = "a", columns = {
        @Column(name = "id", attrName = "id", label = "编号", isPK = true),
        @Column(name = "pro_name", attrName = "proName", label = "产品名称", queryType = QueryType.LIKE),
        @Column(name = "pro_introduce", attrName = "proIntroduce", label = "产品介绍", queryType = QueryType.LIKE),
        @Column(name = "pro_model", attrName = "proModel", label = "产品型号", queryType = QueryType.LIKE),
        @Column(name = "pro_picture", attrName = "proPicture", label = "产品图片", queryType = QueryType.LIKE),
        @Column(name = "pro_share_count", attrName = "proShareCount", label = "产品分享次数", queryType = QueryType.LIKE),
        @Column(includeEntity = DataEntity.class),
}, orderBy = "a.update_date DESC"
)
public class Product extends DataEntity<Product> {

    private String proName;//产品名称
    private String proIntroduce;//产品介绍
    private String proModel;//产品型号
    private String proPicture;//产品图片
    private String proShareCount;//产品分享次数

    public Product() {
        this(null);
    }

    public Product(String id) {
        super(id);
    }


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProModel() {
        return proModel;
    }

    public void setProModel(String proModel) {
        this.proModel = proModel;
    }

    public String getProPicture() {
        return proPicture;
    }

    public void setProPicture(String proPicture) {
        this.proPicture = proPicture;
    }

    public String getProShareCount() {
        return proShareCount;
    }

    public void setProShareCount(String proShareCount) {
        this.proShareCount = proShareCount;
    }

    public String getProIntroduce() {
        return proIntroduce;
    }

    public void setProIntroduce(String proIntroduce) {
        this.proIntroduce = proIntroduce;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proName='" + proName + '\'' +
                ", proModel='" + proModel + '\'' +
                ", proPicture='" + proPicture + '\'' +
                ", proShareCount='" + proShareCount + '\'' +
                ", id='" + id + '\'' +
                ", isNewRecord=" + isNewRecord +
                '}';
    }
}
