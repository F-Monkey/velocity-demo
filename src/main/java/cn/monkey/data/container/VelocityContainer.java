package cn.monkey.data.container;

import cn.monkey.data.model.dto.VelocityDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VelocityContainer implements IVelocityContainer {

    private volatile Map<String, IVelocityParser> velocityParserMap;

    @Override
    public void load(List<VelocityDto> velocityDtoList) {
        this.velocityParserMap = velocityDtoList.stream().map(VelocityParser::new).collect(Collectors.toMap(VelocityParser::getId, velocityParser -> velocityParser));
    }

    @Override
    public IVelocityParser getParser(String id) {
        return this.velocityParserMap.get(id);
    }
}
