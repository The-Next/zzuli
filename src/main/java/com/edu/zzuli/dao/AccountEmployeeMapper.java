package com.edu.zzuli.dao;

import com.edu.zzuli.entity.AccountEmployee;
import com.edu.zzuli.entity.AccountEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountEmployeeMapper {
    long countByExample(AccountEmployeeExample example);

    int deleteByExample(AccountEmployeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountEmployee record);

    int insertSelective(AccountEmployee record);

    List<AccountEmployee> selectByExample(AccountEmployeeExample example);

    AccountEmployee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    int updateByExample(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    int updateByPrimaryKeySelective(AccountEmployee record);

    int updateByPrimaryKey(AccountEmployee record);
}