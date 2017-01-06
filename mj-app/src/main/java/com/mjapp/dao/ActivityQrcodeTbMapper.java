package com.mjapp.dao;
import com.mjapp.model.ActivityQrcodeTb;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityQrcodeTbMapper{
	public void save(ActivityQrcodeTb activityQrcodeTb);
	public void update(ActivityQrcodeTb activityQrcodeTb);
	public List<ActivityQrcodeTb> getBy(ActivityQrcodeTb activityQrcodeTb);
	public ActivityQrcodeTb getUniqueBy(ActivityQrcodeTb activityQrcodeTb);
	public Integer count(ActivityQrcodeTb activityQrcodeTb);
	public List<ActivityQrcodeTb> getConditionBy(ActivityQrcodeTb activityQrcodeTb);
}