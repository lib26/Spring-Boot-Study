package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // view 위치 : resources/templates/response/hello
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    // view 위치 : resources/templates/response/hello
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; // 논리적 view 이름을 반환하면 뷰 리졸버가 찾아준다
    }

    // view 위치 : resources/templates/response/hello
    // 요청 경로인 /response/hello 과 뷰의 위치 경로가 같다면 이렇게 return을 생략해도 되지만
    // 너무 불명확하기에 권장하지 않는다
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}