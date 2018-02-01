package cn.com.yikangbao.entity.order;

import java.util.Date;

/**
 * Created by jeysine on 2018/2/1.
 */
public class OrderDTO extends Order {
    private Date createdDateStart;
    private Date createdDateEnd;

    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }


}
