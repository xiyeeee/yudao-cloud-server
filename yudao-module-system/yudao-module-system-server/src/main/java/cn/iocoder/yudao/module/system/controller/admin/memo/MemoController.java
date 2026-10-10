package cn.iocoder.yudao.module.system.controller.admin.memo;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.controller.admin.memo.vo.MemoSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.notice.vo.NoticeSaveReqVO;
import cn.iocoder.yudao.module.system.service.memo.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public CommonResult<Long> createNotice(@Valid @RequestBody MemoSaveReqVO memoSaveReqVO) {
        Long memoId = memoService.CreatMemo(memoSaveReqVO);
        return success(memoId);
    }

}
