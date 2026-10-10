package cn.iocoder.yudao.module.system.service.memo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.memo.MemoDO;
import cn.iocoder.yudao.module.system.dal.mysql.memo.MemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemoServiceImpl implements  MemoService{

    @Resource
    private MemoMapper memoMapper;

    @Override
    public Long CreatMemo(MemoSaveReqVO memoSaveReqVO) {
        MemoDO memoDO = BeanUtils.toBean(memoSaveReqVO,MemoDO.class);
        memoMapper.insert(memoDO);
        return memoDO.getId();
    }

    @Override
    public void UpdateMemo(MemoSaveReqVO memoSaveReqVO) {

    }

    @Override
    public void DeleteMemo(Long id) {

    }

    @Override
    public void DeleteMemoList(List<Long> ids) {

    }

    @Override
    public PageResult<MemoDO> getMemoPage(MemoPageReqVO memoPageReqVO) {
        return null;
    }

    @Override
    public MemoDO getMemo(Long id) {
        return null;
    }
}
