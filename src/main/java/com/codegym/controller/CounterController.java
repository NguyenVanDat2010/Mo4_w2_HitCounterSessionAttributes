package com.codegym.controller;

import com.codegym.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//Annotation @SessionAttributes("mycounter") được sử dụng để lưu trữ model attribute trong session.
@SessionAttributes("mycounter")
public class CounterController {
    /* Trong đoạn mã trên, model attribute "mycounter" sẽ được thêm vào session nếu tên attribute
    của @ModelAttribute và @SessionAttributes giống nhau. */

    /* add MyCounter in model attribute */
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }

    /* Annotation @ModelAttribute liên kết một tham số phương thức hoặc một phương thức trả về
    giá trị cho một model attribute và sau đó trả nó về một view cụ thể.*/
    @GetMapping("/")
    public String getCounter(@ModelAttribute("mycounter")MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}
