package cn.xq.notp.dao;

import cn.xq.notp.entity.PlayRecord;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/18
 */
public interface PlayRecordMapper {
    void saveRecord(PlayRecord playRecord);
}
