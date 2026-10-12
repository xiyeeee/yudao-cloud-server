package cn.iocoder.yudao.module.system.controller.admin.memo;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoRespVO;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.memo.MemoDO;
import cn.iocoder.yudao.module.system.service.memo.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.lang.reflect.Array;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 通知公告")
@RestController
@RequestMapping("/system/memo")
@Validated
public class MemoController {
    @Resource
     private  MemoService memoService;

    @PostMapping("/create")
    @Operation(summary = "创建备忘录")
    @PreAuthorize("@ss.hasPermission('system:memo:create')")
    public CommonResult<Long> createMemo(@Valid @RequestBody MemoSaveReqVO memoSaveReqVO) {
        Long memoId = memoService.CreatMemo(memoSaveReqVO);
        return success(memoId);
    };

    @PutMapping("/update")
    @Operation(summary = "修改备忘录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:memo:update')")
    public CommonResult<Boolean> createNotice(@Valid @RequestBody MemoSaveReqVO memoSaveReqVO) {
         memoService.UpdateMemo(memoSaveReqVO);
            return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除备忘录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:memo:delete')")
    public CommonResult<Boolean> deleteNotice(@RequestParam Long id) {
        memoService.DeleteMemo(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "删除备忘录")
    @PreAuthorize("@ss.hasPermission('system:memo:delete')")
    public CommonResult<Boolean> deleteNoticeList(@RequestParam List<Long> ids) {
        memoService.DeleteMemoList(ids);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "备忘录分页")
    public CommonResult<PageResult<MemoRespVO>> getNoticeList( MemoPageReqVO memoPageReqVO) {
        PageResult<MemoDO> memoList =   memoService.getMemoPage(memoPageReqVO);

        return success(BeanUtils.toBean(memoList,MemoRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "备忘录单条详情")
    public CommonResult<MemoRespVO> getNotice(@RequestParam Long id) {
        MemoDO memoDO = memoService.getMemo(id);
        return success(BeanUtils.toBean(memoDO,MemoRespVO.class));
    }





}
