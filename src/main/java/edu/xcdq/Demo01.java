package edu.xcdq;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Tools.zhuCe();


        // 1 注册驱动
        Class.forName(Tools.getDriver());
        // 2 获取链接
        Connection connection = DriverManager.getConnection(Tools.getUrl(),Tools.getUser(),Tools.getPassword());
        // 3 准备状态
        Statement statement = connection.createStatement();
        // 4 准备sql执行
        ResultSet resultSet = statement.executeQuery("select * from book");
        // 5 获取并遍历结果集
        while (resultSet.next()){
            System.out.println(
                    resultSet.getInt(1)+resultSet.getString(2)+
                            resultSet.getString(3)+resultSet.getDouble(4)
            );
        }
        // 6 关闭资源
        Tools.closeAll(resultSet,statement,connection);
    }
}
