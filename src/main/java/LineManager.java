
import java.util.*;

public class LineManager {
    private Set<String> line_numbers; //所有线路编号
    private List<Line> lines;//所有线路
    public LineManager() {
        line_numbers = new HashSet<>();
        lines = new ArrayList<>();
    }
    public void addLine(String line, String station_name){
        if(line_numbers.contains(line)) {
            for(Line line1 : lines){
                if(line1.getLine_number() == Integer.parseInt(line))
                    line1.getStations().add(station_name);
            }
        }
        else{
            Line line1 = new Line();
            line1.setLine_number(Integer.parseInt(line));
            line1.setStations(new ArrayList<>());
            line1.getStations().add(station_name);
            line_numbers.add(line);
            lines.add(line1);
        }
    }

    public void printLineInfo(Integer line_number){
        System.out.println("line:" + line_number);
        System.out.println("stations:");
        for(Line line : lines){
            if(line.getLine_number() == line_number){
                for(String station : line.getStations())
                    System.out.print(station + " ");
            }
        }
    }
    public void printAllInfo(){
        for(Line line : lines) {
            printLineInfo(line.getLine_number());
            System.out.println("");
        }
    }

    /**
     * 获取最短直达路径
     * @return
     */
    public Router getBestRouter(String fromStation, String toStation, List<Integer> lineList){
        Router router = new Router();
        router.setFromStation(fromStation);
        router.setToStation(toStation);
        router.setStations(9999);
        if(lineList == null || lineList.size() == 0)
            return router;

        for(Line line : lines){
            if(lineList.contains(line.getLine_number())){
                int start_index = 0;
                int end_index = 0;
                for(int i = 0; i < line.getStations().size(); i++){
                    if(line.getStations().get(i).equals(fromStation))
                        start_index = i;
                    if(line.getStations().get(i).equals(toStation))
                        end_index = i;
                }
                Integer stops = Math.abs(end_index - start_index);
                if(stops < router.getStations()){
                    router.setStations(stops);
                    router.setLine(line.getLine_number() + "");
                }
            }
        }
        return router;
    }
    public void printStops(Integer line_number, String fromStation, String toStation){
        Line line = null;
        for(Line item : lines) {
            if (item.getLine_number() == line_number)
                line = item;
        }
        Integer startIndex = 0;
        Integer stopIndex = 0;
        for(int i = 0; i < line.getStations().size(); i++ ){
            if(line.getStations().get(i). equals(fromStation))
                startIndex = i;
            if(line.getStations().get(i).equals(toStation))
                stopIndex = i;
        }
        if(startIndex < stopIndex){
            for(int i = startIndex; i <= stopIndex; i++){
                System.out.print(line.getStations().get(i));
                if(i < stopIndex)
                    System.out.print("->");
            }
        }
        else{
            for(int i = startIndex; i >= stopIndex; i--){
                System.out.println(line.getStations().get(i));
                if(i > stopIndex)
                    System.out.print("->");
            }
        }
        System.out.println("");
    }

    public Set<String> getLine_numbers() {
        return line_numbers;
    }

    public void setLine_numbers(Set<String> line_numbers) {
        this.line_numbers = line_numbers;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
