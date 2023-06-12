package Hello.core.BeanFind;

import Hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Role ROLE_APPLICATION: 직접 등록한 어플리케이션 빈
// Role ROLE_INFRASTRUCTURE: 스프링 내부 사용 빈

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String benDefinitionNames : beanDefinitionNames) {
            Object bean = ac.getBean(benDefinitionNames);
            System.out.println("benDefinitionNames = " + benDefinitionNames + "object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String benDefinitionNames : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(benDefinitionNames);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(benDefinitionNames);
                System.out.println("benDefinitionNames = " + benDefinitionNames + "object = " + bean);
            }
        }
    }
}
