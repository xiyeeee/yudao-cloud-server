package cn.iocoder.yudao.module.system.dal.mysql.memo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.memo.MemoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemoMapper extends BaseMapperX<MemoDO> {
    default PageResult<MemoDO> selectPage(MemoPageReqVO memoPageReqVO) {
        return selectPage(memoPageReqVO, new LambdaQueryWrapperX<MemoDO>()
                .likeIfPresent(MemoDO::getTitle, memoPageReqVO.getTitle())
                .eqIfPresent(MemoDO::getStatus, memoPageReqVO.getStatus())
                .orderByDesc(MemoDO::getId));
    }

}
