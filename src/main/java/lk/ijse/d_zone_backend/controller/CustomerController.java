package lk.ijse.d_zone_backend.controller;

import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://dinildamsith.github.io")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }

    @PutMapping(value = "/{updateCustomerId}",produces = "application/json" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    String updateCustomer(@Validated  @PathVariable ("updateCustomerId") String updateCustomerId , @RequestBody CustomerDTO customerDTO){
        String massage = customerService.updateCustomer(updateCustomerId, customerDTO);
        return massage;
    }

    @GetMapping( "/{searchCustomerId}")
    CustomerDTO searchCustomer(@PathVariable ("searchCustomerId") String searchCustomerId){
        CustomerDTO customerDTO = customerService.searchCustomer(searchCustomerId);
        return customerDTO;

    }

    @DeleteMapping("/{deleteCustomerId}")
    String deleteCustomer(@PathVariable ("deleteCustomerId") String deleteCustomerId){
        String deleteCustomer = customerService.deleteCustomer(deleteCustomerId);
        return deleteCustomer;

    }

    @GetMapping
    List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return allCustomer;
    }

}
