package bernadinusnaisau.spring.webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPersonRequest {
    private String street;
    private String city;
    private String state;
}
