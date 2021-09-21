import java.util.List;

public class Station {
    private String stationName;//站点名称
    private List<Integer> lineList;//经过此站点的所有公交线的集合

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Integer> getLineList() {
        return lineList;
    }

    public void setLineList(List<Integer> lineList) {
        this.lineList = lineList;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationName='" + stationName + '\'' +
                ", lineList=" + lineList +
                '}';
    }
}
