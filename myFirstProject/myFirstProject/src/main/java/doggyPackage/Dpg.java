package doggyPackage;
import com.edigest.myFirstProject.Qerty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/ok")
public class Dpg {

    @Autowired
    private Qerty qerty;

public String ok(){
    return qerty.mm();
}

}
