package on.focus0147.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@XmlRootElement
public class Cat {
  private static Random random = new Random();
  private int id;
  private String name;

  public Cat() {
    this.id = random.nextInt();
    this.name = "Cat" + this.id;
  }
}
