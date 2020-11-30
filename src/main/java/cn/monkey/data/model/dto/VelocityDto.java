package cn.monkey.data.model.dto;

import java.util.List;

public class VelocityDto {

    private String id;

    /**
     * 判断文件能否解析的条件
     */
    private List<String> predictRegex;

    private String velocityScripts;

    private String serializableSign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPredictRegex() {
        return predictRegex;
    }

    public void setPredictRegex(List<String> predictRegex) {
        this.predictRegex = predictRegex;
    }

    public String getVelocityScripts() {
        return velocityScripts;
    }

    public void setVelocityScripts(String velocityScripts) {
        this.velocityScripts = velocityScripts;
    }

    public String getSerializableSign() {
        return serializableSign;
    }

    public void setSerializableSign(String serializableSign) {
        this.serializableSign = serializableSign;
    }
}
