package com.fish.elasticsearch.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * @author fish
 * 分页实体类
 * total 总数
 * code  是否成功
 * data 当前页结果集
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = -275582248840137389L;
	/**
	 * 总行数
	 */
	private Long count;
	private int code;
	private String msg;
	private List<T> data;
	/**
	 * 当前页面号
	 */
	private Integer current;
	/**
	 * 每页行数
	 */
	private Integer rowCount;
}
