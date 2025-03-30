package com.service.worklog.configuration;

import com.service.worklog.domain.TimeCard;
import jakarta.persistence.criteria.Predicate;
import org.springframework.core.MethodParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpecificationArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return Specification.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

    Map<String, String[]> parameterMap = webRequest.getParameterMap();

    return (Specification<TimeCard>) (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      parameterMap.forEach((key, values) -> {
        // Skip pagination and sorting parameters
        if (!key.startsWith("page") && !key.startsWith("size") && !key.startsWith("sort")) {
          // For simple equality filtering
          if (values.length > 0 && values[0] != null && !values[0].isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get(key), values[0]));
          }
        }
      });

      return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}