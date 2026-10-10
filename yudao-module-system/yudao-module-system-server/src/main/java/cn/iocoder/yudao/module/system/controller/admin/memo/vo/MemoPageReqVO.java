package cn.iocoder.yudao.module.system.controller.admin.memo.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台-分页参数vo")
@Data
@EqualsAndHashCode(callSuper = true)
public class MemoPageReqVO extends PageParam {

    @Schema(description = "标题")
    private  String title;

    @Schema(description = "展示状态，参见 CommonStatusEnum 枚举类", example = "1")
    private Integer status;

}
