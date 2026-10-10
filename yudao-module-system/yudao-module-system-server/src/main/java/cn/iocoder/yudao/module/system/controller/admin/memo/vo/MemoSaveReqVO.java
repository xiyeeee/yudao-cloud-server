package cn.iocoder.yudao.module.system.controller.admin.memo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "备忘录创建和修改", example = "1024")
@Data
public class MemoSaveReqVO {
    @Schema(description = "备忘录id", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    private Long id;

    @Schema(description = "备忘录名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotBlank(message = "备忘录名称不能为空")
    @Size(max = 10,message = "备忘录名称长度不能超过10")
    private String title;

    @Schema(description = "备忘录内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String content;

    @Schema(description = "备忘录状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer status;

    @Schema(description = "备忘录备注", example = "1024")
    private String remark;


}
