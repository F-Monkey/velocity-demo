package cn.monkey.data.container;

import cn.monkey.data.model.dto.VelocityDto;

import java.util.List;

public interface IVelocityContainer {
    void load(List<VelocityDto> velocityDtoList);

    IVelocityParser getParser(String id);
}
