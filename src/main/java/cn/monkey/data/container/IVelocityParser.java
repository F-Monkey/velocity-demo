package cn.monkey.data.container;

import cn.monkey.data.model.vo.Result;

import java.io.InputStream;

public interface IVelocityParser {

    String getId();

    Result<?> parse(String fileName, InputStream is);
}
