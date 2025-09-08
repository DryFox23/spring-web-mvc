package bernadinusnaisau.spring.webmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

    private List<String> hobbies;
    private List<SocialMediaRequest> sosialMedias;

    private AddressPersonRequest address;
}
