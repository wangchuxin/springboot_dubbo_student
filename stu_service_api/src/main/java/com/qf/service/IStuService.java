package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {

    List<Student> list();
    void addStu(Student student);

    void deleteStu(Integer id);

    void updateStu(Student student);

    Student queryById(Integer id);
}
