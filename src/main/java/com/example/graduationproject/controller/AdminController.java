package com.example.graduationproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.graduationproject.entity.basis.Agriculture;
import com.example.graduationproject.entity.basis.Car;
import com.example.graduationproject.entity.basis.Network;
import com.example.graduationproject.entity.basis.Organization;
import com.example.graduationproject.entity.logistics.Delivery;
import com.example.graduationproject.entity.logistics.Order;
import com.example.graduationproject.entity.storage.Inventory;
import com.example.graduationproject.entity.storage.InventoryRecords;
import com.example.graduationproject.entity.storage.MoveRecords;
import com.example.graduationproject.entity.storage.Warehouse;
import com.example.graduationproject.service.*;
import com.example.graduationproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "处理管理员通用操作请求", tags = {"Authorization,Admin"})
@RestController
@RequestMapping("/api/admin/")
@Slf4j
public class AdminController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private CarService carService;
    @Autowired
    private NetworkService networkService;
    @Autowired
    private AgricultureService agricultureService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private InventoryRecordsService inventoryRecordsService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private MoveRecordsService moveRecordsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryService deliveryService;

    /*-------------------------------------机构----------------------------------------*/
    @ApiOperation("添加机构")
    @PostMapping("organization")
    public ResultVO insertOrganization(@RequestBody Organization organization) {
        organizationService.insertOrganization(organization);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("organizations", organizationService.selectOrganization(queryWrapper)));
    }

    @ApiOperation("删除机构")
    @DeleteMapping("organization/{id}")
    public ResultVO deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("organizations", organizationService.selectOrganization(queryWrapper)));
    }

    @ApiOperation("修改机构")
    @PatchMapping("organization")
    public ResultVO updateOrganization(@RequestBody Organization organization) {
        organizationService.updateOrganization(organization);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("organizations", organizationService.selectOrganization(queryWrapper)));
    }

    @ApiOperation("查询所有机构")
    @GetMapping("organizations")
    public ResultVO getAllOrganizations() {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("organizations", organizationService.selectOrganization(queryWrapper)));
    }

    /*-------------------------------------网点----------------------------------------*/
    @ApiOperation("添加网点")
    @PostMapping("network")
    public ResultVO insertNetwork(@RequestBody Network network) {
        networkService.insertNetwork(network);
        QueryWrapper<Network> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("networks", networkService.selectNetwork(queryWrapper)));
    }

    @ApiOperation("删除网点")
    @DeleteMapping("network/{id}")
    public ResultVO deleteNetwork(@PathVariable Long id) {
        networkService.deleteNetwork(id);
        QueryWrapper<Network> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("networks", networkService.selectNetwork(queryWrapper)));
    }

    @ApiOperation("修改网点")
    @PatchMapping("network")
    public ResultVO updateNetwork(@RequestBody Network network) {
        networkService.updateNetwork(network);
        QueryWrapper<Network> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("networks", networkService.selectNetwork(queryWrapper)));
    }

    @ApiOperation("查询所有网点")
    @GetMapping("networks")
    public ResultVO getAllNetworks() {
        QueryWrapper<Network> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("networks", networkService.selectNetwork(queryWrapper)));
    }

    /*-------------------------------------车辆----------------------------------------*/
    @ApiOperation("添加车辆")
    @PostMapping("car")
    public ResultVO insertCar(@RequestBody Car car) {
        car.setDate(car.getDate().substring(0,10));
        carService.insertCar(car);
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("cars", carService.selectCar(queryWrapper)));
    }

    @ApiOperation("删除车辆")
    @DeleteMapping("car/{id}")
    public ResultVO deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("cars", carService.selectCar(queryWrapper)));
    }

    @ApiOperation("修改车辆")
    @PatchMapping("car")
    public ResultVO updateCar(@RequestBody Car car) {
        carService.updateCar(car);
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("cars", carService.selectCar(queryWrapper)));
    }

    @ApiOperation("查询所有车辆")
    @GetMapping("cars")
    public ResultVO getAllCars() {
        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("cars", carService.selectCar(queryWrapper)));
    }

    /*-------------------------------------农产品----------------------------------------*/
    @ApiOperation("添加农产品")
    @PostMapping("agriculture")
    public ResultVO insertAgriculture(@RequestBody Agriculture agriculture) {
        agriculture.setProcessingtime(agriculture.getProcessingtime().substring(0,10));
        agricultureService.insertAgriculture(agriculture);
        QueryWrapper<Agriculture> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("agricultures", agricultureService.selectAgriculture(queryWrapper)));
    }

    @ApiOperation("删除农产品")
    @DeleteMapping("agriculture/{id}")
    public ResultVO deleteAgriculture(@PathVariable Long id) {
        agricultureService.deleteAgriculture(id);
        QueryWrapper<Agriculture> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("agricultures", agricultureService.selectAgriculture(queryWrapper)));
    }

    @ApiOperation("修改农产品")
    @PatchMapping("agriculture")
    public ResultVO updateAgriculture(@RequestBody Agriculture agriculture) {
        agricultureService.updateAgriculture(agriculture);
        QueryWrapper<Agriculture> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("agricultures", agricultureService.selectAgriculture(queryWrapper)));
    }

    @ApiOperation("查询所有农产品")
    @GetMapping("agricultures")
    public ResultVO getAllAgricultures() {
        QueryWrapper<Agriculture> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("agricultures", agricultureService.selectAgriculture(queryWrapper)));
    }

    /*-------------------------------------仓库----------------------------------------*/
    @ApiOperation("添加仓库")
    @PostMapping("warehouse")
    public ResultVO insertWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.insertWarehouse(warehouse);
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("warehouses", warehouseService.selectWarehouse(queryWrapper)));
    }

    @ApiOperation("删除仓库")
    @DeleteMapping("warehouse/{id}")
    public ResultVO deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("warehouses", warehouseService.selectWarehouse(queryWrapper)));
    }

    @ApiOperation("修改仓库")
    @PatchMapping("warehouse")
    public ResultVO updateWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.updateWarehouse(warehouse);
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("warehouses", warehouseService.selectWarehouse(queryWrapper)));
    }

    @ApiOperation("查询所有仓库")
    @GetMapping("warehouses")
    public ResultVO getAllWarehouses() {
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("warehouses", warehouseService.selectWarehouse(queryWrapper)));
    }

    @ApiOperation("入库")
    @PostMapping("putin")
    public ResultVO putIn(@RequestBody InventoryRecords inventoryRecords) {
        inventoryRecords.setDate(inventoryRecords.getDate().substring(0,10));
        inventoryRecordsService.insertInventoryRecords(inventoryRecords);
        QueryWrapper<Inventory> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("name", inventoryRecords.getName())
                .eq("whname", inventoryRecords.getWhname());
        Inventory inventory = inventoryService.getInventory(queryWrapper1);
        if (inventory == null) {
            Inventory inventory1 = Inventory.builder().name(inventoryRecords.getName())
                    .whname(inventoryRecords.getWhname())
                    .quantity(inventoryRecords.getQuantity())
                    .build();
            inventoryService.insertInventory(inventory1);
        } else {
            inventory.setQuantity(inventory.getQuantity() + inventoryRecords.getQuantity());
            inventoryService.updateInventory(inventory);
        }
        QueryWrapper<InventoryRecords> queryWrapper2 = new QueryWrapper<>();
        return ResultVO.success(Map.of("inventory_records", inventoryRecordsService.selectInventoryRecords(queryWrapper2)));
    }

    @ApiOperation("出库")
    @PatchMapping("outbound")
    public ResultVO outbound(@RequestBody Inventory inventory) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式(年-月-日-时-分-秒)
        String createTime = dateFormat.format(now);//格式化然后放入字符串
        InventoryRecords inventoryRecords = InventoryRecords.builder()
                .name(inventory.getName())
                .type(1)
                .whname(inventory.getWhname())
                .quantity(inventory.getQuantity())
                .date(createTime)
                .build();
        inventoryRecordsService.insertInventoryRecords(inventoryRecords);
        QueryWrapper<Inventory> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id", inventory.getId());
        inventory.setQuantity(inventoryService.getInventory(queryWrapper1).getQuantity() - inventory.getQuantity());
        if (inventory.getQuantity() == 0) {
            inventoryService.deleteInventory(inventory.getId());
        } else {
            inventoryService.updateInventory(inventory);
        }
        return ResultVO.success(Map.of());
    }

    @ApiOperation("查询指定仓库库存")
    @GetMapping("inventorys/{whname}")
    public ResultVO getInventory(@PathVariable String whname) {
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("whname", whname);
        return ResultVO.success(Map.of("inventorys", inventoryService.selectInventory(queryWrapper)));
    }

    @ApiOperation("查询所有仓库进出库记录")
    @GetMapping("inventory_records")
    public ResultVO getInventoryRecords() {
        QueryWrapper<InventoryRecords> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("inventory_records", inventoryRecordsService.selectInventoryRecords(queryWrapper)));
    }

    @ApiOperation("查询指定仓库进出库记录")
    @GetMapping("inventory_records/{whname}")
    public ResultVO getInventoryRecords(@PathVariable String whname) {
        QueryWrapper<InventoryRecords> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("whname", whname);
        return ResultVO.success(Map.of("inventory_records", inventoryRecordsService.selectInventoryRecords(queryWrapper)));
    }

    @ApiOperation("移库")
    @PostMapping("move")
    public ResultVO move(@RequestBody MoveRecords moveRecords) {
        moveRecordsService.insertMoveRecords(moveRecords);
        QueryWrapper<Inventory> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("whname", moveRecords.getOriginalWarehouse());
        List<Inventory>inventories = inventoryService.selectInventory(queryWrapper1);
        inventories.forEach(inventory -> {
            inventoryService.deleteInventory(inventory.getId());
            QueryWrapper<Inventory> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("name", inventory.getName())
                    .eq("whname", moveRecords.getTargetWarehouse());
            Inventory inventory2 = inventoryService.getInventory(queryWrapper2);
            if (inventory2 == null) {
                inventory.setWhname(moveRecords.getTargetWarehouse());
                inventoryService.insertInventory(inventory);
            } else {
                inventory2.setQuantity(inventory2.getQuantity() + inventory.getQuantity());
                inventoryService.updateInventory(inventory2);
            }
        });
        return ResultVO.success(Map.of());
    }

    @ApiOperation("查询所有订单")
    @GetMapping("orders")
    public ResultVO getOrders() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("orders", orderService.selectOrder(queryWrapper)));
    }

    @ApiOperation("查询符合条件仓库")
    @PostMapping("whs")
    public ResultVO getWarehouse(@RequestBody Order order) {
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        List<Warehouse> warehouses = new ArrayList<>();
        warehouseService.selectWarehouse(queryWrapper).forEach(w->{
            QueryWrapper<Inventory> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("whname",w.getName());
            queryWrapper2.eq("name",order.getProName());
            queryWrapper2.ge("quantity",order.getQuantity());
            if(inventoryService.selectInventory(queryWrapper2).size()>0){
                warehouses.add(w);
            }
        });
        return ResultVO.success(Map.of("warehouses", warehouses));
    }

    @ApiOperation("确认订单")
    @PatchMapping("order")
    public ResultVO updateOrder(@RequestBody Order order) {
        QueryWrapper<Inventory> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("whname",order.getWarehouse());
        queryWrapper2.eq("name",order.getProName());
        Inventory inventory = inventoryService.getInventory(queryWrapper2);
        inventory.setQuantity(inventory.getQuantity()-order.getQuantity());
        inventoryService.updateInventory(inventory);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式(年-月-日-时-分-秒)
        String createTime = dateFormat.format(now);//格式化然后放入字符串
        InventoryRecords inventoryRecords = InventoryRecords.builder()
                .name(order.getProName())
                .quantity(order.getQuantity())
                .whname(order.getWarehouse())
                .type(1)
                .date(createTime)
                .build();
        Delivery delivery = Delivery.builder()
                .oid(order.getId())
                .date(createTime)
                .msg("订单已确认")
                .build();
        deliveryService.insertDelivery(delivery);
        inventoryRecordsService.insertInventoryRecords(inventoryRecords);
        orderService.updateOrder(order);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("orders", orderService.selectOrder(queryWrapper)));
    }

    @ApiOperation("更新订单状态")
    @PatchMapping("order2")
    public ResultVO updateOrder2(@RequestBody Order order) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式(年-月-日-时-分-秒)
        String createTime = dateFormat.format(now);//格式化然后放入字符串
        Delivery delivery = Delivery.builder()
                .oid(order.getId())
                .date(createTime)
                .msg(order.getState())
                .build();
        deliveryService.insertDelivery(delivery);
        orderService.updateOrder(order);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        return ResultVO.success(Map.of("orders", orderService.selectOrder(queryWrapper)));
    }

}
