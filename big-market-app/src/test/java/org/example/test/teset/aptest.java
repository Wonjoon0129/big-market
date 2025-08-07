package org.example.test.teset;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName aatest
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/7/30 09:02
 * @Version 1.0
 */

public class aptest {
    @Test
    public void saveDistributeMaterial() {

        String params="{\n" +
                "  \"Parameters\": [\n" +
                "    {\n" +
                "      \"JLDW_ID\": \"974437203952406528\",\n" +
                "      \"LBBM\": \"290206\",\n" +
                "      \"WLMC\": \"名称 六角头自攻螺钉;螺纹规格 ST4.2;公称长度 20;材质 S30408;标准 GB/T5285\",\n" +
                "      \"FIELD7\": \"1WZ\",\n" +
                "      \"WLBM\": \"80300819\",\n" +
                "      \"CREATOR_ACCOUNT\": \"20800695\",\n" +
                "      \"LBMC\": \"自攻螺钉\",\n" +
                "      \"STATUS\": \"1\",\n" +
                "      \"QC\": \"六角头自攻螺钉\\\\ST4.2×20 S30408 GB/T5285\",\n" +
                "      \"OPER_TYPE\": \"1\",\n" +
                "      \"JLDW\": \"EA\",\n" +
                "      \"VERSION\": 0,\n" +
                "      \"CREATOR_NAME\": \"李宇华\",\n" +
                "      \"JC\": \"六角头自攻螺钉\\\\ST4.2×20 S30408 GB/T5285\",\n" +
                "      \"ID\": \"1110059026160422915\",\n" +
                "      \"CREATE_TIME\": 1753770304000,\n" +
                "      \"INS_TIME\": 1753770305000\n" +
                "    },\n" +
                "    {\n" +
                "      \"JLDW_ID\": \"974437211707674624\",\n" +
                "      \"LBBM\": \"382501\",\n" +
                "      \"WLMC\": \"名称 防火门;规格 门洞尺寸:1000×2400mm;样式 钢质;防火等级 A类;图集号 12J609\",\n" +
                "      \"FIELD7\": \"1WZ\",\n" +
                "      \"WLBM\": \"80300816\",\n" +
                "      \"CREATOR_ACCOUNT\": \"20301977\",\n" +
                "      \"LBMC\": \"门\",\n" +
                "      \"STATUS\": \"1\",\n" +
                "      \"QC\": \"防火门\\\\门洞尺寸:1000×2400mm 钢质 A类 12J609\",\n" +
                "      \"OPER_TYPE\": \"1\",\n" +
                "      \"JLDW\": \"SHA\",\n" +
                "      \"VERSION\": 0,\n" +
                "      \"CREATOR_NAME\": \"库尔班·麦麦提\",\n" +
                "      \"JC\": \"防火门\\\\门洞尺寸:1000×2400mm 钢质 A类 12J609\",\n" +
                "      \"ID\": \"1110059026416275459\",\n" +
                "      \"CREATE_TIME\": 1753770304000,\n" +
                "      \"INS_TIME\": 1753770306000\n" +
                "    },\n" +
                "    {\n" +
                "      \"JLDW_ID\": \"974437211707674624\",\n" +
                "      \"LBBM\": \"382501\",\n" +
                "      \"WLMC\": \"名称 防火门;规格 门洞尺寸:1500×2280mm;样式 钢质;防火等级 A类;图集号 12J609\",\n" +
                "      \"FIELD7\": \"1WZ\",\n" +
                "      \"WLBM\": \"80300815\",\n" +
                "      \"CREATOR_ACCOUNT\": \"20301977\",\n" +
                "      \"LBMC\": \"门\",\n" +
                "      \"STATUS\": \"1\",\n" +
                "      \"QC\": \"防火门\\\\门洞尺寸:1500×2280mm 钢质 A类 12J609\",\n" +
                "      \"OPER_TYPE\": \"1\",\n" +
                "      \"JLDW\": \"SHA\",\n" +
                "      \"VERSION\": 0,\n" +
                "      \"CREATOR_NAME\": \"库尔班·麦麦提\",\n" +
                "      \"JC\": \"防火门\\\\门洞尺寸:1500×2280mm 钢质 A类 12J609\",\n" +
                "      \"ID\": \"1110059026365943811\",\n" +
                "      \"CREATE_TIME\": 1753770304000,\n" +
                "      \"INS_TIME\": 1753770306000\n" +
                "    },\n" +
                "    {\n" +
                "      \"JLDW_ID\": \"974437203952406528\",\n" +
                "      \"LBBM\": \"290206\",\n" +
                "      \"WLMC\": \"名称 十字槽沉头自攻螺钉;螺纹规格 ST4.8;公称长度 25;材质 S30408;标准 GB/T15856.4\",\n" +
                "      \"FIELD7\": \"1WZ\",\n" +
                "      \"WLBM\": \"80300818\",\n" +
                "      \"CREATOR_ACCOUNT\": \"20800695\",\n" +
                "      \"LBMC\": \"自攻螺钉\",\n" +
                "      \"STATUS\": \"1\",\n" +
                "      \"QC\": \"十字槽沉头自攻螺钉\\\\ST4.8×25 S30408 GB/T15856.4\",\n" +
                "      \"OPER_TYPE\": \"1\",\n" +
                "      \"JLDW\": \"EA\",\n" +
                "      \"VERSION\": 0,\n" +
                "      \"CREATOR_NAME\": \"李宇华\",\n" +
                "      \"JC\": \"十字槽沉头自攻螺钉\\\\ST4.8×25 S30408 GB/T15856.4\",\n" +
                "      \"ID\": \"1110059026319806467\",\n" +
                "      \"CREATE_TIME\": 1753770304000,\n" +
                "      \"INS_TIME\": 1753770306000\n" +
                "    },\n" +
                "    {\n" +
                "      \"JLDW_ID\": \"974437212085161984\",\n" +
                "      \"LBBM\": \"391304\",\n" +
                "      \"WLMC\": \"名称 厨房水嘴;公称通径 DN15;阀体安装形式 台式明装;阀体材料 不锈钢;特殊需求 360°旋转\",\n" +
                "      \"FIELD7\": \"1WZ\",\n" +
                "      \"WLBM\": \"80300817\",\n" +
                "      \"CREATOR_ACCOUNT\": \"20890080\",\n" +
                "      \"LBMC\": \"水嘴\",\n" +
                "      \"STATUS\": \"1\",\n" +
                "      \"QC\": \"厨房水嘴\\\\DN15 台式明装 不锈钢 360°旋转\",\n" +
                "      \"OPER_TYPE\": \"1\",\n" +
                "      \"JLDW\": \"EA\",\n" +
                "      \"VERSION\": 0,\n" +
                "      \"CREATOR_NAME\": \"颜钰蓉\",\n" +
                "      \"JC\": \"厨房水嘴\\\\DN15 台式明装 不锈钢 360°旋转\",\n" +
                "      \"ID\": \"1110059026252697603\",\n" +
                "      \"CREATE_TIME\": 1753770304000,\n" +
                "      \"INS_TIME\": 1753770305000\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        MdmMaterialDistributeDto dto = JSONObject.parseObject(params, MdmMaterialDistributeDto.class);
        System.out.println(dto);
    }


}
/**
 * MDM物料下发入参
 */
@Data
class MdmMaterialDistributeDto {

    private List<DistributeData> Parameters;

    @Data
    public static class DistributeData {

        private String WLBM;

        private String WLMC;

        private String LBBM;

        private String LBMC;

        private String JLDW;

        private String CREATOR_ACCOUNT;

        private String CREATOR_NAME;

        private String STATUS;

        private String QC;

        private String OPER_TYPE;

        private Integer VERSION;

        private String JC;

        private Long CREATE_TIME;

        private Long INS_TIME;

        private String FIELD7;

        private String FIELD9;

        private String FIELD10;

        private String FIELD11;

        private String FIELD12;

    }
}

