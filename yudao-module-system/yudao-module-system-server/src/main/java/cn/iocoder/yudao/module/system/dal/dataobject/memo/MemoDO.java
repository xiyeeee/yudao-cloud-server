package cn.iocoder.yudao.module.system.dal.dataobject.memo;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("system_memo")
@KeySequence("system_memo_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写
@Data
@EqualsAndHashCode(callSuper = true)
public class MemoDO extends BaseDO {
    private Long id;
    private String title;
    private String content;
    private Integer status;
    private String remark;
}
