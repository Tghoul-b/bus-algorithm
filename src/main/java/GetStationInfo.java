import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStationInfo {
    public static List getStation() {
        StationManager stationManager = new StationManager();
        LineManager lineManager = new LineManager();
        String url ="http://m.shmetro.com/core/shmetro/mdstationinfoback_new.ashx";
        Map<String,String> params = new HashMap<>();
        params.put("act","getAllStations");
        String result = HttpUtils.sendGet(url, params);
        if(result != null && result.length() != 0){
            JSONArray jsonArray = JSONArray.parseArray(result);
            for(int i = 0; i < jsonArray.size(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String line = jsonObject.getString("key").substring(0, 2);
                String station = jsonObject.getString("value");
                stationManager.addStation(station, line);
                lineManager.addLine(line, station);
            }
        }
        List list = new ArrayList();
        list.add(stationManager);
        list.add(lineManager);
        return list;
    }

}
