package org.github.zhengchalei.plugin.generator.serivce;

import org.springframework.stereotype.Service;

@Service
public class DomainGeneratorService {

    //
    // 可以使用Spring Boot提供的FreeMarkerTemplateUtils类，该类提供了一个静态方法processTemplateIntoString，
    // 可以把FreeMarker模板渲染成字符串，传入参数即FreeMarker模板，以及需要渲染的数据，
    // 即可拿到渲染结果。例如：
    // String template = "Hello ${name}!";
    // Map<String, Object> model = new HashMap<>();
    // model.put("name", "John Doe");
    // String result = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    // result = "Hello John Doe!"

}
