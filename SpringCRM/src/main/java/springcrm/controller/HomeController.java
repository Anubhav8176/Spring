package springcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.jdbcconfig.CustomerDao;
import springcrm.data.Customer;
import java.util.List;

@Controller
public class HomeController {

    public final CustomerDao customerDao;

    @Autowired
    public HomeController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Customer> singleCustomer = customerDao.getData();
        model.addAttribute("customer", singleCustomer);
        return "home";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "addCustomer";
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public String addUser(
            @RequestParam("c_id") int c_id,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {
        Customer customer = new Customer();
        customer.setC_id(c_id);
        customer.setName(name);
        customer.setEmail(email);
        customerDao.insert(customer);
        return "redirect:/";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("customerId") int id,
            Model m
    ){
        Customer newC =  customerDao.getCustomer(id);
        m.addAttribute("idU", newC.getC_id());
        m.addAttribute("nameU", newC.getName());
        m.addAttribute("emailU", newC.getEmail());
        return "updateCustomer";
    }

    @RequestMapping("updateCustomer")
    public String updateCustomer(
            @RequestParam("c_id") int c_id,
            @RequestParam("name") String name,
            @RequestParam("email") String email
    ){
        Customer toUpdate = new Customer(c_id, name, email);
        customerDao.update(toUpdate);
        return "redirect:/";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(
            @RequestParam("customerIdDelete") int c_id
    ){

        customerDao.delete(c_id);
        return "redirect:/";
    }

}