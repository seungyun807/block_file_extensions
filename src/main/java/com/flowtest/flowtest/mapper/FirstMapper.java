package com.flowtest.flowtest.mapper;

import com.flowtest.flowtest.vo.extension;
import com.flowtest.flowtest.vo.set_extension;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface FirstMapper {

    //커스텀 확장자
    List<extension> selectAllExt();
    int selectExt(String extension_name);
    int selectExtNum(String extension_name);
    void insertExt(extension extension);
    HashMap<String, Object> selectDelExt(String extension_name);
    void updateExt_1(int  extension_num);
    void updateExt_0(int extension_num);
    void updateAllExt_1();

    //고정 확장자
    void updateSetExt_1(int extension_num);
    void updateSetExt_0(int extension_num);
    Boolean selectSetExt(int extension_num);
    List<set_extension> selectAllSetExt();
}
