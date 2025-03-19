package algorithm;

import java.util.*;

/**
 * 红包随机算法
 *
 * 例如一个人在群里发了100块钱的红包，群里有10个人一起来抢红包，每人抢到的金额随机分配。
 * 红包功能需要满足哪些具体规则呢？
 * 1. 所有人抢到的金额之和要等于红包金额，不能多也不能少。
 * 2. 每个人至少抢到1分钱。
 * 3. 要保证红包拆分的金额尽可能分布均衡，不要出现两极分化太严重的情况。
 * 4. 最佳手气不超过90%总金额
 */
public class RedEnvelop {


    /**
     * 随机分配法
     */
    public static List<Double> generate(double totalMoney, int people) {
        // 转换为分处理避免浮点误差
        double totalCents = Math.round(totalMoney * 100);
        double maxLimit = (totalCents * 0.9); // 总金额的90%
        double leaveMoney = totalCents;
        List<Double> result = new ArrayList<>();
        //判断钱够不够分
        if ((int)totalCents < people) {
            return result;
        }
        Random random = new Random();

        //每次生成随机数
        int n = people - 1;
        while (n > 0) {
            //随机数在[1, min(maxLimit, leaveMoney)]之间，单位是:分
            double min = Math.min(leaveMoney, maxLimit);
            double allocResult = (1 + random.nextInt((int)min));
            if (allocResult > maxLimit || (leaveMoney - allocResult) < n) {
                continue;
            }
            leaveMoney -= allocResult;
            n--;
            result.add(allocResult / 100.0);
        }
        result.add(leaveMoney / 100.0);
        return result;
    }

    /**
     * 二倍均值法
     */
    public static List<Double> allocateRedEnvelop(double totalMoney, int people) {
        // 转换为分处理避免浮点误差
        double totalCents = Math.round(totalMoney * 100);
        double maxLimit = (totalCents * 0.9); // 总金额的90%
        Random random = new Random();
        double leaveMoney = totalCents;
        List<Double> result = new ArrayList<>();
        int n = people;
        //注意是大于1，最后1个人领取剩余的钱
        while (n > 1) {
            //生成随机金额的范围是[1, leaveMoney / n * 2 - 1]， 注意nextInt方法生成结果范围是左闭右开的
            double allocatMoney = 1 + random.nextInt((int)leaveMoney / n * 2 - 1);
            result.add(allocatMoney / 100.0);
            n--;
            leaveMoney -= allocatMoney;
        }

        result.add(leaveMoney / 100.0);

        return result;
    }

    /**
     * 线段切割法
     */
    public static List<Double> allocateRedEnvelopNew(double totalMoney, int people) {
        // 转换为分处理避免浮点误差
        double totalCents = Math.round(totalMoney * 100);
        double maxLimit = (totalCents * 0.9); // 总金额的90%
        Random random = new Random();
        double leaveMoney = totalCents;
        List<Double> result = new ArrayList<>();
        Set<Integer> pointCutSet = new HashSet<>();
        int n = people;
        while (pointCutSet.size() < people - 1) {
            //生成n - 1个切割点，随机点取值范围是[1, totalCents]
            pointCutSet.add(random.nextInt((int) totalCents) + 1);
        }
        //接着生成对应子线段的钱数
        Integer[] points = pointCutSet.toArray(new Integer[0]);
        Arrays.sort(points);
        result.add(points[0] / 100.0);
        //子线段+ 最后那段的长度 = totalCents，注意上一步是已经加了points[0]，result中的所有元素和累加后的结果一定是totalCents,
        for (int i = 1; i < points.length; i++) {
            result.add((points[i] - points[i - 1]) / 100.0);
        }
        result.add((totalCents - points[points.length - 1]) / 100.0);
        return result;
    }

        // 示例用法
    public static void main(String[] args) {
        List<Double> redPackets = allocateRedEnvelopNew(100, 10);
        System.out.println("红包分配结果：");
        System.out.println(redPackets);

        double max = redPackets.stream()
                .mapToDouble(Double::doubleValue)
                .max().orElse(0);
        System.out.printf("手气最佳：%.2f元（占比%.2f%%）",
                max, (max / 100) * 100);
    }
}
