package webservice.real.confige;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
    messageDispatcherServlet(ApplicationContext context) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "calculator")
    public DefaultWsdl11Definition wsdlDefinition(XsdSchema schema) {

        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();

        wsdl.setPortTypeName("CalculatorPort");

        wsdl.setLocationUri("/ws");   // IMPORTANT

        wsdl.setTargetNamespace("http://example.com/calculator");

        wsdl.setSchema(schema);

        return wsdl;
    }

    @Bean
    public XsdSchema schema() {

        return new SimpleXsdSchema(
                new ClassPathResource("schemas/rele.xsd")
        );
    }
}