package com.flowtest.flowtest.service;

import com.flowtest.flowtest.mapper.FirstMapper;
import com.flowtest.flowtest.vo.extension;
import com.flowtest.flowtest.vo.set_extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstService {

    @Autowired
    public FirstMapper mapper;

    public List<extension> selectExt(){
        return mapper.selectExt();
    }

    public void insertExt(extension extension) {
        mapper.insertExt(extension);
    }
    public void delExt(int extension_num){
        mapper.delExt(extension_num);
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
