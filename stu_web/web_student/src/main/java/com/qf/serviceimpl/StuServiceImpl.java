package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Reference
    private IClsService clsService;

    @Override
    public List<Student> list() {
        List<Student> students = stuMapper.selectList(null);
        for (Student student:students) {
            Integer cid = student.getCid();
            //获得班级信息
            Classes classes = clsService.queryById(cid);
            student.setCls(classes);
        }
        return students;
    }

    @Override
    public void addStu(Student student) {
        stuMapper.insert(student);
    }

    @Override
    public void deleteStu(Integer id) {
        stuMapper.deleteById(id);
    }

    @Override
    public void updateStu(Student student) {
        stuMapper.updateById(student);
    }

    @Override
    public Student queryById(Integer id) {
        Student student=stuMapper.selectById(id);
        return student;
    }
}
