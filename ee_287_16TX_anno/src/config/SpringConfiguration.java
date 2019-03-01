package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，当做bean.xml用
 * @author LM_Code
 * @create 2019-03-01-17:11
 */
@Configuration
@ComponentScan("com.itheima16")
@Import({JdbcConfig.class, TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
