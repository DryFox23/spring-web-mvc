package bernadinusnaisau.spring.webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private List<String> hobbies;
    private List<SocialMediaRequest> sosialMedias;

    private AddressPersonRequest address;
}
