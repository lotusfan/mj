package com.mjapp.dao;

import com.mjapp.model.ActivityTb;
import com.mjapp.model.CollectTb;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectTbMapper {
    public void save(CollectTb collectTb);

    public void update(CollectTb collectTb);

    public List<CollectTb> getBy(CollectTb collectTb);

    public CollectTb getUniqueBy(CollectTb collectTb);

    public Integer count(CollectTb collectTb);

    public List<CollectTb> getConditionBy(CollectTb collectTb);

    public List<ActivityTb> getCollectActivityBy(CollectTb collectTb);
}