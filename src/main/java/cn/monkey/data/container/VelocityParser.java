package cn.monkey.data.container;

import cn.monkey.data.model.dto.VelocityDto;
import cn.monkey.data.model.vo.Result;
import cn.monkey.data.util.CSVUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.parser.VelocityCharStream;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

import java.io.InputStream;
import java.util.function.Predicate;


public class VelocityParser implements IVelocityParser {

    private final String id;

    private final Predicate<String> regex;

    private final VelocityEngine ve;

    public VelocityParser(VelocityDto velocityDto) {
        this.id = velocityDto.getId();
        this.regex = s -> true;
        String velocityScripts = velocityDto.getVelocityScripts();
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader", "");
        StringResourceRepository repo = StringResourceLoader.getRepository();
        repo.putStringResource(id, velocityScripts);
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.StringResourceLoader");
        ve.init();
        VelocityContext vc = new VelocityContext();
        
        this.ve = ve;
        //StringResourceLoader;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Result<?> parse(String fileName, InputStream is) {
        if (!this.regex.test(fileName)) {
            return new Result<>();
        }
        ve.setProperty("is", is);
        return null;
    }
}
