package com.handsome.images.dao.impl;

import com.handsome.common.dao.BaseDaoSupport;
import com.handsome.common.utils.MapUtil;
import com.handsome.images.bean.Image;
import com.handsome.images.dao.ImageDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl extends BaseDaoSupport implements ImageDao{

    private static final String NAMESPACE = "com.handsome.images.bean.Image";

    @Override
    public List<String> getImages(Long userId) {
        return getSqlSession().selectList(NAMESPACE + ".getImages", MapUtil.buildMap("userId", userId));
    }

    @Override
    public List<String> getImagesPage(Long userId, int offset, Integer pageSize) {
        return getSqlSession().selectList(NAMESPACE + ".getImagesPage", MapUtil.buildMap("userId", userId, "offset", offset, "pageSize", pageSize));
    }

    @Override
    public boolean insert(Image image) {
        return getSqlSession().insert(NAMESPACE + ".insert", MapUtil.buildMap("image", image)) > 0;
    }
}
