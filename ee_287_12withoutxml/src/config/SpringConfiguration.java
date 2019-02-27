package config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LM_Code
 * @create 2019-02-27-14:16
 */
@Configurable
@ComponentScan("com.itheima12")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
