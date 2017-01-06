package com.mjapp.dao.transactionmanager;

import com.mjapp.dao.OrderTbMapper;
import com.mjapp.model.OrderTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTbTransactionManager {



    @Autowired
    private OrderTbMapper orderTbMapper;


    public void saveOrderTb(OrderTb orderTb) {

        orderTbMapper.save(orderTb);
    }

    public void saveOrderTbs(List<OrderTb> orderTbs) {

        if (orderTbs == null) {
            return;
        }
        for (int i = 0; i < orderTbs.size(); i++) {
            orderTbMapper.save(orderTbs.get(i));
        }
    }

    public void updateOrderTb(OrderTb orderTb) {
        orderTbMapper.update(orderTb);

    }

    public void updateOrderTbs(List<OrderTb> orderTbs) {
        if (orderTbs == null) {
            return;
        }
        for (int i = 0; i < orderTbs.size(); i++) {
            orderTbMapper.update(orderTbs.get(i));
        }
    }

    public OrderTb getUniqueBy(OrderTb orderTb) {

        return orderTbMapper.getUniqueBy(orderTb);
    }
    public List<OrderTb> getConditionBy(OrderTb orderTb) {

        return orderTbMapper.getConditionBy(orderTb);
    }

    public List<OrderTb> getBy(OrderTb orderTb) {

        return orderTbMapper.getBy(orderTb);
    }

    public Integer count(OrderTb orderTb) {

        return orderTbMapper.count(orderTb);
    }

}
