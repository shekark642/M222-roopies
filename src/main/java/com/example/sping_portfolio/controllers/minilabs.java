package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sping_portfolio.Minilab.Fib;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class minilabs {
    @GetMapping("/minilab1")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String chris(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "Minilab/minilab1"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/binary")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String Binary(@RequestParam(name = "bits", required = false, defaultValue = "8") int bits, Model model) {
        model.addAttribute("bits", bits); // MODEL is passed to html
        return "Minilab/minilab2"; // returns HTML VIEW ()
    }

    @GetMapping("/fib")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String Fib(@RequestParam(name = "word", required = false, defaultValue = "") String word, Model model) {
        if(Fib.checkPalindrome(word)) {
            System.out.println(word + " palindrome");
            // uses ${message} from inputted date on minilab3.html and prints the word with " is a palindrome"
            model.addAttribute("message", word + " is a palindrome"); // MODEL is passed to html
        } else {
            System.out.println(word + " not a palindrome");
            // uses ${message} from inputted data on minilab3.html and prints the word with " is not a palindrome"
            model.addAttribute("message",word + " is not a palindrome" );
        }

        return "Minilab/minilab3"; // returns HTML VIEW ()
    }
}