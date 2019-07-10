package roman.pidkostelnyi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPagesController {

    @RequestMapping("category-page")
    public String category() {
        return "index.html";
    }

    @RequestMapping("catalog")
    public String catalog() {
        return "catalog.html";
    }

    @RequestMapping("/item")
    public String product() {
        return "product.html";
    }
}
