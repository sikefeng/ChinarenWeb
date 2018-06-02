package com.jeesite.modules.ctzn.dao;


import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.ctzn.entity.Product;


@MyBatisDao
public interface ProductDao extends CrudDao<Product> {

}
