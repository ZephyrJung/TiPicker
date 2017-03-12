package org.b3log.demo.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Zephyr on 2017/3/10.
 */
public class MultiTaskImpl {
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 10, 3, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());

    //另一种线程池
    ExecutorService pool = Executors.newFixedThreadPool(3);

    private TaskThread taskThread=new TaskThread();

    public static void main(String[] args){
        MultiTaskImpl taskImpl=new MultiTaskImpl();
        taskImpl.doTask();
    }
    public void doTask(){
        try{
            List<String> list=new ArrayList<String>();
            list.add("01 汉皇重色思倾国，御宇多年求不得。");
            list.add("02 杨家有女初长成，养在深闺人未识。");
            list.add("03 天生丽质难自弃，一朝选在君王侧。");
            list.add("04 回眸一笑百媚生，六宫粉黛无颜色。");
            list.add("05 春寒赐浴华清池，温泉水滑洗凝脂。");
            list.add("06 侍儿扶起娇无力，始是新承恩泽时。");
            list.add("07 云鬓花颜金步摇，芙蓉帐暖度春宵。");
            list.add("08 春宵苦短日高起，从此君王不早朝。");
            list.add("09 承欢侍宴无闲暇，春从春游夜专夜。");
            list.add("10 后宫佳丽三千人，三千宠爱在一身。");
            list.add("11 金屋妆成娇侍夜，玉楼宴罢醉和春。");
            list.add("12 姊妹弟兄皆列土，可怜光彩生门户。");
            list.add("13 遂令天下父母心，不重生男重生女。");
            list.add("14 骊宫高处入青云，仙乐风飘处处闻。");
            list.add("15 缓歌谩舞凝丝竹，尽日君王看不足。");
            list.add("16 渔阳鼙鼓动地来，惊破霓裳羽衣曲。");
            list.add("17 九重城阙烟尘生，千乘万骑西南行。");
            list.add("18 翠华摇摇行复止，西出都门百余里。");
            list.add("19 六军不发无奈何，宛转蛾眉马前死。");
            list.add("20 花钿委地无人收，翠翘金雀玉搔头。");
            list.add("21 君王掩面救不得，回看血泪相和流。");
            list.add("22 黄埃散漫风萧索，云栈萦纡登剑阁。");
            list.add("23 峨嵋山下少人行，旌旗无光日色薄。");
            list.add("24 蜀江水碧蜀山青，圣主朝朝暮暮情。");
            list.add("25 行宫见月伤心色，夜雨闻铃肠断声。");
            list.add("26 天旋地转回龙驭，到此踌躇不能去。");
            list.add("27 马嵬坡下泥土中，不见玉颜空死处。");
            list.add("28 君臣相顾尽沾衣，东望都门信马归。");
            list.add("29 归来池苑皆依旧，太液芙蓉未央柳。");
            list.add("30 芙蓉如面柳如眉，对此如何不泪垂。");
            list.add("31 春风桃李花开日，秋雨梧桐叶落时。");
            list.add("32 西宫南内多秋草，落叶满阶红不扫。");
            list.add("33 梨园弟子白发新，椒房阿监青娥老。");
            list.add("34 夕殿萤飞思悄然，孤灯挑尽未成眠。");
            list.add("35 迟迟钟鼓初长夜，耿耿星河欲曙天。");
            list.add("36 鸳鸯瓦冷霜华重，翡翠衾寒谁与共。");
            list.add("37 悠悠生死别经年，魂魄不曾来入梦。");
            list.add("38 临邛道士鸿都客，能以精诚致魂魄。");
            list.add("39 为感君王辗转思，遂教方士殷勤觅。");
            list.add("40 排空驭气奔如电，升天入地求之遍。");
            list.add("41 上穷碧落下黄泉，两处茫茫皆不见。");
            list.add("42 忽闻海上有仙山，山在虚无缥渺间。");
            list.add("43 楼阁玲珑五云起，其中绰约多仙子。");
            list.add("44 中有一人字太真，雪肤花貌参差是。");
            list.add("45 金阙西厢叩玉扃，转教小玉报双成。");
            list.add("46 闻道汉家天子使，九华帐里梦魂惊。");
            list.add("47 揽衣推枕起徘徊，珠箔银屏迤逦开。");
            list.add("48 云鬓半偏新睡觉，花冠不整下堂来。");
            list.add("49 风吹仙袂飘飘举，犹似霓裳羽衣舞。");
            list.add("50 玉容寂寞泪阑干，梨花一枝春带雨。");
            list.add("51 含情凝睇谢君王，一别音容两渺茫。");
            list.add("52 昭阳殿里恩爱绝，蓬莱宫中日月长。");
            list.add("53 回头下望人寰处，不见长安见尘雾。");
            list.add("54 惟将旧物表深情，钿合金钗寄将去。");
            list.add("55 钗留一股合一扇，钗擘黄金合分钿。");
            list.add("56 但教心似金钿坚，天上人间会相见。");
            list.add("57 临别殷勤重寄词，词中有誓两心知。");
            list.add("58 七月七日长生殿，夜半无人私语时。");
            list.add("59 在天愿作比翼鸟，在地愿为连理枝。");
            list.add("60 天长地久有时尽，此恨绵绵无绝期。");
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
            queue.addAll(list);
            int size = queue.size();
            CountDownLatch latch = new CountDownLatch(size);
            taskThread.setQueue(queue);
            taskThread.setCountDownLatch(latch);
            System.out.println("主线程输出，在多线程任务开始之前出现");
            for (int i = 0; i < size; i++) {
                threadPool.execute(taskThread);
            }
            System.out.println("主线程输出，在多线程开始执行后不定时出现");

            try {
                latch.await(5, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                System.out.println("MailTask doTask fail.");
            }
        }catch (Throwable t) {
            System.out.println("执行Task时出现异常");
            t.printStackTrace();
        }
        threadPool.shutdown();
    }
}
