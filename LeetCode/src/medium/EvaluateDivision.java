package medium;

import java.util.*;

public class EvaluateDivision {

    Map<String, Map<String,Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] res = new double[queries.size()];

        buildGraph(equations,values);

        int index  = 0;
        for(List<String> l:queries){

            double val = dfs(l.get(0), l.get(1), new HashSet<>());
            res[index++] = val;
        }

        return res;
    }

    public double dfs(String src, String des, Set<String> visited){

        if(!graph.containsKey(src))
            return -1.0;

        if(graph.get(src).containsKey(des))
            return graph.get(src).get(des);

        visited.add(src);

        for (Map.Entry<String, Double> neighbour : graph.get(src).entrySet()) {

            if (!visited.contains(neighbour.getKey())){

                double w = dfs(neighbour.getKey(), des, visited);
                if(w!=-1.0)
                    return w*neighbour.getValue();
            }

        }

        return -1.0;
    }


    public void buildGraph(List<List<String>> equations, double[] values){

        for(int i=0; i<values.length; i++){

            List<String> l = equations.get(i);
            String src = l.get(0);
            String des = l.get(1);

            if(!graph.containsKey(src)){
                graph.put(src, new HashMap<String,Double>());
            }

            if(!graph.containsKey(des)){
                graph.put(des, new HashMap<String,Double>());
            }
            double w = values[i];

            graph.get(src).put(des,w);
            graph.get(des).put(src,1/w);
        }
    }
}
