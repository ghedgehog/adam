package com.sunway.mapper;

import com.sunway.model.IoAlarmConfig;
import com.sunway.model.IoBaseEntity;
import com.sunway.model.IoVariable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IIoBaseMapper<T extends IoBaseEntity> {

    public void addSysBaseList(@Param("table") String tableName,
                               @Param("list") List<T> baseList);

    public void deleteSysBaseList(@Param("table") String tableName,
                                  @Param("list") List<T> baseList);

    public void addBaseList(@Param("table") String tableName,
                            @Param("ptable") String ptableName,
                            @Param("parent") String parent,
                            @Param("list") List<T> baseList);

    public void deleteBaseList(@Param("table") String tableName,
                               @Param("ptable") String ptableName,
                               @Param("parent") String parent,
                               @Param("list") List<T> baseList);

    public List<T> queryIoBaseList(@Param("table") String tableName,
                                   @Param("ptable") String ptableName,
                                   @Param("parent") String parent,
                                   @Param("mark") int mark);

    public List<T> queryAllIoBase(@Param("table") String tableName);

    public void setMark(@Param("table") String tableName,
                        @Param("ptable") String ptableName,
                        @Param("list") List<T> baseList,
                        @Param("parent") String parent,
                        @Param("mark") int mark);

    public void setSysMark(@Param("table") String tableName,
                           @Param("list") List<T> baseList,
                           @Param("mark") int mark);

    public void addIoDevices(@Param("table") String tableName,
                           @Param("ptable") String ptableName,
                           @Param("tempTable") String tempTable,
                           @Param("parent") String parent,
                           @Param("tempName") String tempName,
                           @Param("list") List<T> baseList);

    public List<IoVariable> queryVarsFromDevice(@Param("varTable") String varTable,
                                                @Param("devTable") String devTable,
                                                @Param("devName") String devName);

    public List<IoAlarmConfig> queryVarAlarmConfig(@Param("alarmTable") String alarmTable,
                                                   @Param("varTable") String varTable,
                                                   @Param("varName") String Var);
}
