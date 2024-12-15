package algorithm;

/**
 * @author yuyunlong
 * @date 2024/12/5 00:05
 * @description 实现位图的两个方法，put方法往里面插入数据，exist方法判断value在位图里是否存在
 */
public class BitMap {

    private byte[] bitmap;
    private int size;

    public BitMap(int size) {
        this.size = size;
        this.bitmap = new byte[(size >> 3) + 1];
    }

    public void put(int value) {
        if (value < 0 || value > size) {
            throw new IllegalArgumentException("Value out of range");
        }
        //等价 value / 8 确定在数组的下标
        int byteIndex = value >> 3;
        //等价 value % 8 确定在byte元素中的下标
        int bitIndex = value & 7;
        //是位或赋值运算，作用是将对应位设置为 1，而其他位保持不变
        // 1 << bitIndex 将对应位置设为1，如value是3，则值为 00001000；
        bitmap[byteIndex] |= (1 << bitIndex);
    }

    public boolean exist(int value) {
        if (value < 0 || value > size) {
            throw new IllegalArgumentException("Value out of range");
        }
        //等价 value / 8 确定在数组的下标
        int byteIndex = value >> 3;
        //等价 value % 8 确定在byte元素中的下标
        int bitIndex = value & 7;
        return (bitmap[byteIndex] & (1 << bitIndex)) != 0;
    }

}
