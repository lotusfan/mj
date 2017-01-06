package com.mjapp.dao;

import com.mjapp.model.PraiseTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PraiseTbMapper {
    public void save(PraiseTb praiseTb);

    public void update(PraiseTb praiseTb);

    public void updateBy(PraiseTb praiseTb);

    public List<PraiseTb> getBy(PraiseTb praiseTb);

    public PraiseTb getUniqueBy(PraiseTb praiseTb);

    public Integer count(PraiseTb praiseTb);

    public List<PraiseTb> getConditionBy(PraiseTb praiseTb);

    List<UserView> getPraiseUserViewConditionBy(PraiseTb praiseTb);
}