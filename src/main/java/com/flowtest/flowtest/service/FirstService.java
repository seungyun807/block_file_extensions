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

    /**
     * 커스텀 확장자
     */
    // 삭제되지 않은 확장자 전체 조회
    public List<extension> selectAllExt(){
        return mapper.selectAllExt();
    }
    // name으로 조회
    public int selectExt(String extension_name){
        return mapper.selectExt(extension_name);
    }
    // 삭제된 확장자 조회
    public HashMap<String, Object> selectDelExt(String extension_name){
        return mapper.selectDelExt(extension_name);
    }
    // num 조회
    public int selectExtNum(String extension_name) {
        return mapper.selectExtNum(extension_name);
    }
    // 변경_true
    public void updateExt_1(int extension_num){
        mapper.updateExt_1(extension_num);
    }
    // 변경_false
    public void updateExt_0(int extension_num){
        mapper.updateExt_0(extension_num);
    }
    // 전체_true
    public void updateAllExt_1(){
        mapper.updateAllExt_1();
    }
    // 추가
    public void insertExt(extension extension) {
        mapper.insertExt(extension);
    }

    /**
     * 고정 확장자
     */

    // 전체 조회
    public List<set_extension> selectAllSetExt(){
        return mapper.selectAllSetExt();
    }
    // num 조회
    public Boolean selectSetExt(int extension_num){
        return mapper.selectSetExt(extension_num);
    }
    // 변경_true
    public void updateSetExt_1(int extension_num){
        mapper.updateSetExt_1(extension_num);
    }
    // 변경_false
    public void updateSetExt_0(int extension_num){
        mapper.updateSetExt_0(extension_num);
    }

}
