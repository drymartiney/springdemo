
package com.liuyanzhao.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * User: chen
 * Date: 2019/11/15
 * Time: 12:58
 */

@Entity//实体类注解
@DynamicUpdate//可以让updateTime动态更新
@Data//自动生成Setter/Getter toString()
public class ProductCategory {
    //类目id
    @Id
    @GeneratedValue
    private Integer categoryId;

    //类目名称
    private String categoryName;

    //类目编号
    private Integer categoryType;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

