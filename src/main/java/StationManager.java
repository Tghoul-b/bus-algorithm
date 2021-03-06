import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StationManager {
    private Set<String> station_names;//站点名称
    private List<Station> stations;//所有站点
    public void addStation(String station_name, String line){
        if(station_names == null)
            station_names = new HashSet<>();
        if(stations == null)
            stations = new ArrayList<>();
        if(station_names.contains(station_name)){
            for(Station station : stations){
                if(station.getStationName().equals(station_name))
                    station.getLineList().add(Integer.parseInt(line));
            }
        }
        else{
            Station station = new Station();
            station.setStationName(station_name);
            station.setLineList(new ArrayList<Integer>());
            station.getLineList().add(Integer.parseInt(line));
            station_names.add(station_name);
            stations.add(station);
        }
    }
    public Integer getStations_number(){
        return stations.size();
    }

    public List getSameLines(Station fromStation, Station toStation) {
        List<Integer> list = new ArrayList<>();
        for(Integer line : fromStation.getLineList()){
            if(toStation.getLineList().contains(line))
                list.add(line);
        }
        return list;
    }
    public void printStationInfo(String station){
        System.out.println("Station:" + station + "->");
        System.out.println("lines: ");
        for(Station station1 : stations){
            if(station1.getStationName().equals(station)){
                for(Integer line : station1.getLineList())
                    System.out.print(line + " ");
            }
        }
    }
    public void printAllStation() {
        for(Station station : stations){
            printStationInfo(station.getStationName());
            System.out.println("");
        }
    }

    public Set<String> getStation_names() {
        return station_names;
    }

    public void setStation_names(Set<String> station_names) {
        this.station_names = station_names;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
