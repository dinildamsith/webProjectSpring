package lk.ijse.d_zone_backend.controller;

import lk.ijse.d_zone_backend.dto.CustomerDTO;
import lk.ijse.d_zone_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }

    @PutMapping(produces = "application/json")
    void updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
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

}
