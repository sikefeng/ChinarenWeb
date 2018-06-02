package com.jeesite.modules.test.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.dao.BannerDao;
import com.jeesite.modules.test.entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class BannerService extends CrudService<BannerDao, Banner> {



}
