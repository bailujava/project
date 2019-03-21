package tv.buka.analyze;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("ALL")
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("tv.buka.dao")
@ComponentScan("tv.buka")//扫描注解元素
public class DoubleTeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoubleTeacherApplication.class, args);
	}

	/*public static final String transactionExecution = "execution (* tv.buka.service..*.*(..))";

	@Autowired
	private DataSource dataSource;

	//声明式事务
	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(transactionExecution);
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(pointcut);
		Properties attributes = new Properties();
		attributes.setProperty("*", "PROPAGATION_REQUIRED,-Exception");
		attributes.setProperty("get*", "PROPAGATION_REQUIRED,-Exception");
		attributes.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
		attributes.setProperty("insert*", "PROPAGATION_REQUIRED,-Exception");
		attributes.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
		attributes.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");
		TransactionInterceptor txAdvice = new TransactionInterceptor(new DataSourceTransactionManager(dataSource), attributes);
		advisor.setAdvice(txAdvice);
		return advisor;
	}*/
}
