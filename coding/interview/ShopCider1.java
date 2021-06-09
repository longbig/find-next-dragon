package interview;

import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/8 4:47 下午
 * @description
 */
public class ShopCider1 {
    // 尺码排序
// 已知数据：
//[{"sku_id": 45378, "size": "XL"},
//    {"sku_id": 45273, "size": "M"},
//    {"sku_id": 45564, "size": "S"},
//    {"sku_id": 45890, "size": "L"},
//    {"sku_id": 45204, "size": "S"},
//    {"sku_id": 45130, "size": "2XL"},
//    {"sku_id": 45953, "size": "L"}]
//// 请按照 S<M<L<XL<2XL 的顺序进行排序
//            // 排序结果：
//            [{"sku_id": 45204, "size": "S"},
//    {"sku_id": 45564, "size": "S"},
//    {"sku_id": 45273, "size": "M"},
//    {"sku_id": 45953, "size": "L"},
//    {"sku_id": 45890, "size": "L"},
//    {"sku_id": 45378, "size": "XL"},
//    {"sku_id": 45130, "size": "2XL"}]
    public List<Sku> sort(List<Sku> skuList) {
        if (skuList == null || skuList.size() == 0) {
            return skuList;
        }
        String[] sortList = {"S", "M", "L", "XL", "2XL"};
        for (int i = 0; i < skuList.size(); i++) {
            for (int j = i; j < skuList.size(); j++) {
                if (!compareSize(skuList.get(i), skuList.get(j), sortList)) {
                    Sku temp = skuList.get(i);
                    skuList.set(i, skuList.get(j));
                    skuList.set(j, temp);
                }
            }
        }
        return skuList;
    }

    private boolean compareSize(Sku sku1, Sku sku2, String[] sortList) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < sortList.length; i++) {
            if (sortList[i].equals(sku1.size)) {
                index1 = i;
            }
            if (sortList[i].equals(sku2.size)) {
                index2 = i;
            }
        }
        return index1 <= index2;
    }


    class Sku {
        Integer id;
        String size;
    }


}
