package com.orange.talent.account.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class MapperConverter {
    private final ModelMapper mapper;

    private MapperConverter(MatchingStrategy matchingStrategy) {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setMatchingStrategy(matchingStrategy);
    }

    private MapperConverter(MatchingStrategy matchingStrategy,
                            Converter<?,?> converter) {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setMatchingStrategy(matchingStrategy);
        this.mapper.addConverter(converter);
    }

    public static MapperConverter convert() {
        return new MapperConverter(MatchingStrategies.STRICT);
    }

    public static MapperConverter convert(MatchingStrategy matchingStrategy) {
        return new MapperConverter(matchingStrategy);
    }

    public static MapperConverter convert(MatchingStrategy matchingStrategy,
                                          Converter<?,?> converter) {
        return new MapperConverter(matchingStrategy, converter);
    }

    public <T> T map(Object source, Class<T> destinationType) {
        if(source == null)
            return null;
        return this.mapper.map(source, destinationType);
    }

    public <T> List<T> map(List<?> list, Class<T> destinationType) {
        return list.stream().map(e -> map(e, destinationType)).collect(Collectors.toList());
    }

    public <T> T map(Object source, T destination) {
        this.mapper.map(source, destination);
        return destination;
    }
}
