package com.example.graduationproject.common;

import com.example.graduationproject.entity.logistics.Node;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {
    private double maxDouble = 9999999.99;
    private double [][]map = new double[1000][1000];
    private int  []path = new int[1000];
    private List<Node> nodes = new ArrayList<>();
    private List<Node> paths = new ArrayList<>();

    public Dijkstra(){
        this.readMapFromFile();
    }

    private void readMapFromFile(){
        for (int i = 0; i < 1000; ++i){
            for (int j = 0; j < 1000; ++j)
                map[i][j] = -1;
        }
        try{
            Scanner scanner = new Scanner(new FileInputStream("C:/Users/QYH/workspace-2022/graduation-project/src/main/resources/data1.txt"));
            while(scanner.hasNext()){
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                double dist = scanner.nextDouble();
                //System.out.println(i + " " + j + " " + dist);
                map[i][j] = dist;
                map[j][i] = dist;
            }
            Scanner scanner2 = new Scanner(new FileInputStream("C:/Users/QYH/workspace-2022/graduation-project/src/main/resources/data2.txt"));
            while(scanner2.hasNext()){
                int id = scanner2.nextInt();
                double x = scanner2.nextDouble();
                double y = scanner2.nextDouble();
                Node node = Node.builder().id(id).lon(x).lat(y).build();
                nodes.add(node);
            }

        }catch(Exception e){
            e.printStackTrace();
            return;
        }
    }

    public double shortPath(int v0, int dest){
        int i,j,k;
        double []dist = new double[1000];
        boolean[] visited= new boolean[1000];

        for(i=0;i<1000;i++)
        {
            if(map[v0][i]>0&&i!=v0)
            {
                dist[i]=map[v0][i];path[i]=v0;

            }
            else
            {
                dist[i]=maxDouble;path[i]=-1;

            }
            visited[i]=false;
            dist[v0]=0;
            path[v0]=v0;
        }
        visited[v0]=true;
        for(i=1;i<1000;i++)
        {
            double min=maxDouble;
            int u = -1;
            for(j=0;j<1000;j++)
            {
                if (visited[j] == false && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            if (u == dest)
                return dist[u];
            if (u == -1)
                return -1;
            visited[u]=true;

            for(k=0;k<1000;k++)
            {
                if(visited[k]==false&&map[u][k] > 0&&min+map[u][k]<dist[k])
                {
                    dist[k]=min+map[u][k];
                    path[k]=u;
                }
            }
        }
        return dist[dest];
    }

    public void printPath(int sou, int dest){
        if (dest == sou){
            paths.add(nodes.get(dest-1));
            return;
        }
        printPath(sou, path[dest]);
        paths.add(nodes.get(dest-1));
    }



    public static void main(String[] argv){
        Dijkstra d = new Dijkstra();
        System.out.println("Please input the source point and destination point:");
        Scanner sc = new Scanner(System.in);
        int sou = sc.nextInt();
        int dest = sc.nextInt();
        double dist = d.shortPath(sou, dest);

        if (dist < 0)
            System.out.println("dest is unreachable");
        else {
            System.out.println("The distance is : " + dist);
            d.printPath(sou, dest);
            for (int i = 0; i < d.paths.size()-1; i++) {
                System.out.println(" ("+d.paths.get(i).getLon()+" "+d.paths.get(i).getLat()+")->");
            }
            System.out.println(" ("+d.paths.get(d.paths.size()-1).getLon()+" "+d.paths.get(d.paths.size()-1).getLat()+")");
        }

    }
}

