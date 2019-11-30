package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsMapper;
import com.qf.entity.Classes;
import com.qf.service.IClsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClsServiceImpl implements IClsService {

    @Autowired
    private ClsMapper clsMapper;

    @Override
    public List<Classes> list() {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("cname","一年一班");
        return clsMapper.selectList(null);
    }

    @Override
    public Classes queryById(Integer id) {
        return clsMapper.selectById(id);
    }
}
