package cn.iocoder.yudao.module.system.service.memo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.memo.MemoDO;
import cn.iocoder.yudao.module.system.dal.mysql.memo.MemoMapper;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.MEMO_NOT_EXIST;

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
        validateMemoExist(memoSaveReqVO.getId());
        MemoDO memoDO = BeanUtils.toBean(memoSaveReqVO,MemoDO.class);
        memoMapper.updateById(memoDO);
    }

    @Override
    public void DeleteMemo(Long id) {
        validateMemoExist(id);
        memoMapper.deleteById(id);
    }

    @Override
    public void DeleteMemoList(List<Long> ids) {
        memoMapper.deleteByIds(ids);
    }

    @Override
    public PageResult<MemoDO> getMemoPage(MemoPageReqVO memoPageReqVO) {
        return memoMapper.selectPage(memoPageReqVO);
    }

    @Override
    public MemoDO getMemo(Long id) {
        validateMemoExist(id);

        return memoMapper.selectById(id);
    }

    @VisibleForTesting
    public void validateMemoExist(Long id){
        if (id ==null){
            return;

        }
        MemoDO  memo =   memoMapper.selectById(id);
        if (memo ==null){
            throw exception(MEMO_NOT_EXIST);
        }

    }
}
