package com.kelvin.goodsagent.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kelvin.goodsagent.util.DozerUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 18:29
 * @description:
 */
@Schema(description = "统一响应结构")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    @Schema(title = "状态码")
    private int status;
    @Schema(description = "消息")
    private String message;

    @Schema(title = "返回数据")
    private T data;
    @Schema(title = "错误信息")
    private String error;
    @Schema(title = "时间戳")
    private Date timestamp;
    @Schema(title = "请求URI")
    private String path;

    @Schema(title = "分页大小", description = "如果数据分页，将返回此字段，否则不返回")
    private Integer pageSize;
    @Schema(title = "当前页", description = "如果数据分页，将返回此字段，否则不返回")
    private Integer pageNum;
    @Schema(title = "总记录数", description = "如果数据分页，将返回此字段，否则不返回")
    private Long totalSize;
    @Schema(title = "总页数", description = "如果数据分页，将返回此字段，否则不返回")
    private Integer totalPages;


    private RestResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /*******************************/
    public static <R> RestResult<R> success() {
        return new RestResult<>(200, null, null);
    }

    public static <R> RestResult<R> success(R data) {
        return new RestResult<>(200, null, data);
    }

    public static <R> RestResult<R> success(R data, String message) {
        return new RestResult<>(200, null, data);
    }

    public static <R> RestResult fail() {
        return new RestResult(400, null, null);
    }

    public static <R> RestResult fail(int status, String message) {
        return new RestResult(400, message, null);
    }

    public static <R> RestResult fail(int status, String message, String error) {
        RestResult restResult= new RestResult(400, message, null);
        restResult.setError(error);
        return restResult;
    }


    public static <R> RestResult<List<R>> page(List<R> data, int pageSize, int pageNum, long totalSize, int totalPage) {
        RestResult<List<R>> restResult = success(data);
        restResult.setPageSize(pageSize);
        restResult.setPageNum(pageNum);
        restResult.setTotalPages(totalPage);
        restResult.setTotalSize(totalSize);
        return restResult;
    }

    public static <R, E> RestResult<List<E>> page(Page<R> page, Class<E> target) {
        List<E> r = DozerUtil.mapList(page.getContent(), target);

        return page(r, page.getSize(), page.getNumber(), page.getTotalElements(), page.getTotalPages());
    }

    public static <R> RestResult<List<R>> page(Page<R> page) {
        //把jsp的page进行转换
        return page(page.getContent(), page.getSize(), page.getNumber(), page.getTotalElements(), page.getTotalPages());

    }
}
