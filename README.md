# spring boot demo
## gradle spring boot mybatis  druid  swagger2 

### application 这里我采用的是yml的这种配置方式
```$xslt
# Server settings
server:
    port: 8080
    address: localhost


# SPRING PROFILES
spring:
    # DATASOURCE
    datasource:
        name: test
        url: jdbc:mysql://localhost:3306/test?useUnicode=true&charaterEncoding=utf-8
        username: root
        password: Vinsen1991
        driverClassName: com.mysql.cj.jdbc.Driver
        type: com.alibaba.druid.pool.DruidDataSource
        dbcp2:
            initial-size: 5
            min-idle: 5
            max-idle: 20
            max-wait-millis: 60000
            time-between-eviction-runs-millis: 60000
            min-evictable-idle-time-millis: 300000
            validation-query: SELECT 1 FROM DUAL
            pool-prepared-statements: true
            test-while-idle: true
            test-on-borrow: false
            test-on-return: false



    # HTTP ENCODING
    http:
        encoding.charset: UTF-8
        encoding.force: true
        encoding.enabled: true

    # close the default cache
    thymeleaf:
        cache: false



# LOGGING
logging:
    level: com.ibatis:DEBUG

```

### application 
```$xslt
@ComponentScan({"com.vinsen"})// 扫描的包
@ServletComponentScan 这是druid 监控相关的
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

```

### druid 监控配置
* WebStatFilter
```$xslt
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {
}

```
* StatViewServlet
```$xslt
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 用户名
                @WebInitParam(name="loginPassword",value="admin"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {
}

```

### swagger2 配置
```$xslt
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vinsen.controller.api"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hello apis")
                .description("hello apis interface all ...")
                .version("1.0")
                .build();
    }

}
```