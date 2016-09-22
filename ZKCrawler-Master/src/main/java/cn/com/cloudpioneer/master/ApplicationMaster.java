package cn.com.cloudpioneer.master;

import cn.com.cloudpioneer.master.app.CuratorMaster;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Tijun on 2016/9/8.
 */
@SpringBootApplication
@ComponentScan("/")
public class ApplicationMaster
{
    public static void main(String[]args) throws Exception
    {
        SpringApplication.run(ApplicationMaster.class,args);
        CuratorMaster master=new CuratorMaster("123","88.88.88.110:2181",new ExponentialBackoffRetry(1000,5));
        master.startMaster();
    }
}