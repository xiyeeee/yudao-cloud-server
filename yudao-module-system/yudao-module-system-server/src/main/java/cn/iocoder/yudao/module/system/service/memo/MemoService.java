package cn.iocoder.yudao.module.system.service.memo;


import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.memo.MemoDO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemoService {

 Long CreatMemo(MemoSaveReqVO memoSaveReqVO);

 void UpdateMemo(MemoSaveReqVO memoSaveReqVO);

 void DeleteMemo(Long id);

 void DeleteMemoList(List<Long> ids);

 PageResult<MemoDO> getMemoPage(MemoPageReqVO memoPageReqVO);

 MemoDO getMemo(Long id);

}
