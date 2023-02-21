package org.github.zhengchalei.common;

import lombok.Data;

import java.util.List;

/**
 * page
 *
 * @author 郑查磊
 * @date 2021/04/10
 */
@Data
public class RPage<T> {

    private Long total;

    private List<T> list;

}