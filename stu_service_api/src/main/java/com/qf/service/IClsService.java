package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface IClsService {

    List<Classes> list();

    Classes queryById(Integer id);

    Classes updateNum(Integer cid);//添加学生时班级人数自动添加

    Classes delnum(Integer cid);//删除学生时班级人数自动减少
}
