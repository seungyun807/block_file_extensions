package com.flowtest.flowtest.mapper;

import com.flowtest.flowtest.vo.extension;
import com.flowtest.flowtest.vo.set_extension;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FirstMapper {

    List<extension> selectExt();
    void insertExt(extension extension);
    void delExt(int extension_num);
    //고정 확장자
    void updateSetExt_1(int extension_num);
    void updateSetExt_0(int extension_num);
    Boolean selectSetExt(int extension_num);
    List<set_extension> selectAllSetExt();
}
