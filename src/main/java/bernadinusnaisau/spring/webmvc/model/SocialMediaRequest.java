package bernadinusnaisau.spring.webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaRequest {

    private String socialMedia;

    private String urlSocialMedia;
}
