package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface IClsService {

    List<Classes> list();

    Classes queryById(Integer id);
}
