//package com.zmyjn.test.config;
//
//import com.zmyjn.test.filter.WsInterceptor;
//import com.zmyjn.test.webservice.TestService;
//import com.zmyjn.test.webservice.impl.TestServiceImpl;
//import org.apache.cxf.Bus;
//import org.apache.cxf.bus.spring.SpringBus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.apache.cxf.transport.servlet.CXFServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.xml.ws.Endpoint;
//
//@Configuration
//public class TestConfig {
//
//
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/service/*");
////        servletRegistrationBean.setName("webService");
//        return servletRegistrationBean;
//    }
//    @Bean(name = Bus.DEFAULT_BUS_ID)
//    public SpringBus springBus() {
//        return new SpringBus();
//    }
//
//    @Bean
//    public TestService testService(){
//        return new TestServiceImpl();
//    }
//
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), testService());
//        endpoint.publish("/test");
//        //endpoint.getInInterceptors().add(new WsInterceptor()); //add webservice inteceptor
//        return endpoint;
//    }
//
//
//}
