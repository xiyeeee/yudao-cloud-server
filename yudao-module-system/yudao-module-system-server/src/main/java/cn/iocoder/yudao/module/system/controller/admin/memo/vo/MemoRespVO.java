package cn.iocoder.yudao.module.system.controller.admin.memo.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 备忘录 Response VO")
@Data
public class MemoRespVO {
    @Schema(description = "备忘录id", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    private Long id;

    @Schema(description = "备忘录名称", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    private String title;

    @Schema(description = "备忘录内容", requiredMode = Schema.RequiredMode.REQUIRED,example = "1024")
    private String content;

    @Schema(description = "备忘录状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer status;

    @Schema(description = "备忘录备注", example = "1024")
    private String remark;


    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式")
    private LocalDateTime createTime;

}
