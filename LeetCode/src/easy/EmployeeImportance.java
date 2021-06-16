package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }

        return getImportance(map, id);
    }

    public int getImportance(Map<Integer,Employee> map, int id){


        Employee e = map.get(id);
        int importance = e.importance;

        for(int i: e.subordinates){
            importance+=getImportance(map,i);
        }

        return importance;
    }
}
