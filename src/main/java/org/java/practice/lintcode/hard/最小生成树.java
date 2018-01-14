package org.java.practice.lintcode.hard;

import java.util.*;

/**
 * @author yang.jin
 * date: 10/01/2018
 * desc:给出一些Connections，即Connections类，找到一些能够将所有城市都连接起来并且
 * 花费最小的边。
 * 如果说可以将所有城市都连接起来，则返回这个连接方法；不然的话返回一个空列表。
 */
public class 最小生成树 {

    public static void main(String[] args) {

        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection("Acity", "Bcity", 1));
        connections.add(new Connection("Acity", "Ccity", 2));
        connections.add(new Connection("Bcity", "Ccity", 3));

        List<Connection> connections1 = new ArrayList<>();
        connections1.add(new Connection("Acity", "Bcity", 1));
        connections1.add(new Connection("Bcity", "Acity", 2));
        connections1.add(new Connection("Dcity", "Ccity", 1));
        connections1.add(new Connection("Ccity", "Dcity", 2));

        List<Connection> connections2 = new ArrayList<>();
        connections2.add(new Connection("A", "B", 6));
        connections2.add(new Connection("B", "C", 4));
        connections2.add(new Connection("C", "D", 5));
        connections2.add(new Connection("D", "E", 8));
        connections2.add(new Connection("E", "F", 1));
        connections2.add(new Connection("B", "F", 10));
        connections2.add(new Connection("E", "C", 9));
        connections2.add(new Connection("F", "C", 7));
        connections2.add(new Connection("B", "E", 3));
        connections2.add(new Connection("A", "F", 1));

        switch (1) {
            case 0:
                //思路1：先转化成图的数据结构，每个节点都去深度优先遍历，先获取完整链路，再筛选最小消耗路径
                lowestCostAttempt(connections);
                break;
            case 1:
                //思路2：Kruskal算法
                lowestCost(connections);
                break;
            default:
                break;
        }

    }

    /**
     * Kruskal算法
     */
    public static List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        connections.sort(new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.cost != o2.cost) {
                    return o1.cost - o2.cost;
                } else {
                    if (o1.city1.equals(o2.city1)) {
                        return o1.city2.compareTo(o2.city2);
                    } else {
                        return o1.city1.compareTo(o2.city1);
                    }
                }
            }
        });

        Set<String> points = new HashSet<>();
        for (Connection connection : connections) {
            points.add(connection.city1);
            points.add(connection.city2);
        }

        List<Connection> result = new ArrayList<>();
        List<Set<String>> pointSets = new ArrayList<>();
        for (String point : points) {
            Set<String> set = new HashSet<>();
            set.add(point);
            pointSets.add(set);
        }

        for (Connection connection : connections) {
            String start = connection.city1;
            String end = connection.city2;
            int startIndex = -1;
            int endIndex = -1;

            int i = 0;
            for (Set<String> point : pointSets) {
                if (point.contains(start)) {
                    startIndex = i;
                }
                if (point.contains(end)) {
                    endIndex = i;
                }
                i++;
            }

            if (startIndex < 0 || endIndex < 0) {
                return new ArrayList<>();
            }

            // 比较startIndex和endIndex大小的原因：如果先删除HasHMap较小index的元素，再删除较大Index元素时，会造成数组越界
            // 所以hashSet执行多个remove操作的时候，一定要从后往前删
            if (startIndex > endIndex) {
                Set<String> startSet = pointSets.get(startIndex);
                pointSets.remove(startIndex);
                Set<String> endSet = pointSets.get(endIndex);
                pointSets.remove(endIndex);
                startSet.addAll(endSet);
                pointSets.add(startSet);
                result.add(connection);
            } else if (startIndex < endIndex) {
                Set<String> endSet = pointSets.get(endIndex);
                pointSets.remove(endIndex);
                Set<String> startSet = pointSets.get(startIndex);
                pointSets.remove(startIndex);
                startSet.addAll(endSet);
                pointSets.add(startSet);
                result.add(connection);
            }

        }

        if (pointSets.size() > 1) {
            return new ArrayList<>();
        }

        return result;
    }
    /**
     * 思路1：每个节点都去深度优先遍历，先获取完整链路，再筛选最小消耗路径
     * 我他妈自己都快编不下去了，这题也太他妈难了吧
     */
    public static List<Connection> lowestCostAttempt(List<Connection> connections) {
        // Write your code here
        // 第一步 获取所有节点，转化成图的数据结构
        HashMap<String,List<Connection>> citiesMap = new HashMap<>();
        for (Connection connection : connections) {
            // 将city1的关联信息放到map中
            if (!citiesMap.containsKey(connection.city1)) {
                // 如果map还不包含当前城市的话，创建一个新list
                List<Connection> list = new ArrayList<>();
                Connection modify = new Connection(connection.city2,connection.city2,connection.cost);
                list.add(modify);
                citiesMap.put(connection.city1, list);
            } else {
                // 如果map已经包含当前城市，则往list中添加元素
                List<Connection> list = citiesMap.get(connection.city1);
                Connection modify = new Connection(connection.city2,connection.city2,connection.cost);
                list.add(modify);
                citiesMap.put(connection.city1, list);
            }
            // 将city2的关联信息放到map中
            if (!citiesMap.containsKey(connection.city2)) {
                // 如果map还不包含当前城市的话，创建一个新list
                List<Connection> list = new ArrayList<>();
                Connection modify = new Connection(connection.city1,connection.city1,connection.cost);
                list.add(modify);
                citiesMap.put(connection.city2, list);
            } else {
                // 如果map已经包含当前城市，则往list中添加元素
                List<Connection> list = citiesMap.get(connection.city2);
                Connection modify = new Connection(connection.city1,connection.city1,connection.cost);
                list.add(modify);
                citiesMap.put(connection.city2, list);
            }
        }

        // 第二步，深度优先遍历 找到完整链路
        int maxLength = 0;
        List<List<String>> result = new ArrayList<>();
        for (String city : citiesMap.keySet()) {
            //遍历某一个city的所有子路径
            List<Connection> sons = citiesMap.get(city);
            List<String> visited = new ArrayList<>();
            //深度优先遍历
            searchTraversing(city, visited, citiesMap);
            result.add(visited);
        }
        System.out.println(result);

        return null;
    }

    public static void searchTraversing(String city, List<String> visited,HashMap<String,List<Connection>> citiesMap) {
        // 判断是否遍历过
        if (visited.contains(city)) {
            return;
        }

        visited.add(city);
        for (int i = 0; i < citiesMap.get(city).size(); i++) {
            searchTraversing(citiesMap.get(city).get(i).city1, visited,citiesMap);
        }
    }

}
