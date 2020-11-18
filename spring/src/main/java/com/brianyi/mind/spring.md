#spring bean注意事项
    applicationContext 就是ioc容器的接口,可以通过此对象获取容器中创建的对象
    对象在spring容器创建完成时就已经创建完成,不需要用的时候在创建
    对象在ioc容器中存储的时候都是单例的,如果多例则要修改属性
    创建对象给属性赋值的时候是通过setter方法实习的
    对象的属性是由setter/getter方法决定的 而不是定义的成员属性
#bean的默认名称
    类名的首字母小写
#spring bean的 几种类的初始化方式
    1.setter/getter 注入  其name是根据setter后的名称的首字母小写
         <bean id="user" class="com.brianyi.entity.User">
             <property name="name" value="ahao"/>
             <property name="age" value="123"/>
             <property name="gender" value="男"/>
         </bean>
    2.constructor注入  name根据参数列表
        <bean id="userByConstructor" class="com.brianyi.entity.User">
            <constructor-arg type="java.lang.String" value="ahao"/>
            <constructor-arg index="1" value="12"/>
            <constructor-arg name="gender" value="男"/>
        </bean>
        
#spring的命名空間
    p命名空間
           导入p的命名空间的xml 
                xmlns:p="http://www.springframework.org/schema/p
           配置bean
                <bean id="userByPNameSpace" class="com.brianyi.entity.User" p:name="ahao" p:age="23" p:gender="男"/>
    c命名空间
            导入c的命名空间的xml
                xmlns:c="http://www.springframework.org/schema/c"
            配置bean
                 <bean id="userByCNameSpace" class="com.brianyi.entity.User" c:name="ahao" c:age="23" c:gender="男"/>
#spring引用类型的注入
    数组或者列表
        1.可以使用字符串代替  StringToArrayConverter进行了转换
            <bean id="person" class="com.brianyi.entity.Person" p:age="20" p:names="身高:175,体重:20t" p:name="ahao" p:address-ref="address"/>
            其中names为list 中间使用,分开即可转换为列表
        2.使用property 中list进行赋值
            <bean id="person2" class="com.brianyi.entity.Person" p:age="20"  p:name="ahao" p:address-ref="address">
                        <property name="names">
                            <list>hao</list>
                         </property>
            </bean>
    Map 的注入
        <bean id="person2" class="com.brianyi.entity.Person" p:age="20"  p:name="ahao" p:address-ref="address">
            <property name="names">
                <list>hao</list>
                <list>123456</list>
                <list>88888</list>
            </property>
            <property name="infos">
                <map>
                    <entry key="first" value="1"/>
                    <entry key="second" value="2"/>
                </map>
            </property>
        </bean>
    引用对象 
        使用bean 中的ref进行应用其他对象

#spring bean 的继承
    使用bean的 parent属性
#spring bean  的创建顺序
    正常来说 根据 xml定义顺序来确定
    要干扰的话 使用 depends-on 属性进行干扰
#spring bean 的作用域
    属性 scope
        singleton:单例 默认
        prototype:多例 
    spring4.x 还有
        request: 每次请求创建一个新的对线
        session: 每次会话创建一个新的对线  默认会话时间 30min
#使用工厂创建bean对象 
    实列工厂 
    <!--        创建实列工厂-->
            <bean id="personFactory" class="com.brianyi.factory.PersonFactory"/>
    <!--        创建对象-->  这里 class 可不写
            <bean id="person3" factory-bean="personFactory" factory-method="getPerson"/>
    静态工厂     
          注意class位工厂名 
         <bean id="personByStaticFactory" class="com.brianyi.factory.PersonStaticFactory" factory-method="getPerson"/>
         
          获取时候的class为 person的class 
          Person personByStaticFactory = classPathXmlApplicationContext.getBean("personByStaticFactory", Person.class);
          System.out.println(personByStaticFactory);
#对象的创建 可以指定具体地初始化和销毁的方法 
    调用: init-method 与 destroy-method
    初始方法 , 销毁方法 与类的scope属性也有关系
    singleton 初始化和修会的方法都存在
    peototype 初始会调用,但是销毁不会调用
    初始化: 对象创建完成后调用
    销毁:容器销毁时调用  
        ((ClassPathXmlApplicationContext)classPathXmlApplicationContext).close();
        
        
#bean对象增强 实现BeanPostProcessor
    public class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization");
            return bean;
        }
        
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessAfterInitialization");
            return bean;
        }
    }
    会对所有的bean 进行增强
    
#导入外部文件
    1.导入命名空间
                <context:property-placeholder location="classpath:jdbc.properties"/>
                <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
                    <property name="username" value="${jdbc.user}"/>
                    <property name="url" value="${jdbc.url}"/>
                    <property name="password" value="${jdbc.password}"/>
                    <property name="driver" value="${jdbc.driver}"/>
                </bean>
    2.注意 username 有坑 会被电脑系统变量usernam替换 加前缀解决
#spring 中可以使用自动装配功能 spring会把某bean 自动装配到另外的bean中
    属性名: autowire属性实现自动装配
    值的含义:
        default/no:不装配
        byName:按照名字来进行装配 这个名字是setter后面的首字母小写决定的
        byType:按着类型进行装配 
        constructor: 根据构造参数进行注入 参数列表必须只包含某一个特定的类
        
#SpEl
    使用 #{...} 要与引入的外部文件的${..}进行区分
    