package bernadinusnaisau.spring.webmvc.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StringToBoolean implements Converter<String, Boolean> {

    private Boolean bool;

    @Override
    public Boolean convert(String source) {
        if (source.equals("admin")) {
            bool = true;
        }else {
            bool = false;
        }
        return bool;
    }
}
