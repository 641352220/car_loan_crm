package com.bootdo.common.utils.insertBatch;

import com.bootdo.CarManage.domain.CarDO;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class MySQLUpdate {

    public static Logger log = Logger.getLogger(MySQLUpdate.class);

//    static Connection con = MySQLConnections.getConnection();
//    static PreparedStatement stmt = null;


    public static  void executeInsert(List<CarDO> carDOList,Integer dept,Integer carProductInformationId,Integer carProductId){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("开始新增:"+carDOList.size());
            con = MySQLConnections.getConnection();
            // 关闭事务自动提交 ,这一行必须加上
            con.setAutoCommit(false);
            stmt = con.prepareStatement("insert into car_product_information_car (business_id,car_product_information_id,car_id,car_model_id,car_product_id,car_price,sort) "
                    + "values (?,?,?,?,?,?,10000)");
            for(CarDO carDO:carDOList){
//                stmt.addBatch("DELETE FROM car_product_information_car WHERE car_product_information_id = "+carProductInformationId+" AND car_id = "+carDO.getCarId());
                stmt.setInt(1, dept);
                stmt.setInt(2, carProductInformationId);
                stmt.setInt(3, carDO.getCarId());
                stmt.setInt(4, carDO.getCarModelId());
                stmt.setInt(5, carProductId);
                stmt.setInt(6, carDO.getPriceMin());
                stmt.addBatch();
            }
            stmt.executeBatch();
            con.commit();
        }catch (Exception e){
            log.error("批量新增汽车产品关联表异常"+e.getMessage(),e);
        }finally {
            try {
                if(null != stmt){
                    stmt.close();
                }
                if(null != con){
                    con.close();
                }
            } catch (SQLException e) {
                log.error("批量新增汽车产品关联表关闭链接异常:"+e.getMessage(),e);
            }
        }

    }

}
