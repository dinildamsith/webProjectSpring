package lk.ijse.d_zone_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity{
    @Id
    private String cust_Id;
    private String cust_Name;
    private String cust_Mail;
    private String cust_Address;
}
