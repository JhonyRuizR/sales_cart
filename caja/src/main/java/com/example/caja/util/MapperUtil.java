package com.example.caja.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ApplicationContext aplicationContext;

    public<S,T>List<T> mapList(List<S> source, Class<T> targetClass, String... MapperQualifier) {
        ModelMapper modelMapper = getModelMapper(MapperQualifier);
        return source
                .stream()
                .map(element->modelMapper.map(element,targetClass))
                .toList();
    }

    public <S,T> T map(S source, Class<T> targetClass, String...MapperQualifier) {
        ModelMapper modelMapper  =getModelMapper(MapperQualifier);
        return modelMapper.map(source, targetClass);
    }

    private ModelMapper getModelMapper(String... MapperQualifier){
        if(MapperQualifier.length==0 || MapperQualifier[0]==null || MapperQualifier[0].isEmpty()){
            return aplicationContext.getBean("defaultMapper",ModelMapper.class);
        }else{
            return  aplicationContext.getBean(MapperQualifier[0],ModelMapper.class);
        }
    }
}
