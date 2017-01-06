package com.mjapp.dao.transactionmanager;

import com.mjapp.dao.OrderSubTbMapper;
import com.mjapp.model.OrderSubTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSubTbTransactionManager {



    @Autowired
    private OrderSubTbMapper orderSubTbMapper;


    public void saveOrderSubTb(OrderSubTb orderSubTb) {

        orderSubTbMapper.save(orderSubTb);
    }

    public void saveOrderSubTbs(List<OrderSubTb> orderSubTbs) {

        if (orderSubTbs == null) {
            return;
        }
        for (int i = 0; i < orderSubTbs.size(); i++) {
            orderSubTbMapper.save(orderSubTbs.get(i));
        }
    }

    public void updateOrderSubTb(OrderSubTb orderSubTb) {
        orderSubTbMapper.update(orderSubTb);

    }

    public void updateOrderSubTbs(List<OrderSubTb> orderSubTbs) {
        if (orderSubTbs == null) {
            return;
        }
        for (int i = 0; i < orderSubTbs.size(); i++) {
            orderSubTbMapper.update(orderSubTbs.get(i));
        }
    }

    public OrderSubTb getUniqueBy(OrderSubTb orderSubTb) {

        return orderSubTbMapper.getUniqueBy(orderSubTb);
    }
    public List<OrderSubTb> getConditionBy(OrderSubTb orderSubTb) {

        return orderSubTbMapper.getConditionBy(orderSubTb);
    }

    public List<OrderSubTb> getBy(OrderSubTb orderSubTb) {

        return orderSubTbMapper.getBy(orderSubTb);
    }

    public Integer count(OrderSubTb orderSubTb) {

        return orderSubTbMapper.count(orderSubTb);
    }

}
