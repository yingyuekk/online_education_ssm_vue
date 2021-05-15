package cn.xq.notp.demo;

import org.springframework.stereotype.Component;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/18
 */
@Component("demoComponent")
public class DemoComponent {

    /*
    * 泛指各种组件，就是说当我们的类不属于各种归类的时候
    * （不属于@Controller、@Services等的时候），
    * 就可以使用@Component来标注这个类。
     * */

    public String demo(){
        return "demo  +  Component";
    }
}
