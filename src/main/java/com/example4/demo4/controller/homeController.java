package com.example4.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example4.demo4.Service.CategoryService;
import com.example4.demo4.Service.ExpenseService;
import com.example4.demo4.Service.registerService;
import com.example4.demo4.model.Category;
import com.example4.demo4.model.Expense;
import com.example4.demo4.model.registerModel;

@Controller
public class homeController {

    private String login_value;
    private ExpenseService expenseService;
    private CategoryService categoryService;
    private registerService regService;
    public homeController(registerService regService,CategoryService categoryService,ExpenseService expenseService) {
        this.regService = regService;
        this.categoryService=categoryService;
        this.expenseService=expenseService;
        this.login_value="0";
    }
    @RequestMapping("/")
    public String home(){
        return "home.html";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new registerModel());
        return "register.html";
    }
   
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginRequest", new registerModel());
        return "login.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute registerModel regModel){
        System.out.println("registerRequest" + regModel);
        registerModel registeredUser = regService.registerUser(regModel.getEmail(), regModel.getPassword(), regModel.getFname(), regModel.getLname());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute registerModel regModel){
        System.out.println("loginRequest" + regModel);
        registerModel authenticated = regService.authenticate(regModel.getEmail(), regModel.getPassword());
        if(authenticated!= null){
            this.login_value="1";
    

            return "redirect:"+"/showexpenses";
        }
        else{
            return "error_page";
        }
    }

    @GetMapping("/addcategory")
    public  String addCategory(Model model){
        if (this.login_value=="1"){
        model.addAttribute("categoryadd",new Category());
        return "add_category";}
        else{
            return "login";
        }

    }
    @PostMapping("/addcategory")
    public  String addCategory(@ModelAttribute Category  category,Model model){
        if (this.login_value=="1"){
        try{
        Category catu= categoryService.saveCategory(category.getCategory_name(),category.getCategory_id());
        if (catu==null){
            model.addAttribute("anyerror","id and categoty name should be unique");
        }
        else{
            model.addAttribute("anyerror","Category Added Succesfully");
        }
        return "add_category";}
        catch(Exception e){
            model.addAttribute("anyerror","category or id is already present in the list");
            return "add_category";
        }}
        else{
            return "login";
        }

    }
    @GetMapping("/showcategories")
    public String listCategory(Model model){
        if(this.login_value=="1"){
        model.addAttribute("list",categoryService.allcategories());
        return "show_category";}
        else{
            return "login";
        }
    }
    @GetMapping("/addexpense")
    public String addexpense(Model model){
        if(this.login_value=="1"){
            model.addAttribute("newexpense", new Expense());
            return "add_expense";
            
        }
        else{return "login";}
       

    }
    @PostMapping("/addexpense")
    public String addexpense(@ModelAttribute  Expense expense,Model model){
            try{
             Expense es=expenseService.addexpense(expense.getExpense_id(), expense.getDate(), expense.getDescription(), expense.getLocation(), expense.getCategoryid());
             if (es==null){

                model.addAttribute("anyerror"," Exepnse not added! please fill all the blanks or make sure category with respective id exists");
            }
            else{
                model.addAttribute("anyerror","Expense  Added Succesfully");
            }
            return "add_expense";
        }
        catch (Exception e){
            model.addAttribute("anyerror","expense id already present ");
            return "redirect:"+"/showexpenses";

        }
    }
    @GetMapping("/showexpenses")
    public String listexpenses(Model model){
    
        model.addAttribute("list",expenseService.allexpenses());
        return "show_expenses";}
       
    
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:"+"/login";
    }
    

    
    
}
