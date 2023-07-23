package com.ruida;

interface IEat {									// 定义核心业务标准
    public void get();							// 业务方法
}
class EatReal implements IEat {					// 定义真实主题类
    public void get() {							// 核心实现
        System.out.println("【真实主题】得到一份食物，而后开始品尝美味。");
    }
}
class EatProxy implements IEat { 					// 定义代理主题类
    private IEat eat; 							// 核心业务实例
    public EatProxy(IEat eat) { 					// 设置代理项
        this.eat = eat;
    }
    public void get() {							// 代理实现方法
        this.prepare();							// 业务执行前的准备
        this.eat.get();							// 【真实业务】调用核心业务操作
        this.clear();							// 业务执行后的处理
    }
    public void prepare() { 						// 【代理操作】准备过程
        System.out.println("【代理主题】1、精心购买食材。");
        System.out.println("【代理主题】2、小心的处理食材。");
    }
    public void clear() { 						// 【代理操作】收尾处理
        System.out.println("【代理主题】3、收拾碗筷。");
    }
}
public class JavaDemo {
    public static void main(String args[]) {
        IEat eat = new EatProxy(new EatReal());	// 获取代理对象，同时传入被代理者
        eat.get();								// 调用代理方法
    }
}
