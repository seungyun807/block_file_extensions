package com.flowtest.flowtest.service;

import com.flowtest.flowtest.mapper.FirstMapper;
import com.flowtest.flowtest.vo.extension;
import com.flowtest.flowtest.vo.set_extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FirstService {

    @Autowired
    public FirstMapper mapper;

    //커스텀 확장자 조회
    public List<extension> selectAllExt(){
        return mapper.selectAllExt();
    }
    public int selectExt(String extension_name){
        return mapper.selectExt(extension_name);
    }
    public HashMap<String, Object> selectDelExt(String extension_name){
        return mapper.selectDelExt(extension_name);
    }
    public int selectExtNum(String extension_name) {
        return mapper.selectExtNum(extension_name);
    }
    //커스텀 확장자 변경
    public void updateExt_1(int extension_num){
        mapper.updateExt_1(extension_num);
    }
    public void updateExt_0(int extension_num){
        mapper.updateExt_0(extension_num);
    }
    public void updateAllExt_1(){
        mapper.updateAllExt_1();
    }
    //커스텀 확장자 추가
    public void insertExt(extension extension) {
        mapper.insertExt(extension);
    }

    //고정 확장자 전체 조회
    public List<set_extension> selectAllSetExt(){
        return mapper.selectAllSetExt();
    }
    //고정 확장자 num 조회
    public Boolean selectSetExt(int extension_num){
        return mapper.selectSetExt(extension_num);
    }
    //고정 확장자 변경_true
    public void updateSetExt_1(int extension_num){
        mapper.updateSetExt_1(extension_num);
    }
    //고정 확장자 변경_false
    public void updateSetExt_0(int extension_num){
        mapper.updateSetExt_0(extension_num);
    }

}
