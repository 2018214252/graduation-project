package com.example.graduationproject.common;

import com.example.graduationproject.entity.UserDTO;
import com.example.graduationproject.entity.logistics.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class Recommend {
    private Map<Long, Double> map = new HashMap<>();

    private Long computeNearestNeighbor(UserDTO u1, List<UserDTO> users) {
        Double a=0.0;
        Long uid = u1.getId();
        for (UserDTO u2 : users) {
            if (!u2.getId().equals(u1.getId())) {
                double distance = cosineSimilarity(u2.getOrders(), u1.getOrders());
                map.put(u2.getId(),distance);
                if (distance>=a) {
                    a=distance;
                    uid = u2.getId();
                }
            }
        }
        return uid;
    }

    private double cosineSimilarity(List<Order> orders1,List<Order> orders2){
        double num=0;
        double a=orders1.size();
        double b=orders2.size();
        if(a*b==0) return 0;
        for (Order order1:orders1){
            for (Order order2:orders2){
                if(order1.getProName().equals(order2.getProName())) num++;
            }
        }
        return num/Math.sqrt(a*b);
    }

    public List<String> recommend(UserDTO u1, List<UserDTO> users) {
        //找到最近邻
        Long nearest = computeNearestNeighbor(u1, users);

        System.out.print(u1.getId()+":");
        for(Order order:u1.getOrders()){
            System.out.print(order.getProName()+" ");
        }
        System.out.println();
        for(UserDTO userDTO:users){
            if(userDTO.getId()==1514254651715256321L||userDTO.getId()==1515298273390776321L||userDTO.getId()==1514438056482467841L){
                continue;
            }
            System.out.print(userDTO.getId()+":");
            for(Order order:userDTO.getOrders()){
                System.out.print(order.getProName()+" ");
            }
            System.out.println();
        }
        System.out.println("相似性矩阵：");
        for (Long key:map.keySet()){
            if(key==1514254651715256321L||key==1515298273390776321L){
                continue;
            }
            System.out.println(key+": "+map.get(key));
        }

        System.out.println("最近邻 -> " + nearest);

        //找到最近邻看过，但是我们没看过的电影，计算推荐
        UserDTO neighborOrders = new UserDTO();
        for (UserDTO user:users) {
            if (nearest.equals(user.getId())) {
                neighborOrders = user;
            }
        }

        //根据自己和邻居的电影计算推荐的电影
        List<String> recommendAgriculture = new ArrayList<>();
        for (Order order1 : neighborOrders.getOrders()) {
            boolean flag = true;
            for (Order order2 : u1.getOrders()){
                if (order1.getProName().equals(order2.getProName())) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                recommendAgriculture.add(order1.getProName());
            }
        }
        return recommendAgriculture;
    }
}
