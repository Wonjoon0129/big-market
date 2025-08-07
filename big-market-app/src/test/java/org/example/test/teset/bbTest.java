package org.example.test.teset;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName bbTest
 * @Description
 * @Author @kimwonjoon
 * @Date 2025/7/30 13:16
 * @Version 1.0
 */

public class bbTest {
    @Test
    public void test(){
        String params="{\"headItem\":{\"list\":[{\"categoryName\":\"办公用品(1001-03)\",\"categoryNo\":\"1001-03\",\"maktx\":\"卡片\",\"matnr\":\"ZG1200002\"}]}}";
        MroSkuSyncDto dto = JSONObject.parseObject(params, MroSkuSyncDto.class);
        System.out.println(dto);
        System.out.println(JSONObject.toJSONString(dto));
        System.out.println(dto);

    }

}

@Data
class MroSkuSyncDto {

    private static final int SUCCESS = 0;

    private HeadItem headItem;

    @Data
    public static class HeadItem {
        private List<Item> list;
    }

    @Data
    public static class Item {
        private String matnr;

        private String maktx;

        private String categoryNo;

        private String categoryName;
    }
}
