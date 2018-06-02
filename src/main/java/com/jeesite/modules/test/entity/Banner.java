package com.jeesite.modules.test.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

@Table(name = "test_banner", alias = "a", columns = {
        @Column(name = "id", attrName = "id", label = "编号", isPK = true),
        @Column(name = "username", attrName = "username", label = "单行文本", queryType = QueryType.LIKE),
        @Column(name = "password", attrName = "password", label = "单行文本", queryType = QueryType.LIKE),
        @Column(includeEntity = DataEntity.class),
}, orderBy = "a.update_date DESC"

)
public class Banner extends DataEntity<Banner> {



       private String username;
       private String password;

    public Banner() {
        this(null);
    }

    public Banner(String id){
        super(id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
